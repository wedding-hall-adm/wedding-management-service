package pl.wedding.management.employee.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeDto {
    private final long id;
    private final String name;
    private final String surname;
    private final Object workPlace;
    private final PositionEmployee position;
    private final Salary salary;
    private final StatusEmployee statusEmployee;
    private final TypeOfContract typeOfContract;
}
