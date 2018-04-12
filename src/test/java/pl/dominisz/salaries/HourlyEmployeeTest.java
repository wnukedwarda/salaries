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
public class HourlyEmployeeTest {

    @Test
    void testIsPayDay() {
        Employee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ZERO);
        assertTrue(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 13)));
        assertFalse(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 12)));
    }

}
