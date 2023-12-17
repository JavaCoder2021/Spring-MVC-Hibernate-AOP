package by.trofimov.spring.mvc_hibernate_aop.dao;

import java.util.List;
import by.trofimov.spring.mvc_hibernate_aop.entity.Employee;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

}
