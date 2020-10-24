package pl.wedding.management.employee.service;

import pl.wedding.management.employee.model.EmployeeDto;
import pl.wedding.management.employee.model.EmployeeEntity;

class EmployeeRowFactory {

    EmployeeEntity converter(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setSurname(employeeDto.getSurname());
        employeeEntity.setWorkPlace(employeeDto.getWorkPlace());
        employeeEntity.setPosition(employeeDto.getPosition());
        employeeEntity.setSalary(employeeDto.getSalary());
        employeeEntity.setStatusEmployee(employeeDto.getStatusEmployee());
        employeeEntity.setTypeOfContract(employeeDto.getTypeOfContract());
        return employeeEntity;
    }
}
