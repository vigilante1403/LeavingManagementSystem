package model;

import java.time.LocalDate;

public class Employee {
	private int emp_id;
	private String fullname;
	private boolean gender;
	private String position;
	private int department_id;
	private int manager_id;
	private LocalDate start_to_work;
	private String email;
	private String phoneNumber;
	private String picture;
	
	public Employee() {
	}
	
	
	
	public Employee(int emp_id, String fullname, boolean gender, String position, int department_id, int manager_id,
			LocalDate start_to_work, String email, String phoneNumber,
			String picture) {
		this.emp_id = emp_id;
		this.fullname = fullname;
		this.gender = gender;
		this.position = position;
		this.department_id = department_id;
		this.manager_id = manager_id;
		this.start_to_work = start_to_work;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.picture = picture;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public LocalDate getStart_to_work() {
		return start_to_work;
	}
	public void setStart_to_work(LocalDate start_to_work) {
		this.start_to_work = start_to_work;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", fullname=" + fullname + ", gender=" + gender + ", position=" + position
				+ ", department_id=" + department_id + ", manager_id=" + manager_id + ", start_to_work=" + start_to_work
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", picture=" + picture + "]";
	}
	
}
