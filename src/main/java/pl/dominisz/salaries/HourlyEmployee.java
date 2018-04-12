package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class HourlyEmployee extends Employee {

    private static final int STANDARD_HOURS = 8;
    private static final BigDecimal OVERHOUR_RATE = new BigDecimal("1.5");

    private BigDecimal hourlyRate;
    private List<WorkingDay> workingDays;

    @Override
    protected BigDecimal computeSalary(LocalDate date) {
        LocalDate firstDay = getFirstDayOfWorkingPeriod(date);
        List<WorkingDay> salariedDays = findWorkingDays(firstDay, date);
        return computeSalary(salariedDays);
    }

    @Override
    protected LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return date.minusDays(4);
    }

    @Override
    protected boolean isPayDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

}
