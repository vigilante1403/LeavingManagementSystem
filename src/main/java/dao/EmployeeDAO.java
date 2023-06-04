package dao;
import db.ConnectDB;
import helper.*;
import model.*;
import java.util.*;

import javax.swing.JOptionPane;
public class EmployeeDAO{
	public void getLeaving(int id) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getLeaving(?)}")) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			if(rs.next()) {
				User.dayoff=rs.getInt("count_dayoff");	
			} else {
				User.dayoff=0;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getLeavingAllowed(int id) {
		try(var con = ConnectDB.getDBProperty();
				var cs = con.prepareCall("{call getLeavingAllowed(?)}")) {
				cs.setInt(1, id);
				var rs = cs.executeQuery();
				if(rs.next()) {
					User.allowed_dayoff=rs.getInt("total_leave_day_allowed");	
				} else {
					User.allowed_dayoff=0;	
				}
						
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public Employee getEmpInfo(int id) {
		Employee em = new Employee();
		try(var con = ConnectDB.getDBProperty();
			var cs = con .prepareCall("{call selUserInfo(?)}")) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				em.setFullname(rs.getString("fullname"));
				em.setGender(rs.getBoolean("gender"));
				em.setPosition(rs.getString("position"));
				em.setEmail(rs.getString("email"));
				em.setPhoneNumber(rs.getString("phoneNumber"));
				em.setDepartment_id(rs.getInt("department_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}
	public List<EmployeeManagerSite> getEmpByDpt(int dpt_id) {
		List<EmployeeManagerSite> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getEmpByDpt(?)}")) {
			cs.setInt(1, dpt_id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeManagerSite emp = new EmployeeManagerSite();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setPosition(rs.getString("position"));
				emp.setDayoff(rs.getInt("dayoff"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<EmployeeManagerSite> getAllEmpInDpt(){
		List<EmployeeManagerSite> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getAllEmpInDpt}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeManagerSite emp = new EmployeeManagerSite();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setPosition(rs.getString("position"));
				emp.setDayoff(rs.getInt("dayoff"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Employee getMgrInfo(int dpt_code) {
		Employee emp = new Employee();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getMgrInfo(?)}")) {
			cs.setInt(1, dpt_code);
			var rs = cs.executeQuery();
			if(rs.next()) {
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setGender(rs.getBoolean("gender"));
				emp.setPhoneNumber(rs.getString("phoneNumber"));
				emp.setPosition(rs.getString("position"));
				emp.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	public List<EmployeeContactInfo> getEmpInfo1(int dpt_code){
		List<EmployeeContactInfo> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getEmpInfo(?)}")) {
			cs.setInt(1, dpt_code);
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeContactInfo emp = new EmployeeContactInfo();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setGender(rs.getBoolean("gender"));
				emp.setPosition(rs.getString("position"));
				emp.setStart_to_work(rs.getDate("start_to_work").toLocalDate());
				emp.setPhoneNumber(rs.getString("phoneNumber"));
				emp.setEmail(rs.getString("email"));
				emp.setDaysleft(rs.getInt("daysleft"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<EmployeeContactInfo> getEmpInfo1(){
		List<EmployeeContactInfo> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getMgrInfoAll}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeContactInfo emp = new EmployeeContactInfo();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setGender(rs.getBoolean("gender"));
				emp.setPosition(rs.getString("position"));
				emp.setDepartment(rs.getString("name_department"));
				emp.setPhoneNumber(rs.getString("phoneNumber"));
				emp.setEmail(rs.getString("email"));
				emp.setDaysleft(rs.getInt("daysleft"));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getNewId() {
		int new_id=0;
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getNewEmp_id}")) {
			var rs = cs.executeQuery();
			if(rs.next()) {
				new_id = rs.getInt("new_id");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new_id;
	}
	public boolean checkExistPhoneAndEmail(String phone,String email) {
		String check = null;
		boolean flag=false;
		try(var con = ConnectDB.getDBProperty();
				var cs = con.prepareCall("{call checkExistedPhoneAndEmail(?,?)}")) {
				cs.setString(1, phone);
				cs.setString(2, email);
				var rs = cs.executeQuery();
				while(rs.next()) {
					check = rs.getString("check_result");
				}
				if(check==null) {
					return false;
				}
				if(check.equals("existed")||check.equals("former employee")) {
					flag = true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}
	public void addEmp(Employee emp) {
		try (var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call insertEmployee(?,?,?,?,?,?,?,?,?)}")){
			cs.setString(1, emp.getFullname());
			cs.setBoolean(2, emp.isGender());
			cs.setString(3,emp.getPosition());
			cs.setString(4, emp.getEmail());
			cs.setString(5,emp.getPhoneNumber());
			cs.setInt(6, emp.getDepartment_id());
			cs.setInt(7, emp.getManager_id());
			cs.setDate(8,java.sql.Date.valueOf(emp.getStart_to_work()));
			cs.setString(9,emp.getPicture());
			var rs = cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<EmployeeContactInfo> getnewjoins(){
		List<EmployeeContactInfo> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getNewEmp}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				EmployeeContactInfo emp = new EmployeeContactInfo();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setDepartment_code(rs.getInt("department_id"));
				emp.setDepartment(rs.getString("name_department"));
				emp.setPosition(rs.getString("position"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phoneNumber"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Employee loadAdminInfo(int emp_id) {
		Employee emp = new Employee();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getAdminInfo(?)}")) {
			cs.setInt(1, emp_id);
			var rs = cs.executeQuery();
			while(rs.next()) {
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setFullname(rs.getString("fullname"));
				emp.setGender(rs.getBoolean("gender"));
				emp.setPhoneNumber(rs.getString("phoneNumber"));
				emp.setPosition(rs.getString("position"));
				emp.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

}
