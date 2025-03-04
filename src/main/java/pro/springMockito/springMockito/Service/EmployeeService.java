package pro.springMockito.springMockito.Service;

import pro.springMockito.springMockito.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Инициализация тестовыми данными
        employees.add(new Employee("Иван", 50000, 1));
        employees.add(new Employee("Мария", 60000, 2));
        employees.add(new Employee("Петр", 55000, 1));
        employees.add(new Employee("Анна", 45000, 2));
    }

    public void addEmployee(String name, int salary, int departmentId) {
        employees.add(new Employee(name, salary, departmentId));
    }

    public void removeEmployee(String name) {
        employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee findEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}