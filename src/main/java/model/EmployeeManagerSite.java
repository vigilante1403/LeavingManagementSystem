package model;

public class EmployeeManagerSite {
	private int emp_id;
	private String fullname;
	private int department_id;
	private String position;
	private int dayoff;
	private int total_leave_day_allowed;
	public EmployeeManagerSite(int emp_id, String fullname, int department_id, String position, int dayoff,
			int total_leave_day_allowed) {
		this.emp_id = emp_id;
		this.fullname = fullname;
		this.department_id = department_id;
		this.position = position;
		this.dayoff = dayoff;
		this.total_leave_day_allowed = total_leave_day_allowed;
	}
	public EmployeeManagerSite() {
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
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDayoff() {
		return dayoff;
	}
	public void setDayoff(int dayoff) {
		this.dayoff = dayoff;
	}
	public int getTotal_leave_day_allowed() {
		return total_leave_day_allowed;
	}
	public void setTotal_leave_day_allowed(int total_leave_day_allowed) {
		this.total_leave_day_allowed = total_leave_day_allowed;
	}
	@Override
	public String toString() {
		return "EmployeeManagerSite [emp_id=" + emp_id + ", fullname=" + fullname + ", department_id=" + department_id
				+ ", position=" + position + ", dayoff=" + dayoff + ", total_leave_day_allowed="
				+ total_leave_day_allowed + "]";
	}
	
}
