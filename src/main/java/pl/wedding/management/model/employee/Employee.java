package pl.wedding.management.model.employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@Builder
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    @SequenceGenerator(name = "employee_sequence")
    private long id;
    private String name;
    private String surname;
    private String workPlace;/* można zmienic na inną klasę, która będzie danym miejscem pracy
    i zrobić relacje w bazach danych*/
    private String position;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;

    static Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setWorkPlace(employeeDto.getWorkPlace());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        employee.setStatusEmployee(employeeDto.getStatusEmployee());
        return employee;
    }
}
