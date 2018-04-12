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
public class MonthlyEmployeeTest {

    @Test
    void shouldReturnFalseForNonWorkingDay() {
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        assertFalse(monthlyEmployee.isPayDay(LocalDate.of(2018, 6, 30)));
        assertFalse(monthlyEmployee.isPayDay(LocalDate.of(2018, 5, 30)));
    }

    @Test
    void shouldReturnTrueForWorkingDay() {
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        assertTrue(monthlyEmployee.isPayDay(LocalDate.of(2018, 6, 29)));
        assertTrue(monthlyEmployee.isPayDay(LocalDate.of(2018, 4, 30)));
    }

    @Test
    void shouldReturnFirstDayOfTheMonth() {
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        assertEquals(LocalDate.of(2018, 4, 1),
                monthlyEmployee.getFirstDayOfWorkingPeriod(LocalDate.of(2018, 4, 30)));
        assertEquals(LocalDate.of(2018, 6, 1),
                monthlyEmployee.getFirstDayOfWorkingPeriod(LocalDate.of(2018, 6, 29)));
    }

    @Test
    void shouldReturnZeroForNonPayDay() {
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        assertTrue(BigDecimal.ZERO
                .compareTo(monthlyEmployee.getSalary(LocalDate.of(2018, 4, 1))) == 0);
    }

    @Test
    void shouldReturnSalaryForPayDay() {
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        assertTrue(BigDecimal.ONE
                .compareTo(monthlyEmployee.getSalary(LocalDate.of(2018, 4, 30))) == 0);
    }

}
