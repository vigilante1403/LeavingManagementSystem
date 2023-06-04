package model;

import java.time.LocalDate;

public class LeaveDayPermission {
	private int id;
	private int emp_id;
	private LocalDate start_work_at;
	private LocalDate now;
	private int total_years;
	private int total_leave_day_allowed;
	private int daysleft;
	
	public LeaveDayPermission(int id, int emp_id, LocalDate start_work_at, LocalDate now, int total_years,
			int total_leave_day_allowed, int daysleft) {
		this.id = id;
		this.emp_id = emp_id;
		this.start_work_at = start_work_at;
		this.now = now;
		this.total_years = total_years;
		this.total_leave_day_allowed = total_leave_day_allowed;
		this.daysleft = daysleft;
	}
	public LeaveDayPermission() {
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
	public LocalDate getStart_work_at() {
		return start_work_at;
	}
	public void setStart_work_at(LocalDate start_work_at) {
		this.start_work_at = start_work_at;
	}
	public LocalDate getNow() {
		return now;
	}
	public void setNow(LocalDate now) {
		this.now = now;
	}
	public int getTotal_years() {
		return total_years;
	}
	public void setTotal_years(int total_years) {
		this.total_years = total_years;
	}
	public int getTotal_leave_day_allowed() {
		return total_leave_day_allowed;
	}
	public void setTotal_leave_day_allowed(int total_leave_day_allowed) {
		this.total_leave_day_allowed = total_leave_day_allowed;
	}
	
	public int getDaysleft() {
		return daysleft;
	}
	public void setDaysleft(int daysleft) {
		this.daysleft = daysleft;
	}
	@Override
	public String toString() {
		return "LeaveDayPermission [id=" + id + ", emp_id=" + emp_id + ", start_work_at=" + start_work_at + ", now="
				+ now + ", total_years=" + total_years + ", total_leave_day_allowed=" + total_leave_day_allowed
				+ ", daysleft=" + daysleft + "]";
	}
	
}
