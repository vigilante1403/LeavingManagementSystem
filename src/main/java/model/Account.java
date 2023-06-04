package model;

public class Account {
	private int account_id;
	private String username;
	private String password;
	private String role;
	private int emp_id;
	public Account(int account_id, String username, String password, String role, int emp_id) {
		this.account_id = account_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.emp_id = emp_id;
	}
	public Account() {
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password2) {
		this.password = password2;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", emp_id=" + emp_id + "]";
	}
	
}
