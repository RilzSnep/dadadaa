package pro.springMockito.springMockito;
import pro.springMockito.springMockito.Service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.springMockito.springMockito.Service.DepartmentService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeeWithMaxSalary_ShouldReturnEmployeeWithMaxSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", 50000, 1),
                new Employee("Петр", 55000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        Employee result = departmentService.getEmployeeWithMaxSalary(1);
        assertEquals("Петр", result.getName());
    }

    @Test
    void getSalarySumByDepartment_ShouldReturnSum() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", 50000, 1),
                new Employee("Петр", 55000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        int sum = departmentService.getSalarySumByDepartment(1);
        assertEquals(105000, sum);
    }

    @Test
    void getAllEmployeesGroupedByDepartment_ShouldReturnGroupedMap() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", 50000, 1),
                new Employee("Мария", 60000, 2)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> result = departmentService.getAllEmployeesGroupedByDepartment();
        assertEquals(2, result.size());
        assertEquals(1, result.get(1).size());
        assertEquals(1, result.get(2).size());
    }
}