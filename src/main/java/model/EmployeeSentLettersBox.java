package model;

import java.time.LocalDate;

public class EmployeeSentLettersBox {
	private int id;
	private int emp_id;
	private int type_code;
	private LocalDate started_date;
	private LocalDate end_date;
	private int granted_by_id;
	private int status;
	public EmployeeSentLettersBox() {
	}
	
	public EmployeeSentLettersBox(int id, int emp_id, int type_code, LocalDate started_date, LocalDate end_date,
			int granted_by_id, int status) {
		this.id = id;
		this.emp_id = emp_id;
		this.type_code = type_code;
		this.started_date = started_date;
		this.end_date = end_date;
		this.granted_by_id = granted_by_id;
		this.status = status;
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
	public LocalDate getStarted_date() {
		return started_date;
	}
	public void setStarted_date(LocalDate started_date) {
		this.started_date = started_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public int getGranted_by_id() {
		return granted_by_id;
	}
	public void setGranted_by_id(int granted_by_id) {
		this.granted_by_id = granted_by_id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeSentLettersBox [id=" + id + ", emp_id=" + emp_id + ", type_code=" + type_code
				+ ", started_date=" + started_date + ", end_date=" + end_date + ", granted_by_id=" + granted_by_id
				+ ", status=" + status + "]";
	}

	
	
}
