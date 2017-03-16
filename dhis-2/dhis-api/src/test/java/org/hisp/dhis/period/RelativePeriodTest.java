package org.hisp.dhis.period;

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

import org.hisp.dhis.calendar.DateTimeUnit;
import org.hisp.dhis.i18n.I18nFormat;
import org.hisp.dhis.mock.MockI18nFormat;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Lars Helge Overland
 */
public class RelativePeriodTest
{
    private static final I18nFormat I18N_FORMAT = new MockI18nFormat();

    private static Date getDate( int year, int month, int day )
    {
        return new DateTimeUnit( year, month, day, true ).toJdkDate();
    }

    @Test
    public void getRelativePeriods()
    {
        RelativePeriods periods = new RelativePeriods( true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true );

        List<Period> relatives = periods.getRelativePeriods( getDate( 2001, 1, 1 ), I18N_FORMAT, false );

        assertEquals( 157, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 1, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 2, 1 ), getDate( 2001, 2, 28 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 3, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 5, 1 ), getDate( 2001, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 6, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 7, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 8, 1 ), getDate( 2001, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 9, 1 ), getDate( 2001, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 10, 1 ), getDate( 2001, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 11, 1 ), getDate( 2001, 11, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 12, 1 ), getDate( 2001, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2000, 3, 1 ), getDate( 2000, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2000, 5, 1 ), getDate( 2000, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2000, 9, 1 ), getDate( 2000, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2000, 11, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new BiMonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 2, 28 ) ) ) );

        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 10, 1 ), getDate( 2001, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new SixMonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new SixMonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 6, 30 ) ) ) );

        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 1, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 2, 1 ), getDate( 2000, 2, 29 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 3, 1 ), getDate( 2000, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 4, 1 ), getDate( 2000, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 5, 1 ), getDate( 2000, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 6, 1 ), getDate( 2000, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 7, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 8, 1 ), getDate( 2000, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 9, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 10, 1 ), getDate( 2000, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 11, 1 ), getDate( 2000, 11, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 12, 1 ), getDate( 2000, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 4, 1 ), getDate( 2000, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 10, 1 ), getDate( 2000, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1997, 1, 1 ), getDate( 1997, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1998, 1, 1 ), getDate( 1998, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1999, 1, 1 ), getDate( 1999, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 12, 31 ) ) ) );

        assertTrue( relatives.contains( new Period( new FinancialOctoberPeriodType(), getDate( 1996, 10, 1 ), getDate( 1997, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new FinancialOctoberPeriodType(), getDate( 1997, 10, 1 ), getDate( 1998, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new FinancialOctoberPeriodType(), getDate( 1998, 10, 1 ), getDate( 1999, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new FinancialOctoberPeriodType(), getDate( 1999, 10, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new FinancialOctoberPeriodType(), getDate( 2000, 10, 1 ), getDate( 2001, 9, 30 ) ) ) );

        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2000, 1, 10 ), getDate( 2000, 1, 16 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2000, 1, 17 ), getDate( 2000, 1, 23 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2000, 1, 24 ), getDate( 2000, 1, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 1, 7 ) ) ) );
    }

    @Test
    public void testGetRewindedRelativePeriods()
    {
        RelativePeriods periods = new RelativePeriods().setLast12Months( true );

        List<Period> relatives = periods.getRewindedRelativePeriods( 1, getDate( 2001, 7, 15 ), I18N_FORMAT, false );

        assertEquals( 12, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 7, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 8, 1 ), getDate( 2000, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 9, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 10, 1 ), getDate( 2000, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 11, 1 ), getDate( 2000, 11, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 12, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 1, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 2, 1 ), getDate( 2001, 2, 28 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 3, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 5, 1 ), getDate( 2001, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 6, 1 ), getDate( 2001, 6, 30 ) ) ) );
    }

    @Test
    public void testGetLast12Months()
    {
        List<Period> relatives = new RelativePeriods().setLast12Months( true ).getRelativePeriods( getDate( 2001, 1, 1 ), null, false );

        assertEquals( 12, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 2, 1 ), getDate( 2000, 2, 29 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 3, 1 ), getDate( 2000, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 4, 1 ), getDate( 2000, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 5, 1 ), getDate( 2000, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 6, 1 ), getDate( 2000, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 7, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 8, 1 ), getDate( 2000, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 9, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 10, 1 ), getDate( 2000, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 11, 1 ), getDate( 2000, 11, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2000, 12, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 1, 31 ) ) ) );
    }

    @Test
    public void testGetLast3Months()
    {
        RelativePeriods relativePeriods = new RelativePeriods().setLast3Months( true );

        List<Period> relatives = relativePeriods.getRelativePeriods( getDate( 2001, 7, 1 ), null, false );

        assertEquals( 3, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 5, 1 ), getDate( 2001, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 6, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 7, 31 ) ) ) );
    }

    @Test
    public void testGetLast6Months()
    {
        RelativePeriods relativePeriods = new RelativePeriods().setLast6Months( true );

        List<Period> relatives = relativePeriods.getRelativePeriods( getDate( 2001, 7, 1 ), null, false );

        assertEquals( 6, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 2, 1 ), getDate( 2001, 2, 28 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 3, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 5, 1 ), getDate( 2001, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 6, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 7, 31 ) ) ) );
    }

    @Test
    public void testGetLast4Quarters()
    {
        List<Period> relatives = new RelativePeriods().setLast4Quarters( true ).getRelativePeriods( getDate( 2001, 1, 1 ), null, false );

        assertEquals( 4, relatives.size() );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 4, 1 ), getDate( 2000, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2000, 10, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 3, 31 ) ) ) );
    }

    @Test
    public void testGetLast2SixMonths()
    {
        List<Period> relatives = new RelativePeriods().setLast2SixMonths( true ).getRelativePeriods( getDate( 2001, 1, 1 ), null, false );

        assertEquals( 2, relatives.size() );
        assertTrue( relatives.contains( new Period( new SixMonthlyPeriodType(), getDate( 2000, 7, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new SixMonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 6, 30 ) ) ) );
    }

    @Test
    public void testGetLast5Years()
    {
        List<Period> relatives = new RelativePeriods().setLast5Years( true ).getRelativePeriods( getDate( 2001, 1, 1 ), null, false );

        assertEquals( 5, relatives.size() );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1997, 1, 1 ), getDate( 1997, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1998, 1, 1 ), getDate( 1998, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 1999, 1, 1 ), getDate( 1999, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2000, 1, 1 ), getDate( 2000, 12, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new YearlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 12, 31 ) ) ) );
    }

    @Test
    public void testGetLast52Weeks()
    {
        List<Period> relatives = new RelativePeriods().setLast52Weeks( true ).getRelativePeriods( getDate( 2001, 12, 14 ), null, false );

        assertEquals( 52, relatives.size() );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2001, 12, 10 ), getDate( 2001, 12, 16 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2001, 12, 3 ), getDate( 2001, 12, 9 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2000, 12, 18 ), getDate( 2000, 12, 24 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2000, 12, 25 ), getDate( 2000, 12, 31 ) ) ) );
    }

    @Test
    public void testGetMonthsThisYear()
    {
        List<Period> relatives = new RelativePeriods().setMonthsThisYear( true ).getRelativePeriods( getDate( 2001, 4, 1 ), null, false );

        assertEquals( 12, relatives.size() );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 1, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 2, 1 ), getDate( 2001, 2, 28 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 3, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 4, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 5, 1 ), getDate( 2001, 5, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 6, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 7, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 8, 1 ), getDate( 2001, 8, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 9, 1 ), getDate( 2001, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 10, 1 ), getDate( 2001, 10, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 11, 1 ), getDate( 2001, 11, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new MonthlyPeriodType(), getDate( 2001, 12, 1 ), getDate( 2001, 12, 31 ) ) ) );
    }

    @Test
    public void testGetThisWeek()
    {
        List<Period> relatives = new RelativePeriods().setThisWeek( true ).getRelativePeriods( getDate( 2012, 1, 20 ), null, false );

        assertEquals( 1, relatives.size() );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2012, 1, 16 ), getDate( 2012, 1, 22 ) ) ) );
    }

    @Test
    public void testGetLastWeek()
    {
        List<Period> relatives = new RelativePeriods().setLastWeek( true ).getRelativePeriods( getDate( 2012, 1, 20 ), null, false );

        assertEquals( 1, relatives.size() );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2012, 1, 9 ), getDate( 2012, 1, 15 ) ) ) );
    }

    @Test
    public void testGetLast4Weeks()
    {
        List<Period> relatives = new RelativePeriods().setLast4Weeks( true ).getRelativePeriods( getDate( 2012, 1, 20 ), null, false );

        assertEquals( 4, relatives.size() );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2012, 1, 16 ), getDate( 2012, 1, 22 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2012, 1, 9 ), getDate( 2012, 1, 15 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2012, 1, 2 ), getDate( 2012, 1, 8 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2011, 12, 26 ), getDate( 2012, 1, 1 ) ) ) );

        relatives = new RelativePeriods().setLast4Weeks( true ).getRelativePeriods( getDate( 2010, 5, 4 ), null, false );

        assertEquals( 4, relatives.size() );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2010, 5, 3 ), getDate( 2010, 5, 9 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2010, 4, 26 ), getDate( 2010, 5, 2 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2010, 4, 19 ), getDate( 2010, 4, 25 ) ) ) );
        assertTrue( relatives.contains( new Period( new WeeklyPeriodType(), getDate( 2010, 4, 12 ), getDate( 2010, 4, 18 ) ) ) );
    }

    @Test
    public void testGetQuartersThisYear()
    {
        List<Period> relatives = new RelativePeriods().setQuartersThisYear( true ).getRelativePeriods( getDate( 2001, 4, 1 ), null, false );

        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 1, 1 ), getDate( 2001, 3, 31 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 4, 1 ), getDate( 2001, 6, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 7, 1 ), getDate( 2001, 9, 30 ) ) ) );
        assertTrue( relatives.contains( new Period( new QuarterlyPeriodType(), getDate( 2001, 10, 1 ), getDate( 2001, 12, 31 ) ) ) );
    }

    @Test
    public void testGetRelativePeriods()
    {
        List<Period> relatives = new RelativePeriods().setLast12Months( true ).getRelativePeriods();

        assertEquals( 12, relatives.size() );

        relatives = new RelativePeriods().setLast4Quarters( true ).getRelativePeriods( I18N_FORMAT, true );

        assertEquals( 4, relatives.size() );
    }

    @Test
    public void testGetRelativePeriodsFromPeriodTypes()
    {
        Set<String> periodTypes = new HashSet<>();
        periodTypes.add( MonthlyPeriodType.NAME );
        periodTypes.add( BiMonthlyPeriodType.NAME );
        periodTypes.add( QuarterlyPeriodType.NAME );
        periodTypes.add( SixMonthlyPeriodType.NAME );
        periodTypes.add( YearlyPeriodType.NAME );
        periodTypes.add( FinancialOctoberPeriodType.NAME );

        List<Period> periods = new RelativePeriods().getLast12Months( periodTypes );

        assertEquals( 26, periods.size() );
    }
}
