package pl.wedding.management.model.employee;


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
