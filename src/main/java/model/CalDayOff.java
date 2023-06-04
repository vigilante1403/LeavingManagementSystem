package model;

public class CalDayOff {
	private int type_code;
	private int times;
	private int times_per_year;
	
	public CalDayOff() {
	}

	public CalDayOff(int type_code, int times, int times_per_year) {
		this.type_code = type_code;
		this.times = times;
		this.times_per_year = times_per_year;
	}

	public int getType_code() {
		return type_code;
	}

	public void setType_code(int type_code) {
		this.type_code = type_code;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getTimes_per_year() {
		return times_per_year;
	}

	public void setTimes_per_year(int times_per_year) {
		this.times_per_year = times_per_year;
	}

	@Override
	public String toString() {
		return "CalDayOff [type_code=" + type_code + ", times=" + times + ", times_per_year=" + times_per_year + "]";
	}
	
}
