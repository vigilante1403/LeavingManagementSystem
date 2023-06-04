package model;

import java.time.LocalDate;

public class EmployeeContactInfo {
	private int emp_id;
	private String fullname;
	private boolean gender;
	private LocalDate start_to_work;
	private int department_code;
	private String department;
	private String email;
	private String phoneNumber;
	private String position;
	private int daysleft;
	
	
	public EmployeeContactInfo(int emp_id, String fullname, boolean gender, LocalDate start_to_work,
			int department_code, String department, String email, String phoneNumber, String position, int daysleft) {
		this.emp_id = emp_id;
		this.fullname = fullname;
		this.gender = gender;
		this.start_to_work = start_to_work;
		this.department_code = department_code;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.daysleft = daysleft;
	}
	public EmployeeContactInfo() {
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
	public LocalDate getStart_to_work() {
		return start_to_work;
	}
	public void setStart_to_work(LocalDate start_to_work) {
		this.start_to_work = start_to_work;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDaysleft() {
		return daysleft;
	}
	public void setDaysleft(int daysleft) {
		this.daysleft = daysleft;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(int department_code) {
		this.department_code = department_code;
	}
	@Override
	public String toString() {
		return "EmployeeContactInfo [emp_id=" + emp_id + ", fullname=" + fullname + ", gender=" + gender
				+ ", start_to_work=" + start_to_work + ", department_code=" + department_code + ", department="
				+ department + ", email=" + email + ", phoneNumber=" + phoneNumber + ", position=" + position
				+ ", daysleft=" + daysleft + "]";
	}
	
	
	
}
