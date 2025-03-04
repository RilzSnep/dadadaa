package pro.springMockito.springMockito.Service;

import org.springframework.stereotype.Service;
import pro.springMockito.springMockito.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public int getSalarySumByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}