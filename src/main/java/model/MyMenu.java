package model;


public class MyMenu {

	private int id;
	private int Parentid;
	private String name;
	private int sortid;
	private String CardLoad;
	@Override
	public String toString() {
		return "MyMenu [id=" + id + ", Parentid=" + Parentid + ", name=" + name + ", sortid=" + sortid + ", CardLoad="
				+ CardLoad + "]";
	}
	public MyMenu(){
		
	}
	public MyMenu(int id, int parentid, String name, int sortid, String cardLoad) {
		
		this.id = id;
		Parentid = parentid;
		this.name = name;
		this.sortid = sortid;
		CardLoad = cardLoad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentid() {
		return Parentid;
	}
	public void setParentid(int parentid) {
		Parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public String getCardLoad() {
		return CardLoad;
	}
	public void setCardLoad(String cardLoad) {
		CardLoad = cardLoad;
	}
}
