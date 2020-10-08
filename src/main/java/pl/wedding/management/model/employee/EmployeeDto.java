package pl.wedding.management.model.employee;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
class EmployeeDto {
    private long id;
    private String name;
    private String surname;
    private String workPlace;
    private String position;
    private BigDecimal salary;
    private StatusEmployee statusEmployee;
}
