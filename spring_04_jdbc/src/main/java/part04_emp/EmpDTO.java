package part04_emp;

import java.util.Date;

public class EmpDTO {
	private int employee_id;
	private String first_name;
	private int salary;
	private java.sql.Date hire_date;

	public EmpDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public java.sql.Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(java.sql.Date hire_date) {
		this.hire_date = hire_date;
	}

}
