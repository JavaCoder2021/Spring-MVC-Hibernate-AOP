package by.trofimov.spring.mvc_hibernate_aop.controller;

import java.util.List;
import javax.validation.Valid;
import by.trofimov.spring.mvc_hibernate_aop.entity.Department;
import org.springframework.ui.Model;
import by.trofimov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.stereotype.Controller;
import by.trofimov.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("department")
    public Department[] addDepartmentsToModel() {
        return Department.values();
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all_employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_info";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee_info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult bindingResult, Model model) {
        String view;
        if (bindingResult.hasErrors()) {
            view = "employee_info";
        } else {
            employeeService.saveOrUpdateEmployee(employee);
            view = "redirect:/";
        }
        return view;
    }

}
