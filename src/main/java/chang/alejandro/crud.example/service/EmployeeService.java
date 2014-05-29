/*
 * EmployeeService.java
 *
 * 1.0 (08/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.service;

import java.util.Date;
import java.util.List;

import chang.alejandro.crud.example.model.Employee;

/**
 * @version 1.0 (08/09/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public interface EmployeeService {
	void createEmployee(String userName, String firstName,
			String lastName, String birthDate, String gender, String hireDate, String position, String active);

	void updateEmployee(String userName, String firstName,
			String lastName, String birthDate, String gender, String hireDate, String position, String active);

	void deleteEmployee(String userName);

	Employee getEmployee(String userName);

	List<Employee> getAllEmployees();
}
