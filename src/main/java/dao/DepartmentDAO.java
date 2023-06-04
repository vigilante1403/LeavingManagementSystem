package dao;

import db.ConnectDB;
import java.util.*;
import model.*;
public class DepartmentDAO {
	public List<Department> load() {
		
		List<Department> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call selAllDpt}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				Department dpt = new Department();
				dpt.setId(rs.getInt("id"));
				dpt.setName_department(rs.getString("name_department"));
				dpt.setManager_dpt_id(rs.getInt("manager_dpt_id"));
				list.add(dpt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
