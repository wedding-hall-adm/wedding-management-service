package pl.wedding.management.model.employee;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
class Salary {

    private final BigDecimal finalSalary;
    private final TypeOfContract TypeOfContract;
    private final StatusEmployee statusEmployee;
    private final int workingHours;
    private final BigDecimal rate;

}
