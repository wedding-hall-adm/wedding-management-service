package pl.wedding.management.model.employee;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Salary {

    private final int typeOfWork;
    private final BigDecimal rate;

}
