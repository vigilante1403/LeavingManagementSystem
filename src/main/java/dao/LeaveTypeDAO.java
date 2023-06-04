package dao;
import java.util.List;
import java.util.*;
import db.*;
import helper.*;
import model.LeaveType;
public class LeaveTypeDAO {
	public List<LeaveType> getType() {
		List<LeaveType> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getLeaveType}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				LeaveType type = new LeaveType();
				type.setName_of_dayoff(rs.getString("name_of_dayoff"));
				type.setDay_off_code(rs.getInt("day_off_code"));
				type.setAllowed_day_off(rs.getInt("allowed_day_off"));
				list.add(type);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String getTypeById(int id) {
		String s = null;
		try(var con =ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call name_dayoff(?)}")) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				s=rs.getString("name_of_dayoff");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public LeaveType getTypeById2(int id) {
		LeaveType type = new LeaveType();
		try(var con =ConnectDB.getDBProperty();
				var cs = con.prepareCall("{call getLeaveTypeByCode(?)}")) {
				cs.setInt(1, id);
				var rs = cs.executeQuery();
				while(rs.next()) {
					type.setName_of_dayoff(rs.getString("name_of_dayoff"));
					type.setDay_off_code(id);
					type.setAllowed_day_off(rs.getInt("allowed_day_off"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return type;
	}
}
