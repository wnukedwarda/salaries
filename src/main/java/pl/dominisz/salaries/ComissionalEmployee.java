package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class ComissionalEmployee extends Employee {

    private BigDecimal salary;
    private BigDecimal commision;

    public ComissionalEmployee(String name, BigDecimal salary, BigDecimal commision) {
        super(name);
        this.salary = salary;
        this.commision = commision;
    }

    @Override
    public BigDecimal computeSalary(LocalDate date) {
        return BigDecimal.ZERO;
    }

    @Override
    public LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return null;
    }

    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }

}
