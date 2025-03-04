package pro.springMockito.springMockito.controller;

import org.springframework.web.bind.annotation.*;
import pro.springMockito.springMockito.Employee;
import pro.springMockito.springMockito.Service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getSalarySumByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public Employee getEmployeeWithMaxSalary(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getEmployeeWithMinSalary(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployeesGroupedByDepartment();
    }
}