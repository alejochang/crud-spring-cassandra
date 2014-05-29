/*
 * EmployeeGroup.java
 *
 * 1.0 (08/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.model;

import java.util.HashSet;
import java.util.Set;

import chang.alejandro.crud.example.persistence.annotations.ColumnFamily;
import chang.alejandro.crud.example.persistence.annotations.RowKey;

/**
 * @version 1.0 (08/09/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 * 
 */
@ColumnFamily(name = "employeeGroup")
public class EmployeeGroup {

	private String groupName;

	private Set<Employee> employees = new HashSet<Employee>();

	/**
	 * Getter of <code>groupName</code> property.
	 * 
	 * @return <code>groupName</code> property value.
	 * @see #groupName
	 */
	@RowKey
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Setter of <code>groupName</code> property.
	 * 
	 * @param groupName
	 *            The <code>groupName</code> to set.
	 * @see #groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;

		return;
	}

	/**
	 * Getter of <code>employees</code> property.
	 * 
	 * @return <code>employees</code> property value.
	 * @see #employees
	 */
//	@ManyToMany(columnFamily = "employeesByGroup")
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Setter of <code>employees</code> property.
	 * 
	 * @param employees
	 *            The <code>employees</code> to set.
	 * @see #employees
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;

		return;
	}

	/**
	 * @param employee
	 *            the employee to add
	 */
	public void addEmployee(Employee employee) {
		if (this.employees == null || this.employees.isEmpty()) {
			this.employees = new HashSet<Employee>();
		}

		this.employees.add(employee);
	}
}
