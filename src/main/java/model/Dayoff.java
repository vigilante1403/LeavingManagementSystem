package model;

import java.time.LocalDate;
import java.util.Date;

public class Dayoff {
	private int id;
	private int emp_id;
	private int type_code;
	private LocalDate started_date;
	private LocalDate end_date;
	private int status_code;
	private int granted_by_id_account;
	private String reason;
	private LocalDate checked_at;
	private LocalDate received_at;
	
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
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public int getGranted_by_id_account() {
		return granted_by_id_account;
	}
	public void setGranted_by_id_account(int granted_by_id_account) {
		this.granted_by_id_account = granted_by_id_account;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDate getChecked_at() {
		return checked_at;
	}
	public void setChecked_at(LocalDate checked_at) {
		this.checked_at = checked_at;
	}
	public LocalDate getReceived_at() {
		return received_at;
	}
	public void setReceived_at(LocalDate received_at) {
		this.received_at = received_at;
	}
	public Dayoff(int id, int emp_id, int type_code, LocalDate started_date, LocalDate end_date, int status_code,
			int granted_by_id_account, String reason, LocalDate checked_at, LocalDate received_at) {
		this.id = id;
		this.emp_id = emp_id;
		this.type_code = type_code;
		this.started_date = started_date;
		this.end_date = end_date;
		this.status_code = status_code;
		this.granted_by_id_account = granted_by_id_account;
		this.reason = reason;
		this.checked_at = checked_at;
		this.received_at = received_at;
	}
	@Override
	public String toString() {
		return "Dayoff [id=" + id + ", emp_id=" + emp_id + ", type_code=" + type_code + ", started_date=" + started_date
				+ ", end_date=" + end_date + ", status_code=" + status_code + ", granted_by_id_account="
				+ granted_by_id_account + ", reason=" + reason + ", checked_at=" + checked_at + ", received_at="
				+ received_at + "]";
	}
	public Dayoff() {
	}

}
