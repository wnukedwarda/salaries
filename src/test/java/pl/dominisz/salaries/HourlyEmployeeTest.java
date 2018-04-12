package pl.dominisz.salaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * http://dominisz.pl
 * 12.04.2018
 */
public class HourlyEmployeeTest {

    @Test
    void testIsPayDay() {
        Employee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ZERO);
        assertTrue(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 13)));
        assertFalse(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 12)));
    }

    @Test
    void testFindFirstWorkingDay() {
        Employee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ZERO);
        LocalDate expectedDate = LocalDate.of(2018, 4, 9);
        LocalDate actualDate = hourlyEmployee.getFirstDayOfWorkingPeriod(LocalDate.of(2018, 4 ,13));
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void shouldReturnZeroWhenNotFriday() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018, 4, 12), 8);
        hourlyEmployee.addWorkingDay(workingDay);
        assertEquals(BigDecimal.ZERO, hourlyEmployee.getSalary(LocalDate.of(2018, 4, 12)));
    }

    @Test
    void shouldReturnSalaryForOneDay() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018, 4, 12), 8);
        hourlyEmployee.addWorkingDay(workingDay);
        assertEquals(new BigDecimal(8), hourlyEmployee.getSalary(LocalDate.of(2018, 4, 13)));
    }

    @Test
    void shouldReturnOverhourSalaryForOneDay() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018, 4, 12), 12);
        hourlyEmployee.addWorkingDay(workingDay);
        BigDecimal expectedSalary = new BigDecimal(14);
        BigDecimal actualSalary = hourlyEmployee.getSalary(LocalDate.of(2018, 4, 13));
        assertTrue(expectedSalary.compareTo(actualSalary) == 0);
    }

    @Test
    void shouldReturnOverhourSalaryForOneDayWithoutOtherDays() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018, 4, 12), 12);
        WorkingDay earlierDay = new WorkingDay(LocalDate.of(2018, 4, 1), 8);
        WorkingDay laterDay = new WorkingDay(LocalDate.of(2018, 4, 15), 8);
        hourlyEmployee.addWorkingDay(workingDay);
        hourlyEmployee.addWorkingDay(earlierDay);
        hourlyEmployee.addWorkingDay(laterDay);
        BigDecimal expectedSalary = new BigDecimal(14);
        BigDecimal actualSalary = hourlyEmployee.getSalary(LocalDate.of(2018, 4, 13));
        assertTrue(expectedSalary.compareTo(actualSalary) == 0);
    }
}
