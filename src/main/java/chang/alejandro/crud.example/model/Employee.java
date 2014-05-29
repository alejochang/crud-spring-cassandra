/*
 * Employee.java
 *
 * 1.0 (08/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import chang.alejandro.crud.example.persistence.annotations.Column;
import chang.alejandro.crud.example.persistence.annotations.ColumnFamily;
import chang.alejandro.crud.example.persistence.annotations.RowKey;


/**
 * @version 1.0 (08/09/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
@ColumnFamily(name = "employee")
public class Employee implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 23797861592054943L;

	private String userName;

	private String firstName;

	private String lastName;

	private Date birthDate;
    
	private Gender gender;
    
	private Date hireDate;
    
	private Employee supervisor;
    
	private String position;
    
	private Boolean active;
	
	private Set<EmployeeGroup> groups;

	/**
	 * Getter of <code>userName</code> property.
	 * @return <code>userName</code> property value.
	 * @see #userName
	 */
	
	@RowKey
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of <code>userName</code> property.
	 * @param userName The <code>userName</code> to set.
	 * @see #userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	
		return;
	}

	/**
	 * Getter of <code>firstName</code> property.
	 * @return <code>firstName</code> property value.
	 * @see #firstName
	 */
	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter of <code>firstName</code> property.
	 * @param firstName The <code>firstName</code> to set.
	 * @see #firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	
		return;
	}

	/**
	 * Getter of <code>lastName</code> property.
	 * @return <code>lastName</code> property value.
	 * @see #lastName
	 */
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter of <code>lastName</code> property.
	 * @param lastName The <code>lastName</code> to set.
	 * @see #lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	
		return;
	}

	/**
	 * Getter of <code>birthDate</code> property.
	 * @return <code>birthDate</code> property value.
	 * @see #birthDate
	 */
	@Column(name = "birthDate")
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Setter of <code>birthDate</code> property.
	 * @param birthDate The <code>birthDate</code> to set.
	 * @see #birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	
		return;
	}

	/**
	 * Getter of <code>gender</code> property.
	 * @return <code>gender</code> property value.
	 * @see #gender
	 */
	@Column(name = "gender")
	public Gender getGender() {
		return gender;
	}

	/**
	 * Setter of <code>gender</code> property.
	 * @param gender The <code>gender</code> to set.
	 * @see #gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	
		return;
	}

	/**
	 * Getter of <code>hireDate</code> property.
	 * @return <code>hireDate</code> property value.
	 * @see #hireDate
	 */
	@Column(name = "hireDate")
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * Setter of <code>hireDate</code> property.
	 * @param hireDate The <code>hireDate</code> to set.
	 * @see #hireDate
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	
		return;
	}

	/**
	 * Getter of <code>supervisor</code> property.
	 * @return <code>supervisor</code> property value.
	 * @see #supervisor
	 */
	//@Column(name = "supervisor")
	public Employee getSupervisor() {
		return supervisor;
	}

	/**
	 * Setter of <code>supervisor</code> property.
	 * @param supervisor The <code>supervisor</code> to set.
	 * @see #supervisor
	 */
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	
		return;
	}

	/**
	 * Getter of <code>position</code> property.
	 * @return <code>position</code> property value.
	 * @see #position
	 */
	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	/**
	 * Setter of <code>position</code> property.
	 * @param position The <code>position</code> to set.
	 * @see #position
	 */
	public void setPosition(String position) {
		this.position = position;
	
		return;
	}

	/**
	 * Getter of <code>active</code> property.
	 * @return <code>active</code> property value.
	 * @see #active
	 */
	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}

	/**
	 * Setter of <code>active</code> property.
	 * @param active The <code>active</code> to set.
	 * @see #active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	
		return;
	}

	/**
	 * Getter of <code>groups</code> property.
	 * @return <code>groups</code> property value.
	 * @see #groups
	 */
	//@ManyToMany(columnFamily = "groupsByEmployee")
	public Set<EmployeeGroup> getGroups() {
		return groups;
	}

	/**
	 * Setter of <code>groups</code> property.
	 * @param groups The <code>groups</code> to set.
	 * @see #groups
	 */
	public void setGroups(Set<EmployeeGroup> groups) {
		this.groups = groups;
		
		return;
	}	

}
