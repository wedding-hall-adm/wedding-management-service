package pl.wedding.management.employee.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wedding.management.employee.model.EmployeeDto;
import pl.wedding.management.employee.model.EmployeeEntity;
import pl.wedding.management.employee.model.PositionEmployee;
import pl.wedding.management.employee.model.Salary;
import pl.wedding.management.employee.model.StatusEmployee;
import pl.wedding.management.employee.model.TypeOfContract;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    void converter_ConvertCorrectly_CorrectlyConvert() {
        //Given
        EmployeeRowFactory employeeRowFactory = new EmployeeRowFactory();
        //When
        var employeeAfterConvert = employeeRowFactory.converter(employeeDto);
        //Then
        assertThat(employeeAfterConvert).isInstanceOf(EmployeeEntity.class);
    }

    @DisplayName("should converter from dto to entity correctly, check field by field")
    @Test
    void converter_ConverterCorrectlyCorrectlyConvertByField() {
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
        assertThat(employeeEntity.getName()).isEqualTo(employeeAfterConvert.getName());
        assertThat(employeeEntity.getSurname()).isEqualTo(employeeAfterConvert.getSurname());
        assertThat(employeeEntity.getWorkPlace()).isEqualTo(employeeAfterConvert.getWorkPlace());
        assertThat(employeeEntity.getPosition()).isEqualTo(employeeAfterConvert.getPosition());
        assertThat(employeeEntity.getSalary()).isEqualTo(employeeAfterConvert.getSalary());
        assertThat(employeeEntity.getStatusEmployee()).isEqualTo(employeeAfterConvert.getStatusEmployee());
        assertThat(employeeEntity.getTypeOfContract()).isEqualTo(employeeAfterConvert.getTypeOfContract());

    }


    @DisplayName("Should throw an RunTimeException")
    @Test
    void convert_ConverterNotCorrectly_shouldThrow() {
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
        assertThatExceptionOfType(RuntimeException.class);
    }
}