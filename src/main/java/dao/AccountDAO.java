package dao;
import java.util.*;

import javax.swing.JOptionPane;
import helper.*;
import db.ConnectDB;
import model.*;
public class AccountDAO extends EmployeeDAO{
	public void login (Account ac) {
		try(var con = ConnectDB.getDBProperty();
			var cs=con.prepareCall("{call login(?,?)}")) {
			cs.setString(1, ac.getUsername());
			cs.setString(2, ac.getPassword());
			var rs = cs.executeQuery();
			if(rs.next()) {
				User.success=true;
				User.emp_id=rs.getInt("emp_id");
				User.role=rs.getString("role");
				User.account_id=rs.getInt("account_id");
				getUserInfo(User.emp_id);
				getAccess(User.role);
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getAccess(String role) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call getAccess(?)}")) {
			cs.setString(1, role);
			var rs = cs.executeQuery();
			if(rs.next()) {
				User.access_level=rs.getInt("access_level");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getUserInfo(int id) {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call selUserInfo(?)}")) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			if(rs.next()){
				User.fullname=rs.getString("fullname");
				User.gender=rs.getBoolean("gender");
				User.position=rs.getString("position");
				var department_id=rs.getInt("department_id");
				User.department_code=department_id;
				try(var csNew=con.prepareCall("{call getDptName(?)}")) {
					csNew.setInt(1, department_id);
					var rsNew = csNew.executeQuery();
					if(rsNew.next()) {
						User.department_name=rsNew.getString("name_department");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				getLeaving(User.emp_id);
				getLeavingAllowed(User.emp_id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void makeNewAcc(){
		
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call makeAcc}")) {
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Created");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public List<AccountSend> showNewAcc(){
		List<AccountSend> list = new ArrayList<>();
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call showNewAcc}")) {
			var rs = cs.executeQuery();
			while(rs.next()) {
				AccountSend as = new AccountSend();
				as.setAccount_id(rs.getInt("account_id"));
				as.setUsername(rs.getString("username"));
				as.setPassword(rs.getString("password"));
				as.setRole(rs.getString("role"));
				as.setEmp_id(rs.getInt("emp_id"));
				as.setEmail(rs.getString("email"));
				list.add(as);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void activate() {
		try(var con = ConnectDB.getDBProperty();
			var cs = con.prepareCall("{call ActivateAcc}")) {
		
			cs.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
