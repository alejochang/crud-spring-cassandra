/*
 * EmployeeServiceImpl.java
 *
 * 1.0 (09/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */
package chang.alejandro.crud.example.service;

import java.util.Date;
import java.util.List;

import chang.alejandro.crud.example.model.Employee;
import chang.alejandro.crud.example.model.Gender;
import chang.alejandro.crud.example.persistence.CassandraManager;
import chang.alejandro.crud.example.utils.CassandraUtils;
import org.springframework.stereotype.Component;

/**
 * @version 1.0 (09/09/2011)
 * 
 *          <p>
 *          Provides all the services to manage employee entities.
 *          </p>
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 * 
 */
@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeServiceImpl() {

	}

	public void createEmployee(String userName, String firstName,
			String lastName, String birthDate, String gender, String hireDate,
			String position, String active) {
		Date bDt, hDt;
		bDt = CassandraUtils.parseDate(birthDate);
		hDt = CassandraUtils.parseDate(hireDate);
		Employee employee = getNewInstanceEmployee(userName, firstName,
				lastName, bDt, Gender.valueOf(gender), hDt, position,
				CassandraUtils.getValidatedBoolean(active));

		CassandraManager.persist(employee);
	}

	public void updateEmployee(String userName, String firstName,
			String lastName, String birthDate, String gender, String hireDate,
			String position, String active) {

		Date bDt, hDt;
		bDt = CassandraUtils.parseDate(birthDate);
		hDt = CassandraUtils.parseDate(hireDate);
		Employee employee = getNewInstanceEmployee(userName, firstName,
				lastName, bDt, Gender.valueOf(gender), hDt, position,
				CassandraUtils.getValidatedBoolean(active));

		CassandraManager.persist(employee);
	}

	public void deleteEmployee(String userName) {
		Employee employee = new Employee();
		employee.setUserName(userName);

		CassandraManager.remove(employee);
	}

	public Employee getEmployee(String userName) {
		Employee employee = new Employee();
		employee.setUserName(userName);
		
		employee = CassandraManager.find(Employee.class, employee);

		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		//List<Employee> employees = CassandraManager.findAll(Employee.class, employee);
		return null;
	}

	private Employee getNewInstanceEmployee(String userName, String firstName,
			String lastName, Date birthDate, Gender gender, Date hireDate,
			String position, Boolean active) {
		Employee employee = null;
		if (userName == null || userName.length() > 0) {
			employee = new Employee();
			employee.setUserName(userName);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setBirthDate(birthDate);
			employee.setGender(gender);
			employee.setHireDate(hireDate);
			// employee.setSupervisor(supervisor);
			employee.setPosition(position);
			employee.setActive(active);
		}
		return employee;
	}

}
