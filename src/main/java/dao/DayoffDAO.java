package dao;
import db.*;
import helper.*;
import model.*;
import java.sql.Date;
import java.time.ZoneId;
import java.util.List;
import java.util.*;

import javax.swing.JOptionPane;
public class DayoffDAO {
	public void create(Dayoff day) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call addDayOff(?,?,?,?,?)}")) {
			cs.setInt(1, day.getEmp_id());
			cs.setInt(2, day.getType_code());
			cs.setDate(3,Date.valueOf(day.getStarted_date()));
			cs.setDate(4, Date.valueOf(day.getEnd_date()));
			cs.setString(5, day.getReason());
			var rs = cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Send successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Dayoff> loadData() {
		
		List<Dayoff> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call selDayoff(?)}")) {
			cs.setInt(1, User.department_code);
			var rs = cs.executeQuery();
			while(rs.next()) {
				Dayoff day = new Dayoff();
				day.setId(rs.getInt("id"));
				day.setEmp_id(rs.getInt("emp_id"));
				day.setType_code(rs.getInt("type_code"));
				day.setStarted_date(rs.getDate("started_date").toLocalDate());
				day.setEnd_date(rs.getDate("end_date").toLocalDate());
				day.setStatus_code(rs.getInt("status"));
				day.setReason(rs.getString("reason"));
				day.setReceived_at(rs.getDate("received_at").toLocalDate());
				list.add(day);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public Dayoff getDataById(int id) {
		Dayoff day = new Dayoff();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getDataById(?)}")) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				day.setId(rs.getInt("id"));
				day.setEmp_id(rs.getInt("emp_id"));
				day.setType_code(rs.getInt("type_code"));
				day.setStarted_date(rs.getDate("started_date").toLocalDate());
				day.setEnd_date(rs.getDate("end_date").toLocalDate());
				day.setStatus_code(rs.getInt("status"));
				day.setReason(rs.getString("reason"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}
	public void updateLetterStatus(int id,int status_code,int manager_account_id,int day_change) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call updateLetterStatus(?,?,?,?)}")) {
			cs.setInt(1,id);
			cs.setInt(2, status_code);
			cs.setInt(3, manager_account_id);
			cs.setInt(4, day_change);
			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public List<DepartmentDayoff> loadData_Manager() {
		
		List<DepartmentDayoff> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call selAllDayoffManagerPending}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				DepartmentDayoff day = new DepartmentDayoff();
				day.setId(rs.getInt("id"));
				day.setEmp_id(rs.getInt("emp_id"));
				day.setType_code(rs.getInt("type_code"));
				day.setStart_date(rs.getDate("started_date").toLocalDate());
				day.setEnd_date(rs.getDate("end_date").toLocalDate());
				day.setStatus(rs.getInt("status"));
				day.setReason(rs.getString("reason"));
				day.setDepartment_name(rs.getString("name_department"));
				day.setReceive_at(rs.getDate("received_at").toLocalDate());
				list.add(day);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
public List<DayoffandDate> getDayOffByDate(){
	List<DayoffandDate> list = new ArrayList<>();
	try(var con = ConnectDB.getDBProperty();
		var cs = con.prepareCall("{call getDayOffPendingByDate}")) {
		var rs = cs.executeQuery();
		while(rs.next()) {
			DayoffandDate day = new DayoffandDate();
			day.setId(rs.getInt("id"));
			day.setEmp_id(rs.getInt("emp_id"));
			day.setType_code(rs.getInt("type_code"));
			day.setDepartment(rs.getString("name_department"));
			day.setStarted_date(rs.getDate("started_date").toLocalDate());
			day.setEnd_date(rs.getDate("end_date").toLocalDate());
			day.setGranted_by_id(rs.getInt("granted_by_id"));
			list.add(day);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
	public List<DayoffandDate> getDayOffByDate(java.util.Date date,int status){
		List<DayoffandDate> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getDayOffByDate(?,?)}")) {
			java.sql.Date newDate = new java.sql.Date(date.getTime());
			cs.setDate(1, newDate);
			cs.setInt(2, status);
			var rs = cs.executeQuery();
			while(rs.next()) {
				DayoffandDate day = new DayoffandDate();
				day.setId(rs.getInt("id"));
				day.setEmp_id(rs.getInt("emp_id"));
				day.setType_code(rs.getInt("type_code"));
				day.setDepartment(rs.getString("name_department"));
				day.setStarted_date(rs.getDate("started_date").toLocalDate());
				day.setEnd_date(rs.getDate("end_date").toLocalDate());
				day.setGranted_by_id(rs.getInt("granted_by_id"));
				list.add(day);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<CheckLeaveEmp> getEmpLeft(java.util.Date date){
		List<CheckLeaveEmp> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getEmpLeft(?)}")) 
		{
			cs.setDate(1, new java.sql.Date(date.getTime()));
			var rs = cs.executeQuery();
			while(rs.next()) {
				CheckLeaveEmp emp = new CheckLeaveEmp();
				emp.setId(rs.getInt("id"));
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setDepartment(rs.getString("name_department"));
				emp.setType_code(rs.getInt("type_code"));
				emp.setStatus(rs.getInt("status"));
				emp.setReason(rs.getString("reason"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<EmployeeSentLettersBox> getEmpDayOff(int emp_id){
		List<EmployeeSentLettersBox> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getDayOffEmp(?)}")) 
		{
			cs.setInt(1, emp_id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeSentLettersBox emp = new EmployeeSentLettersBox();
				emp.setId(rs.getInt("id"));
				emp.setType_code(rs.getInt("type_code"));
				emp.setStarted_date(rs.getDate("started_date").toLocalDate());
				emp.setEnd_date(rs.getDate("end_date").toLocalDate());
				emp.setGranted_by_id(rs.getInt("granted_by_id"));
				emp.setStatus(rs.getInt("status"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void modifyLetters(Dayoff day) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call modifyLetters(?,?,?,?,?)}");) {
			cs.setInt(1, day.getId());
			cs.setInt(2, day.getType_code());
			cs.setDate(3, Date.valueOf(day.getStarted_date()));
			cs.setDate(4, Date.valueOf(day.getEnd_date()));
			cs.setString(5, day.getReason());
			var rs = cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Change letter's info successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deletePendingLetter(Dayoff day) {
		try(var con = ConnectDB.getDBProperty();
				var cs = con.prepareCall("{call deleteLetters(?)}");) {
				cs.setInt(1, day.getId());
				var rs = cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete letter successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	public boolean dayCheckExist(java.util.Date datefrom,java.util.Date dateto,int emp_id) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call dateCheck(?,?,?)}")) {
			java.sql.Date date1 = new java.sql.Date (datefrom.getTime());
			java.sql.Date date2 = new java.sql.Date(dateto.getTime());
			cs.setDate(1, date1);
			cs.setDate(2, date2);
			cs.setInt(3, emp_id);
			var rs = cs.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "There's pending or checked letter already existed");
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public CalDayOff calculateDayoffTimes(int emp_id, int type_code) {
		CalDayOff emp_cal = new CalDayOff();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call calDayoff(?,?)}")) {
			cs.setInt(1,emp_id);
			cs.setInt(2, type_code);
			var rs = cs.executeQuery();
			if(rs.next()) {
				emp_cal.setType_code(rs.getInt("type_code"));
				emp_cal.setTimes(rs.getInt("times"));
				emp_cal.setTimes_per_year(rs.getInt("times_per_year"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp_cal;
	}
	public void changingStatus(int id,int status) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call changingStatus(?,?)}")) {
			cs.setInt(1, id);
			cs.setInt(2, status);
			cs.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addDayBack(int emp_id,int day) {
		try(var con = ConnectDB.getDBProperty();
				var cs = con.prepareCall("{call addBack(?,?)}")) {
				cs.setInt(1, emp_id);
				cs.setInt(2, day);
				cs.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
