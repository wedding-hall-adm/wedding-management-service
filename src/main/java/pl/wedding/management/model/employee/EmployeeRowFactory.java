package pl.wedding.management.model.employee;


class EmployeeRowFactory {

    static Employee converter(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setWorkPlace(employeeDto.getWorkPlace());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        employee.setStatusEmployee(employeeDto.getStatusEmployee());
        employee.setTypeOfContract(employeeDto.getTypeOfContract());
        return employee;
    }
}
