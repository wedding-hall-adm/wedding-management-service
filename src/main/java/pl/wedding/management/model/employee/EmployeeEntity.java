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

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    @SequenceGenerator(name = "employee_sequence")
    private long id;
    private String name;
    private String surname;
    private Object workPlace;
    @Enumerated(EnumType.STRING)
    private PositionEmployee position;
    private Salary salary;
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;
    @Enumerated(EnumType.STRING)
    private TypeOfContract typeOfContract;

}
