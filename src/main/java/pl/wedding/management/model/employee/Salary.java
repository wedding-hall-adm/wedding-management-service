package pl.wedding.management.model.employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
class Salary {

    BigDecimal finalSalary;
    TypeOfContract TypeOfContract;
    StatusEmployee statusEmployee;
    int workingHours;
    BigDecimal rate;

}
