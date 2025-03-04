package pro.dadadaa.dadadaa.Service;

import org.springframework.stereotype.Service;
import pro.dadadaa.dadadaa.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final List<Employee> employees = List.of(
            new Employee("Иван", 50000, "IT"),
            new Employee("Мария", 60000, "HR"),
            new Employee("Петр", 55000, "IT"),
            new Employee("Анна", 45000, "HR")
    );

    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals("Department " + departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals("Department " + departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals("Department " + departmentId))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

}
