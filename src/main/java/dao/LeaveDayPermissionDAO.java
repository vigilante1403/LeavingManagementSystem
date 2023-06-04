package dao;
import model.*;
import db.*;
import helper.*;
public class LeaveDayPermissionDAO {
 public void minusDay(int days,int emp_id) {
	 try(var con = ConnectDB.getDBProperty();
		var cs = con.prepareCall("{call minusdaysleft(?,?)}")) {
		 cs.setInt(1, days);
		 cs.setInt(2, emp_id);
		 var rs = cs.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 	public LeaveDayPermission getInfoLeaveEmp(int emp_id) {
 		LeaveDayPermission emp = new LeaveDayPermission();
 		try(var con = ConnectDB.getDBProperty();
 				var cs = con.prepareCall("{call getDaysLeft(?)}")) {
 				 cs.setInt(1, emp_id);
 				 var rs = cs.executeQuery();
 				while(rs.next()) {
 					emp.setId(rs.getInt("id"));
 					emp.setEmp_id(rs.getInt("emp_id"));
 					emp.setStart_work_at(rs.getDate("start_work_at").toLocalDate());
 					emp.setNow(rs.getDate("now").toLocalDate());
 					emp.setTotal_years(rs.getInt("total_years"));
 					emp.setTotal_leave_day_allowed(rs.getInt("total_leave_day_allowed"));
 					emp.setDaysleft(rs.getInt("daysleft"));
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		return emp;
 	}
 	public void autoCheckAndInsert() {
 		try(var con = ConnectDB.getDBProperty();
 			var cs = con.prepareCall("{call checkExistAndInsert}")) {
 			cs.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
 	
 	
 	
 	public void autoAddLeaveDays() {
 		try(var con = ConnectDB.getDBProperty();
 			var cs = con.prepareCall("{call addLeavePermissionDay}")) {
 			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
}
