package pl.dominisz.salaries;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
@Getter
@AllArgsConstructor
public class Invoice {

    private LocalDate date;
    private BigDecimal value;

    //TODO between

}
