package model;

public class Department {
	private int id;
	private String name_department;
	private int manager_dpt_id;
	private int number_emp_in_dpt;
	public Department(int id, String name_department, int manager_dpt_id, int number_emp_in_dpt) {
		this.id = id;
		this.name_department = name_department;
		this.manager_dpt_id = manager_dpt_id;
		this.number_emp_in_dpt = number_emp_in_dpt;
	}
	public Department() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_department() {
		return name_department;
	}
	public void setName_department(String name_department) {
		this.name_department = name_department;
	}
	public int getManager_dpt_id() {
		return manager_dpt_id;
	}
	public void setManager_dpt_id(int manager_dpt_id) {
		this.manager_dpt_id = manager_dpt_id;
	}
	public int getNumber_emp_in_dpt() {
		return number_emp_in_dpt;
	}
	public void setNumber_emp_in_dpt(int number_emp_in_dpt) {
		this.number_emp_in_dpt = number_emp_in_dpt;
	}
	@Override
	public String toString() {
		return  name_department;
	}
	
}
