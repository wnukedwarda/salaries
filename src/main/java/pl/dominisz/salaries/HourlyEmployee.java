package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class HourlyEmployee extends Employee {

    private BigDecimal hourlyRate;

    @Override
    protected BigDecimal computeSalary(LocalDate date) {
        return BigDecimal.ZERO;
    }

    @Override
    protected LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return null;
    }

    @Override
    protected boolean isPayDay(LocalDate date) {
        return false;
    }

}
