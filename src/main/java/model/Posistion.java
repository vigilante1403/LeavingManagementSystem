package model;

public class Posistion {
	private int id_position;
	private String name_of_position;
	private int number_emp;
	public Posistion(int id_position, String name_of_position, int number_emp) {
		this.id_position = id_position;
		this.name_of_position = name_of_position;
		this.number_emp = number_emp;
	}
	public Posistion() {
	}
	public int getId_position() {
		return id_position;
	}
	public void setId_position(int id_position) {
		this.id_position = id_position;
	}
	public String getName_of_position() {
		return name_of_position;
	}
	public void setName_of_position(String name_of_position) {
		this.name_of_position = name_of_position;
	}
	public int getNumber_emp() {
		return number_emp;
	}
	public void setNumber_emp(int number_emp) {
		this.number_emp = number_emp;
	}
	@Override
	public String toString() {
		return name_of_position;
	}
	
}
