package pl.wedding.management.model.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeRowFactoryTest {

    Salary salary = Salary.builder().
            rate(BigDecimal.valueOf(10))
            .typeOfWork(160)
            .build();

    EmployeeDto employeeDto = EmployeeDto.builder()
            .name("Adam")
            .surname("Kowalski")
            .workPlace(Object.class)
            .position(PositionEmployee.CLEANER)
            .salary(salary)
            .statusEmployee(StatusEmployee.WORKING)
            .typeOfContract(TypeOfContract.CONTRACT_OF_EMPLOYMENT)
            .build();

    @Test
    @DisplayName("should converter from dto to entity correctly")
    void converterCorrectly() {
        //Given
        EmployeeRowFactory employeeRowFactory = new EmployeeRowFactory();
        //When
        var employeeAfterConvert = employeeRowFactory.converter(employeeDto);
        //Then
        assertThat(employeeAfterConvert).isInstanceOf(EmployeeEntity.class);
    }

    @DisplayName("should converter from dto to entity correctly, check field by field")
    @Test
    void converterCorrectlyByField(){
        //Given
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Adam");
        employeeEntity.setSurname("Kowalski");
        employeeEntity.setWorkPlace(Object.class);
        employeeEntity.setPosition(PositionEmployee.CLEANER);
        employeeEntity.setSalary(salary);
        employeeEntity.setStatusEmployee(StatusEmployee.WORKING);
        employeeEntity.setTypeOfContract(TypeOfContract.CONTRACT_OF_EMPLOYMENT);
        EmployeeRowFactory employeeRowFactory = new EmployeeRowFactory();

        //When
        var employeeAfterConvert = employeeRowFactory.converter(employeeDto);

        //Then
        assertEquals(employeeEntity.getName(), employeeAfterConvert.getName());
        assertEquals(employeeEntity.getSurname(), employeeAfterConvert.getSurname());
        assertEquals(employeeEntity.getWorkPlace(), employeeAfterConvert.getWorkPlace());
        assertEquals(employeeEntity.getPosition(), employeeAfterConvert.getPosition());
        assertEquals(employeeEntity.getSalary(), employeeAfterConvert.getSalary());
        assertEquals(employeeEntity.getStatusEmployee(), employeeAfterConvert.getStatusEmployee());
        assertEquals(employeeEntity.getTypeOfContract(), employeeAfterConvert.getTypeOfContract());

    }


    @DisplayName("Should throw an NullPointException")
    @Test
    void convertNotCorrectly(){
        //Given
        EmployeeDto employeeDtoInMethod = EmployeeDto.builder()
                .name("Adam")
                .surname("Kowalski")
                .workPlace(Object.class)
                .position(PositionEmployee.CLEANER)
                .typeOfContract(TypeOfContract.CONTRACT_OF_EMPLOYMENT)
                .build();
        EmployeeRowFactory employeeRowFactory = new EmployeeRowFactory();
        //When
        var employeeAfterConvert = employeeRowFactory.converter(employeeDtoInMethod);
        //Then
        assertThatNullPointerException();
    }
}