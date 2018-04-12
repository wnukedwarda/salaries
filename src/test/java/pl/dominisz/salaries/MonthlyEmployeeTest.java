package pl.dominisz.salaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
