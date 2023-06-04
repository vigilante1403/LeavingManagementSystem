package model;

public class Role {
	private int id;
	private String role_name;
	private int access_level;
	public Role(int id, String role_name, int access_level) {
		this.id = id;
		this.role_name = role_name;
		this.access_level = access_level;
	}
	public Role() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getAccess_level() {
		return access_level;
	}
	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + ", access_level=" + access_level + "]";
	}
	
}
