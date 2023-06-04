package model;

public class LeaveType {
	private int day_off_code;
	private String name_of_dayoff;
	private int allowed_day_off;
	private int times_per_year;
	public int getDay_off_code() {
		return day_off_code;
	}
	public void setDay_off_code(int day_off_code) {
		this.day_off_code = day_off_code;
	}
	public String getName_of_dayoff() {
		return name_of_dayoff;
	}
	public void setName_of_dayoff(String name_of_dayoff) {
		this.name_of_dayoff = name_of_dayoff;
	}
	public int getAllowed_day_off() {
		return allowed_day_off;
	}
	public void setAllowed_day_off(int allowed_day_off) {
		this.allowed_day_off = allowed_day_off;
	}
	
	public int getTimes_per_year() {
		return times_per_year;
	}
	public void setTimes_per_year(int times_per_year) {
		this.times_per_year = times_per_year;
	}
	public LeaveType(int day_off_code, String name_of_dayoff, int allowed_day_off, int times_per_year) {
		this.day_off_code = day_off_code;
		this.name_of_dayoff = name_of_dayoff;
		this.allowed_day_off = allowed_day_off;
		this.times_per_year = times_per_year;
	}
	public LeaveType() {
	}
	@Override
	public String toString() {
		return name_of_dayoff;
	}
	
}
