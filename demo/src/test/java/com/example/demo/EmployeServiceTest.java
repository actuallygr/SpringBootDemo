package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.impl.EmployeeServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	public void should_get_list_of_employee_when_employee_exits() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setDepartment("CS");
		employee.setName("Shailesh");
		employee.setSalary(267124672);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> list = employeeService.retrieveEmployees();
		assertThat(list.size()).isEqualTo(1);
	}
}
