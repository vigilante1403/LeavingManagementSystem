package model;

import java.time.LocalDate;

public class DepartmentDayoff {
	private int id;
	private int emp_id;
	private String department_name;
	private int type_code;
	private LocalDate start_date;
	private LocalDate end_date;
	private int status;
	private LocalDate receive_at;
	private String reason;
	
	
	public DepartmentDayoff() {
	}
	
	

	public DepartmentDayoff(int id, int emp_id, String department_name, int type_code, LocalDate start_date,
			LocalDate end_date, int status, LocalDate receive_at, String reason) {
		this.id = id;
		this.emp_id = emp_id;
		this.department_name = department_name;
		this.type_code = type_code;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
		this.receive_at = receive_at;
		this.reason = reason;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getType_code() {
		return type_code;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	
	public String getDepartment_name() {
		return department_name;
	}



	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}



	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDate getReceive_at() {
		return receive_at;
	}
	public void setReceive_at(LocalDate receive_at) {
		this.receive_at = receive_at;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}



	@Override
	public String toString() {
		return "DepartmentDayoff [id=" + id + ", emp_id=" + emp_id + ", department_name=" + department_name
				+ ", type_code=" + type_code + ", start_date=" + start_date + ", end_date=" + end_date + ", status="
				+ status + ", receive_at=" + receive_at + ", reason=" + reason + "]";
	}

	

	
	
}
