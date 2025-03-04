package pro.springMockito.springMockito;
import pro.springMockito.springMockito.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void addEmployee_ShouldAddNewEmployee() {
        employeeService.addEmployee("Олег", 70000, 1);
        assertNotNull(employeeService.findEmployee("Олег"));
    }

    @Test
    void removeEmployee_ShouldRemoveExistingEmployee() {
        employeeService.addEmployee("Олег", 70000, 1);
        employeeService.removeEmployee("Олег");
        assertNull(employeeService.findEmployee("Олег"));
    }

    @Test
    void findEmployee_ShouldReturnNullForNonExistingEmployee() {
        assertNull(employeeService.findEmployee("Неизвестный"));
    }
}