package dao;
import helper.*;
import db.*;
import model.*;
import java.util.*;
public class PositionDAO {
	public List<Posistion> load() {
		List<Posistion> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call loadPosition}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				Posistion po = new Posistion();
				po.setId_position(rs.getInt("id_position"));
				po.setName_of_position(rs.getString("name_of_position"));
				po.setNumber_emp(rs.getInt("number_emp"));
				list.add(po);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
