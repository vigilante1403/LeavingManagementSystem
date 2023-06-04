package model;

public class StatusDayoff {
	private int id;
	private String name_status;
	public StatusDayoff(int id, String name_status) {
		this.id = id;
		this.name_status = name_status;
	}
	public StatusDayoff() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_status() {
		return name_status;
	}
	public void setName_status(String name_status) {
		this.name_status = name_status;
	}
	@Override
	public String toString() {
		return "StatusDayoff [id=" + id + ", name_status=" + name_status + "]";
	}
	
}
