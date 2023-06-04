package model;

public class CheckLeaveEmp {
	private int id;
	private int emp_id;
	private String fullname;
	private String department;
	private int type_code;
	private int status;
	private String reason;
	public CheckLeaveEmp() {
	}
	
	public CheckLeaveEmp(int id, int emp_id, String fullname, String department, int type_code, int status,
			String reason) {
		this.id = id;
		this.emp_id = emp_id;
		this.fullname = fullname;
		this.department = department;
		this.type_code = type_code;
		this.status = status;
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
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getType_code() {
		return type_code;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "CheckLeaveEmp [id=" + id + ", emp_id=" + emp_id + ", fullname=" + fullname + ", department="
				+ department + ", type_code=" + type_code + ", status=" + status + ", reason=" + reason + "]";
	}
	
	
}
