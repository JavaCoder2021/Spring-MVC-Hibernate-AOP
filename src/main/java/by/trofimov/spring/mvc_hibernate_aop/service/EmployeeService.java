package by.trofimov.spring.mvc_hibernate_aop.service;

import java.util.List;
import by.trofimov.spring.mvc_hibernate_aop.entity.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployee(int employee);

    void deleteEmployee(int id);

}
