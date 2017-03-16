package org.hisp.dhis.importexport.importer;

/*
 * Copyright (c) 2004-2015, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.amplecode.quick.BatchHandler;
import org.hisp.dhis.dataelement.DataElementCategoryOption;
import org.hisp.dhis.dataelement.DataElementCategoryService;
import org.hisp.dhis.importexport.GroupMemberType;
import org.hisp.dhis.importexport.ImportParams;
import org.hisp.dhis.importexport.Importer;
import org.hisp.dhis.importexport.mapping.NameMappingUtil;

/**
 * @author Lars Helge Overland
 * @version $Id$
 */
public class DataElementCategoryOptionImporter
    extends AbstractImporter<DataElementCategoryOption> implements Importer<DataElementCategoryOption>
{
    protected DataElementCategoryService categoryService;

    public DataElementCategoryOptionImporter()
    {
    }
    
    public DataElementCategoryOptionImporter( BatchHandler<DataElementCategoryOption> batchHandler, DataElementCategoryService categoryService )
    {
        this.batchHandler = batchHandler;
        this.categoryService = categoryService;
    }
    
    @Override
    public void importObject( DataElementCategoryOption object, ImportParams params )
    {        
        NameMappingUtil.addCategoryOptionMapping( object.getId(), object.getName() );
        
        read( object, GroupMemberType.NONE, params );
    }

    @Override
    protected void importUnique( DataElementCategoryOption object )
    {
        batchHandler.addObject( object );        
    }

    @Override
    protected void importMatching( DataElementCategoryOption object, DataElementCategoryOption match )
    {
        match.setCode(object.getCode());
        match.setUid( object.getUid());
        match.setName( object.getName());

        categoryService.updateDataElementCategoryOption( match );
    }

    @Override
    protected DataElementCategoryOption getMatching( DataElementCategoryOption object )
    {
        return categoryService.getDataElementCategoryOptionByName( object.getName() );
    }

    @Override
    protected boolean isIdentical( DataElementCategoryOption object, DataElementCategoryOption existing )
    {
        boolean codeMatch = true;
        boolean uidMatch = true;

        // if there is a code that must also match
        if (object.getCode() != null) {
            codeMatch = object.getCode().equals( existing.getCode());
        }
        // if there is a uid that must also match
        if (object.getUid() != null) {
            uidMatch = object.getUid().equals( existing.getUid());
        }

        return (object.getName().equals( existing.getName()) && codeMatch && uidMatch);
    }
}
