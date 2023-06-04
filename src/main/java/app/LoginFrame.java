package app;

import javax.swing.Timer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.*;

import guis.*;
import model.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import helper.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dao.*;
import db.ConnectDB;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.beans.PropertyChangeEvent;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;

import java.awt.event.InputEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.text.SimpleDateFormat;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_login;
	private JButton btn_login;
	private JLabel lbl_login;
	private JLabel lbl_username;
	private JLabel lbl_password;
	private JPasswordField txt_password;
	private JTextField txt_username;
	private JPanel panel_emp;
	private JLabel lbl_success;
	private JLabel lbl_user_name;
	private JTextField txt_name;
	private JLabel lbl_gender;
	private JTextField txt_gender;
	private JLabel lbl_position;
	private JTextField txt_position;
	private JLabel lbl_department;
	private JTextField txt_department;
	private JButton btn_logout;
	private JMenuBar menuBar;
	private JLabel lblNewLabel;
	private JLabel lbl_allowed_leaving;
	private JTextField txt_allowed;
	private JLabel lbl_dayoff;
	private JTextField txt_dayoff;
	private JPanel panel_admin;
	private JLabel lbl_admin;
	private JButton btn_to_info;
	private JButton btn_admin;
	private JLabel lbl_daysleft;
	private JTextField txt_daysleft;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JPanel panel_leave;
	private JLabel lbl_leave;
	private JLabel lbl_type;
	private JComboBox cbb_leave_type;
	private JLabel lbl_reason;
	private JTextArea txt_reason;
	private JLabel lbl_name;
	private JTextField txt_name_empLeave;
	private JLabel lbl_leaveday;
	private JDateChooser start_leave;
	private JLabel lbl_to;
	private JDateChooser leave_util;
	private static JButton btn_send;
	private JButton btn_cancel;
	private JTextField txt_countday;
	private JLabel lbl_countdays;
	private JLabel lbl_allowed;
	private JTextField txt_allowed_day;
	private JLabel lbl_day_allowed;
	private JPanel panel_manager_check;
	private JLabel lbl_checkleave;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_emp_leave_check;
	private JLabel lbl_check;
	private JLabel lbl_fullname_1;
	private JTextField txt_fullname_1;
	private JLabel lbl_from;
	private JTextField txt_datefrom;
	private JLabel lbl_dateto;
	private JTextField txt_to;
	private JLabel lbl_typeLeave;
	private JTextField txt_typeof;
	private JLabel lbl_reasonwhy;
	private JTextArea txt_reasonwhy;
	private JButton btn_deny;
	private JButton btn_approve;
	private JLabel lbl_status_check;
	private JButton btn_back;
	private JLabel lbl_letter_id;
	private JTextField txt_letter_id;
	private JButton btn_next;
	private JButton btn_backLetter;
	private JPanel panel_ceo;
	private JLabel lbl_title;
	private JButton btn_list_emp_by_dpt;
	private JButton btn_make_letter;
	private JButton btn_leave_letter;
	private JButton btn_leave_today;
	private JPanel panel_employee_dpt;
	private JButton btn_switch;
	private JButton btn_back_2;
	private JLabel lbl_title_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JComboBox cbb_department;
	private JLabel lbl_label_dpt_name;
	private JLabel lbl_search;
	private JTextField txt_search_emp;
	private JPanel panel_leave_ceo_make_for_manager;
	private JLabel lbl_leave_2;
	private JLabel lbl_fullname_2;
	private JLabel lbl_leavefrom_2;
	private JDateChooser dateChooser;
	private JLabel lbl_leaveto_2;
	private JDateChooser dateChooser_1;
	private JLabel lbl_typeof_2;
	private JComboBox comboBox;
	private JTextField txt_leftdays;
	private JLabel lbl_allowed_2;
	private JTextField txt_allowed_days_2;
	private JLabel lbl_allowed_3;
	private JLabel lbl_reason_2;
	private JTextArea textArea;
	private JLabel lbl_leftday;
	private JButton btn_cancel_2;
	private JButton btn_send_2;
	private JButton btn_back_3;
	private JPanel panel_pending_manager_letter;
	private JLabel lbl_pending;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JPanel panel_leaving_history;
	private JLabel lbl_leave_history;
	private JLabel lbl_type_check;
	private JComboBox cbb_checktype;
	private JScrollPane scrollPane_3;
	private JTable table_3;
	private JButton btn_back_day;
	private JTextField txt_day_to_check;
	private JButton btn_next_day;
	private JButton btn_back_5;
	private JButton btn_back_4;
	private JLabel lbl_search_2;
	private JTextField txt_search_2;
	private JLabel lbl_sent_letters;
	private JButton btn_sent_letters;
	private JPanel panel_sent_empself_letters;
	private JLabel lbl_sent_leaves;
	private JScrollPane scrollPane_4;
	private JTable table_4;
	private JButton btn_back_6;
	private JLabel lbl_letter_id_modify;
	private static JLabel lbl_id_no;
	private JLabel lbl_checked;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private static boolean add = false;
	private boolean sent = false;
	private JLabel lbl_time;
	private JPanel panel_contact_for_emp;
	private JLabel lbl_contact1;
	private JLabel lbl_mgr_name;
	private JLabel txt_mgr_name;
	private JLabel lbl_mgr_gender;
	private JLabel txt_mgr_gender;
	private JLabel lbl_mgr_position;
	private JLabel txt_mgr_position;
	private JLabel lbl_mgr_phone;
	private JLabel txt_mgr_phone;
	private JLabel lbl_mgr_email;
	private JLabel txt_mgr_email;
	private JPanel panel_getEmployeeInfo;
	private JLabel lbl_emp_info;
	private JScrollPane scrollPane_5;
	private JTable table_5;
	private JPanel panel_add_new_emp;
	private JLabel lbl_add_new;
	private JLabel lbl_new_id;
	private JLabel lbl_new_id_1;
	private JLabel lbl_fullname_3;
	private JTextField txt_namefield_emp;
	private JLabel lbl_gender_3;
	private JRadioButton rd_male;
	private JRadioButton rd_female;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbl_department_3;
	private JComboBox cbb_department_3;
	private JLabel lbl_position_3;
	private JComboBox cbb_position_3;
	private JLabel lbl_email_3;
	private JTextField txt_email_3;
	private JLabel lbl_phone_3;
	private JTextField txt_phone_3;
	private JButton btn_cancel_3;
	private JButton btn_submit_3;
	private JLabel lbl_warning_1;
	private JLabel lbl_warning_2;
	private JLabel lbl_warning_3;
	private JButton btn_sendmail;
	private JPanel panel_newemp_table;
	private JLabel lblNewLabel_1;
	private JTabbedPane tabbedPane;
	private JPanel panel_newemp;
	private JPanel panel_newacc;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JTable table_6;
	private JTable table_7;
	private JButton btn_makeacc;
	private JButton btn_sendacc;
	private JPanel panel_sendEmail;
	private JLabel lbl_send_mail;
	private JLabel lbl_toLabel;
	private JTextField txt_toField;
	private JLabel lbl_subjectLabel;
	private JTextField txt_subjectField;
	private JLabel lbl_content;
	private JButton btn_cancel_4;
	private JButton btn_send_mail_4;
	private JScrollPane scrollPane_8;
	private JTextArea txt_message;
	private JLabel lbl_allowed_4;
	private JLabel lbl_allowed_5;
	private JLabel lbl_allowed_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeImage img = new JframeImage();
					img.setVisible(true);
					Timer timer1 = new Timer(2000,e->{
						img.dispose();
						LoginFrame frame = new LoginFrame();
						frame.setVisible(true);
						frame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosing(WindowEvent e) {
								 int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?", "Confirmation",
					                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					                if (result == JOptionPane.YES_OPTION) {
					                	if(add==true) {
					                		JOptionPane.showMessageDialog(null, "You're still updating the form, can't close the app");
					                	}else {
					                		frame.dispose();
					                		System.exit(0);
					                	}
					                	
					                }
								
							}
							public void close_suddenly() {
								if(User.success && add == true &&lbl_id_no.getText()!=null&&btn_send.getText().equals("Update")) {	
									String sql = "update leave_day_permission set daysleft-="+preCheck()+" where emp_id="+User.emp_id+" and now in( select now from (select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id="+User.emp_id+") as subq where row_num=1)";
									try(var con = ConnectDB.getDBProperty();
										var st = con.prepareStatement(sql)) {
										st.executeUpdate();
										JOptionPane.showMessageDialog(null, "Success");
									} catch (Exception e2) {
										JOptionPane.showMessageDialog(null, "error");
									}
//									try {
//										JOptionPane.showMessageDialog(null, preCheck());
//									} catch (Exception e2) {
//										e2.printStackTrace();
//									}
									
									try(var con = ConnectDB.getDBProperty();
										var st = con.prepareStatement("update dayoff set status = 3 where emp_id ="+User.emp_id+" and status = 4")) {
										st.executeUpdate();
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							}
						});
							
					});
					timer1.setRepeats(false);
					   timer1.start();
					
					

						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		
		setTitle("Employees Dayoff Management");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 421, 507);
		
		menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		menuBar.setVisible(false);
		
		
//		mnNewMenu_1 = new JMenu("Leave letters");
//		menuBar.add(mnNewMenu_1);
//		
//		mntmNewMenuItem_2 = new JMenuItem("New letter");
//		mntmNewMenuItem_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mntmNewMenuItem_2ActionPerformed(e);
//			}
//		});
		
//		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.CTRL_DOWN_MASK));
//		mnNewMenu_1.add(mntmNewMenuItem_2);
//		
//		mntmNewMenuItem = new JMenuItem("Basic information");
//		mnNewMenu_1.add(mntmNewMenuItem);
//		
//		mntmNewMenuItem_1 = new JMenuItem("Sent Letters");
//		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null);
		panel = new JPanel();
		contentPane.add(panel, "name_878510942156600");
		panel.setLayout(new CardLayout(0, 0));
		
		panel_login = new JPanel();
		panel.add(panel_login, "login");
		
		btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_loginActionPerformed(e);
			}
		});
		
		lbl_login = new JLabel("Employees Dayoff Management");
		lbl_login.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lbl_username = new JLabel("Username:");
		
		lbl_password = new JLabel("Password:");
		
		txt_password = new JPasswordField();
		txt_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txt_passwordKeyPressed(e);
			}
		});
		
		txt_username = new JTextField();
		txt_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txt_usernameKeyPressed(e);
			}
		});
		txt_username.setColumns(10);
		GroupLayout gl_panel_login = new GroupLayout(panel_login);
		gl_panel_login.setHorizontalGroup(
			gl_panel_login.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 397, Short.MAX_VALUE)
				.addGroup(gl_panel_login.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addComponent(btn_login)
					.addGap(168))
				.addGroup(gl_panel_login.createSequentialGroup()
					.addContainerGap(84, Short.MAX_VALUE)
					.addComponent(lbl_login)
					.addGap(69))
				.addGroup(gl_panel_login.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_panel_login.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_username)
						.addComponent(lbl_password, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_login.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txt_password)
						.addComponent(txt_username, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_panel_login.setVerticalGroup(
			gl_panel_login.createParallelGroup(Alignment.LEADING)
				.addGap(0, 460, Short.MAX_VALUE)
				.addGroup(gl_panel_login.createSequentialGroup()
					.addGap(131)
					.addComponent(lbl_login, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_username)
						.addComponent(txt_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_password)
						.addComponent(txt_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btn_login)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		panel_login.setLayout(gl_panel_login);
		
		panel_emp = new JPanel();
		panel.add(panel_emp, "success");
		
		lbl_success = new JLabel("Information");
		lbl_success.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_success.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_user_name = new JLabel("Fullname:");
		
		txt_name = new JTextField();
		txt_name.setBorder(null);
		txt_name.setEditable(false);
		txt_name.setColumns(10);
		
		lbl_gender = new JLabel("Gender:");
		
		txt_gender = new JTextField();
		txt_gender.setEditable(false);
		txt_gender.setBorder(null);
		txt_gender.setColumns(10);
		
		lbl_position = new JLabel("Position:");
		
		txt_position = new JTextField();
		txt_position.setEditable(false);
		txt_position.setBorder(null);
		txt_position.setColumns(10);
		
		lbl_department = new JLabel("Department:");
		
		txt_department = new JTextField();
		txt_department.setEditable(false);
		txt_department.setBorder(null);
		txt_department.setColumns(10);
		
		btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_logoutActionPerformed(e);
			}
		});
		
		lbl_allowed_leaving = new JLabel("Total Leave Days Allowed:");
		
		txt_allowed = new JTextField();
		txt_allowed.setEditable(false);
		txt_allowed.setBorder(null);
		txt_allowed.setColumns(10);
		
		lbl_dayoff = new JLabel("Leaving Days:");
		
		txt_dayoff = new JTextField();
		txt_dayoff.setEditable(false);
		txt_dayoff.setBorder(null);
		txt_dayoff.setColumns(10);
		
		btn_admin = new JButton("Admin control");
		btn_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_adminActionPerformed(e);
			}
		});
		
		lbl_daysleft = new JLabel("Days left:");
		
		txt_daysleft = new JTextField();
		txt_daysleft.setEditable(false);
		txt_daysleft.setBorder(null);
		txt_daysleft.setColumns(10);
		
		lbl_sent_letters = new JLabel("Sent letters:");
		
		btn_sent_letters = new JButton("Details");
		btn_sent_letters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_sent_lettersActionPerformed(e);
			}
		});
		
		lbl_time = new JLabel("null");
		GroupLayout gl_panel_emp = new GroupLayout(panel_emp);
		gl_panel_emp.setHorizontalGroup(
			gl_panel_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_emp.createSequentialGroup()
					.addGap(33)
					.addComponent(lbl_time, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(btn_admin)
					.addGap(25))
				.addGroup(gl_panel_emp.createSequentialGroup()
					.addGap(161)
					.addComponent(btn_logout)
					.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(gl_panel_emp.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_emp.createSequentialGroup()
							.addComponent(lbl_sent_letters, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_sent_letters)
							.addGap(112))
						.addGroup(gl_panel_emp.createSequentialGroup()
							.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_emp.createSequentialGroup()
									.addComponent(lbl_gender, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(txt_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_emp.createSequentialGroup()
									.addComponent(lbl_allowed_leaving, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txt_allowed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_emp.createSequentialGroup()
									.addComponent(lbl_dayoff, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txt_dayoff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_emp.createSequentialGroup()
									.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_department, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_position, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_position, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_department, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
								.addGroup(gl_panel_emp.createSequentialGroup()
									.addComponent(lbl_daysleft, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txt_daysleft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_emp.createParallelGroup(Alignment.TRAILING)
									.addComponent(lbl_success, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_emp.createSequentialGroup()
										.addComponent(lbl_user_name, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(36, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_emp.setVerticalGroup(
			gl_panel_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_emp.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_admin)
						.addComponent(lbl_time))
					.addGap(11)
					.addComponent(lbl_success, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_user_name)
						.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_emp.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_gender))
						.addComponent(txt_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_emp.createSequentialGroup()
							.addGap(9)
							.addComponent(lbl_position))
						.addGroup(gl_panel_emp.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_department)
						.addComponent(txt_department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_allowed_leaving)
						.addComponent(txt_allowed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_dayoff)
						.addComponent(txt_dayoff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_daysleft)
						.addComponent(txt_daysleft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_emp.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_sent_letters)
						.addComponent(btn_sent_letters))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btn_logout)
					.addGap(72))
		);
		panel_emp.setLayout(gl_panel_emp);
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel,"login");
		
		panel_admin = new JPanel();
		panel.add(panel_admin, "admin");
		
		lbl_admin = new JLabel("Admin");
		lbl_admin.setFont(new Font("Dialog", Font.PLAIN, 18));
		lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
		
		btn_to_info = new JButton("Admin info");
		btn_to_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_to_infoActionPerformed(e);
			}
		});
		
		btn_switch = new JButton("Go to panel CEO");
		btn_switch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_switchActionPerformed(e);
			}
		});
		GroupLayout gl_panel_admin = new GroupLayout(panel_admin);
		gl_panel_admin.setHorizontalGroup(
			gl_panel_admin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_admin.createSequentialGroup()
					.addGroup(gl_panel_admin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_admin.createSequentialGroup()
							.addGap(19)
							.addComponent(btn_to_info))
						.addGroup(gl_panel_admin.createSequentialGroup()
							.addGap(142)
							.addGroup(gl_panel_admin.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_switch)
								.addComponent(lbl_admin, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_panel_admin.setVerticalGroup(
			gl_panel_admin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_admin.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_to_info)
					.addGap(88)
					.addComponent(lbl_admin)
					.addGap(37)
					.addComponent(btn_switch)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		panel_admin.setLayout(gl_panel_admin);
		
		panel_leave = new JPanel();
		
		panel_leave.setBorder(null);
		panel.add(panel_leave, "leave");
		
		lbl_leave = new JLabel("Leave letter");
		lbl_leave.setFont(new Font("Dialog", Font.PLAIN, 18));
		lbl_leave.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_type = new JLabel("Type of Leave:");
		
		cbb_leave_type = new JComboBox();
		cbb_leave_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_leave_typeActionPerformed(e);
			}
		});
		
		lbl_reason = new JLabel("Reason:");
		
		txt_reason = new JTextArea();
		txt_reason.setLineWrap(true);
		
		lbl_name = new JLabel("Fullname:");
		
		txt_name_empLeave = new JTextField();
		txt_name_empLeave.setSelectedTextColor(new Color(0, 0, 0));
		txt_name_empLeave.setForeground(new Color(0, 0, 0));
		txt_name_empLeave.setBorder(null);
		txt_name_empLeave.setEditable(false);
		txt_name_empLeave.setColumns(10);
		lbl_leaveday = new JLabel("Leave day:");
		
		txt_countday = new JTextField();
		txt_countday.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_countday.setText("1");
		txt_countday.setBorder(null);
		txt_countday.setEditable(false);
		txt_countday.setColumns(10);
		start_leave = new JDateChooser();
		start_leave.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				start_leavePropertyChange(evt);
			}
		});
		leave_util = new JDateChooser();
		leave_util.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				leave_utilPropertyChange(evt);
			}
		});
		
		leave_util.setDateFormatString("yyyy-MM-dd");
		leave_util.setDate(new Date());
		start_leave.setDateFormatString("yyyy-MM-dd");
		start_leave.setDate(new Date());
		start_leave.setMinSelectableDate(new Date());
		Date selectedDate = start_leave.getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		Date nextDay = calendar.getTime();
		lbl_to = new JLabel("Until:");
		leave_util.setDate(nextDay);
		leave_util.setMinSelectableDate(nextDay);
		
		btn_send = new JButton("Send");
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_sendActionPerformed(e);
			}
		});
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cancelActionPerformed(e);
			}
		});
		
		
		;
		lbl_countdays = new JLabel("day");
		
		lbl_allowed = new JLabel("Allowed:");
		
		txt_allowed_day = new JTextField();
		txt_allowed_day.setEditable(false);
		txt_allowed_day.setHorizontalAlignment(SwingConstants.CENTER);
		txt_allowed_day.setColumns(10);
		
		lbl_day_allowed = new JLabel("day");
		
		lbl_letter_id_modify = new JLabel("Letter id:");
		lbl_letter_id_modify.setVisible(false);
		lbl_id_no = new JLabel("0");
		lbl_id_no.setVisible(false);
		
		lbl_checked = new JLabel("New label");
		lbl_checked.setVisible(false);
		GroupLayout gl_panel_leave = new GroupLayout(panel_leave);
		gl_panel_leave.setHorizontalGroup(
			gl_panel_leave.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(122)
					.addComponent(lbl_leave, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_leave.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_to, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(leave_util, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(txt_countday, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_countdays, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(33))
						.addGroup(gl_panel_leave.createSequentialGroup()
							.addComponent(lbl_leaveday, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(start_leave, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(123))
						.addGroup(Alignment.LEADING, gl_panel_leave.createSequentialGroup()
							.addComponent(lbl_name, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_name_empLeave, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
							.addGap(134))
						.addGroup(gl_panel_leave.createSequentialGroup()
							.addGroup(gl_panel_leave.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_leave.createSequentialGroup()
									.addComponent(lbl_type, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbb_leave_type, 0, 132, Short.MAX_VALUE))
								.addGroup(gl_panel_leave.createSequentialGroup()
									.addComponent(lbl_reason, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txt_reason, GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)))
							.addGap(106))))
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(133)
					.addComponent(btn_cancel, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(btn_send, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(95))
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(127)
					.addComponent(lbl_allowed, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_allowed_day, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_day_allowed, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addContainerGap(257, Short.MAX_VALUE)
					.addComponent(lbl_letter_id_modify, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbl_id_no, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(185)
					.addComponent(lbl_checked, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(173))
		);
		gl_panel_leave.setVerticalGroup(
			gl_panel_leave.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_leave.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_letter_id_modify)
						.addComponent(lbl_id_no))
					.addGap(18)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
							.addComponent(txt_countday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbl_countdays))
						.addGroup(gl_panel_leave.createSequentialGroup()
							.addComponent(lbl_leave)
							.addGap(18)
							.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_name_empLeave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_name))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_leave.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_leaveday)
								.addComponent(start_leave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(gl_panel_leave.createParallelGroup(Alignment.LEADING)
								.addComponent(leave_util, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_to))))
					.addGap(18)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_type)
						.addComponent(cbb_leave_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_allowed)
						.addComponent(txt_allowed_day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_day_allowed))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_reason)
						.addComponent(txt_reason, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lbl_checked)
					.addGap(14)
					.addGroup(gl_panel_leave.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_send)
						.addComponent(btn_cancel))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel_leave.setLayout(gl_panel_leave);
		
		panel_manager_check = new JPanel();
		panel.add(panel_manager_check, "leave_check");
		
		lbl_checkleave = new JLabel("Leaving letter");
		lbl_checkleave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_checkleave.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel_manager_check = new GroupLayout(panel_manager_check);
		gl_panel_manager_check.setHorizontalGroup(
			gl_panel_manager_check.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager_check.createSequentialGroup()
					.addGroup(gl_panel_manager_check.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_manager_check.createSequentialGroup()
							.addGap(120)
							.addComponent(lbl_checkleave, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addGap(111))
						.addGroup(gl_panel_manager_check.createSequentialGroup()
							.addGap(33)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
					.addGap(34))
		);
		gl_panel_manager_check.setVerticalGroup(
			gl_panel_manager_check.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager_check.createSequentialGroup()
					.addGap(47)
					.addComponent(lbl_checkleave)
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		panel_manager_check.setLayout(gl_panel_manager_check);
		
		panel_emp_leave_check = new JPanel();
		panel.add(panel_emp_leave_check, "check");
		
		lbl_check = new JLabel("Leave Letter");
		lbl_check.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_check.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_fullname_1 = new JLabel("Fullname:");
		
		txt_fullname_1 = new JTextField();
		txt_fullname_1.setBorder(null);
		txt_fullname_1.setEditable(false);
		txt_fullname_1.setColumns(10);
		
		lbl_from = new JLabel("From:");
		
		txt_datefrom = new JTextField();
		txt_datefrom.setEditable(false);
		txt_datefrom.setBorder(null);
		txt_datefrom.setColumns(10);
		
		lbl_dateto = new JLabel("To:");
		
		txt_to = new JTextField();
		txt_to.setEditable(false);
		txt_to.setBorder(null);
		txt_to.setColumns(10);
		
		lbl_typeLeave = new JLabel("Type of leave: ");
		
		txt_typeof = new JTextField();
		txt_typeof.setEditable(false);
		txt_typeof.setBorder(null);
		txt_typeof.setColumns(10);
		
		lbl_reasonwhy = new JLabel("Reason: ");
		
		txt_reasonwhy = new JTextArea();
		txt_reasonwhy.setEditable(false);
		
		btn_deny = new JButton("Deny");
		btn_deny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_denyActionPerformed(e);
			}
		});
		
		btn_approve = new JButton("Approve");
		btn_approve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_approveActionPerformed(e);
			}
		});
		
		lbl_status_check = new JLabel("Null");
		lbl_status_check.setHorizontalAlignment(SwingConstants.CENTER);
		
		btn_back = new JButton("Back to table");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_backActionPerformed(e);
			}
		});
		
		lbl_letter_id = new JLabel("Letter id:");
		lbl_letter_id.setHorizontalAlignment(SwingConstants.CENTER);
		
		txt_letter_id = new JTextField();
		txt_letter_id.setBorder(null);
		txt_letter_id.setEditable(false);
		txt_letter_id.setColumns(10);
		
		btn_next = new JButton("Next");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_nextActionPerformed(e);
			}
		});
		
		btn_backLetter = new JButton("Back");
		btn_backLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_backLetterActionPerformed(e);
			}
		});
		btn_backLetter.setHorizontalAlignment(SwingConstants.LEADING);
		
		lbl_allowed_4 = new JLabel("Allowed:");
		
		lbl_allowed_5 = new JLabel("0");
		
		lbl_allowed_6 = new JLabel("days");
		GroupLayout gl_panel_emp_leave_check = new GroupLayout(panel_emp_leave_check);
		gl_panel_emp_leave_check.setHorizontalGroup(
			gl_panel_emp_leave_check.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
					.addGap(120)
					.addComponent(lbl_check, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(152))
				.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back)
					.addGap(105)
					.addComponent(lbl_letter_id, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txt_letter_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_backLetter, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_from, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
								.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
									.addComponent(lbl_dateto, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
									.addGap(5)))
							.addGap(33)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.TRAILING)
								.addComponent(txt_datefrom, 107, 107, 107)
								.addComponent(txt_to, 107, 107, 107))
							.addGap(24))
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addComponent(lbl_fullname_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(txt_fullname_1, 107, 107, 107)
							.addGap(24))
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
									.addComponent(btn_deny, GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
									.addGap(53)
									.addComponent(btn_approve, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE))
								.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
									.addComponent(lbl_reasonwhy, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_reasonwhy, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(14)))
							.addGap(15))
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
									.addComponent(lbl_allowed_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
									.addComponent(lbl_allowed_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addComponent(lbl_typeLeave, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_typeof, 107, 107, 107)
								.addComponent(lbl_allowed_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
					.addGap(4)
					.addComponent(btn_next)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel_emp_leave_check.createSequentialGroup()
					.addGap(123)
					.addComponent(lbl_status_check, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(140))
		);
		gl_panel_emp_leave_check.setVerticalGroup(
			gl_panel_emp_leave_check.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_back)
						.addComponent(lbl_letter_id)
						.addComponent(txt_letter_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addGap(18)
							.addComponent(lbl_check)
							.addGap(18)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_fullname_1)
								.addComponent(txt_fullname_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_datefrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_from))
							.addGap(18)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_dateto)
								.addComponent(txt_to, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_typeLeave)
								.addComponent(txt_typeof, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_allowed_4)
								.addComponent(lbl_allowed_5)
								.addComponent(lbl_allowed_6))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_reasonwhy)
								.addComponent(txt_reasonwhy, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lbl_status_check)
							.addGap(7)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_deny)
								.addComponent(btn_approve)))
						.addGroup(gl_panel_emp_leave_check.createSequentialGroup()
							.addGap(134)
							.addGroup(gl_panel_emp_leave_check.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_next)
								.addComponent(btn_backLetter))))
					.addGap(23))
		);
		panel_emp_leave_check.setLayout(gl_panel_emp_leave_check);
		
		panel_ceo = new JPanel();
		panel.add(panel_ceo, "ceo");
		
		lbl_title = new JLabel("Leaving Management");
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		
		btn_list_emp_by_dpt = new JButton("Department employees list");
		btn_list_emp_by_dpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_list_emp_by_dptActionPerformed(e);
			}
		});
		
		btn_make_letter = new JButton("Make a leave letter");
		btn_make_letter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_make_letterActionPerformed(e);
			}
		});
		
		btn_leave_letter = new JButton("Pending manager leave letters");
		btn_leave_letter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_leave_letterActionPerformed(e);
			}
		});
		
		btn_leave_today = new JButton("Leave history counting");
		btn_leave_today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_leave_todayActionPerformed(e);
			}
		});
		GroupLayout gl_panel_ceo = new GroupLayout(panel_ceo);
		gl_panel_ceo.setHorizontalGroup(
			gl_panel_ceo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ceo.createSequentialGroup()
					.addGroup(gl_panel_ceo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_ceo.createSequentialGroup()
							.addGap(95)
							.addComponent(lbl_title, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_ceo.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel_ceo.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_make_letter)
								.addComponent(btn_list_emp_by_dpt)
								.addComponent(btn_leave_letter)
								.addComponent(btn_leave_today))))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel_ceo.setVerticalGroup(
			gl_panel_ceo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ceo.createSequentialGroup()
					.addGap(82)
					.addComponent(lbl_title)
					.addGap(37)
					.addComponent(btn_list_emp_by_dpt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_make_letter)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_leave_letter)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_leave_today)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		panel_ceo.setLayout(gl_panel_ceo);
		
		panel_employee_dpt = new JPanel();
		panel.add(panel_employee_dpt, "employee_dpt");
		
		btn_back_2 = new JButton("Back ");
		btn_back_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_2ActionPerformed(e);
			}
		});
		
		lbl_title_2 = new JLabel("Employees in Department");
		lbl_title_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_title_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane_1 = new JScrollPane();
		
		cbb_department = new JComboBox();
		cbb_department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_departmentActionPerformed(e);
			}
		});
		
		lbl_label_dpt_name = new JLabel("Department:");
		
		lbl_search = new JLabel("Search:");
		
		txt_search_emp = new JTextField();
		txt_search_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_search_empActionPerformed(e);
			}
		});
		txt_search_emp.setColumns(10);
		
		JButton btnIn = new JButton("Print");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployeeByDeptReport();
			}
		});
		GroupLayout gl_panel_employee_dpt = new GroupLayout(panel_employee_dpt);
		gl_panel_employee_dpt.setHorizontalGroup(
			gl_panel_employee_dpt.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_employee_dpt.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_2)
					.addContainerGap(330, Short.MAX_VALUE))
				.addGroup(gl_panel_employee_dpt.createSequentialGroup()
					.addGap(58)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_panel_employee_dpt.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_panel_employee_dpt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_employee_dpt.createSequentialGroup()
							.addComponent(lbl_title_2, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_panel_employee_dpt.createSequentialGroup()
							.addGroup(gl_panel_employee_dpt.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_label_dpt_name, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_search, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_employee_dpt.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txt_search_emp)
								.addComponent(cbb_department, 0, 156, Short.MAX_VALUE))))
					.addGap(101))
				.addGroup(Alignment.LEADING, gl_panel_employee_dpt.createSequentialGroup()
					.addGap(129)
					.addComponent(btnIn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panel_employee_dpt.setVerticalGroup(
			gl_panel_employee_dpt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_employee_dpt.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_title_2)
					.addGap(20)
					.addGroup(gl_panel_employee_dpt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_search)
						.addComponent(txt_search_emp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_employee_dpt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_label_dpt_name)
						.addComponent(cbb_department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnIn)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		panel_employee_dpt.setLayout(gl_panel_employee_dpt);
		
		panel_leave_ceo_make_for_manager = new JPanel();
		panel.add(panel_leave_ceo_make_for_manager, "leave_2");
		
		lbl_leave_2 = new JLabel("Leave Letter");
		lbl_leave_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_leave_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_fullname_2 = new JLabel("Fullname:");
		
		lbl_leavefrom_2 = new JLabel("Leave day:");
		
		dateChooser = new JDateChooser();
		
		lbl_leaveto_2 = new JLabel("Until:");
		
		dateChooser_1 = new JDateChooser();
		
		lbl_typeof_2 = new JLabel("Type of Leave:");
		
		comboBox = new JComboBox();
		
		txt_leftdays = new JTextField();
		txt_leftdays.setColumns(10);
		
		lbl_allowed_2 = new JLabel("Allowed:");
		
		txt_allowed_days_2 = new JTextField();
		txt_allowed_days_2.setColumns(10);
		
		lbl_allowed_3 = new JLabel("day");
		
		lbl_reason_2 = new JLabel("Reason:");
		
		textArea = new JTextArea();
		
		lbl_leftday = new JLabel("day");
		
		btn_cancel_2 = new JButton("Cancel");
		
		btn_send_2 = new JButton("Send");
		
		btn_back_3 = new JButton("Back");
		btn_back_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_3ActionPerformed(e);
			}
		});
		
		comboBox_1 = new JComboBox();
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		GroupLayout gl_panel_leave_ceo_make_for_manager = new GroupLayout(panel_leave_ceo_make_for_manager);
		gl_panel_leave_ceo_make_for_manager.setHorizontalGroup(
			gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addGap(88)
									.addComponent(lbl_leave_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_leavefrom_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_fullname_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_leaveto_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(dateChooser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
									.addGap(26)
									.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
											.addComponent(txt_leftdays, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lbl_leftday, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
											.addGap(20))
										.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addGap(8)))))
							.addGap(13))
						.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addComponent(lbl_typeof_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, 0, 135, Short.MAX_VALUE))
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addComponent(lbl_reason_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addComponent(btn_send_2, Alignment.TRAILING))
							.addGap(126))))
				.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
					.addGap(71)
					.addComponent(lbl_allowed_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt_allowed_days_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbl_allowed_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
				.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
					.addGap(77)
					.addComponent(btn_cancel_2)
					.addContainerGap(255, Short.MAX_VALUE))
				.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_3)
					.addContainerGap(332, Short.MAX_VALUE))
		);
		gl_panel_leave_ceo_make_for_manager.setVerticalGroup(
			gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
					.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addGap(34)
									.addComponent(lbl_leave_2))
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addContainerGap()
									.addComponent(btn_back_3)))
							.addGap(22)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_fullname_2)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_leavefrom_2)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addComponent(lbl_leaveto_2)
									.addGap(64))
								.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
									.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_typeof_2))
									.addGap(18)))
							.addGap(8)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_allowed_2)
								.addComponent(txt_allowed_days_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_allowed_3))
							.addGap(30)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_reason_2)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_leave_ceo_make_for_manager.createSequentialGroup()
							.addGap(139)
							.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_leftdays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_leftday))))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel_leave_ceo_make_for_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_cancel_2)
						.addComponent(btn_send_2))
					.addGap(28))
		);
		panel_leave_ceo_make_for_manager.setLayout(gl_panel_leave_ceo_make_for_manager);
		
		panel_pending_manager_letter = new JPanel();
		panel.add(panel_pending_manager_letter, "pending_manager_letter");
		
		lbl_pending = new JLabel("Pending Leave Letters");
		lbl_pending.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_pending.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane_2 = new JScrollPane();
		
		btn_back_4 = new JButton("Back");
		btn_back_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_4ActionPerformed(e);
			}
		});
		GroupLayout gl_panel_pending_manager_letter = new GroupLayout(panel_pending_manager_letter);
		gl_panel_pending_manager_letter.setHorizontalGroup(
			gl_panel_pending_manager_letter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_pending_manager_letter.createSequentialGroup()
					.addGap(97)
					.addComponent(lbl_pending, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addGap(109))
				.addGroup(gl_panel_pending_manager_letter.createSequentialGroup()
					.addGap(34)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(Alignment.LEADING, gl_panel_pending_manager_letter.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_4)
					.addContainerGap(298, Short.MAX_VALUE))
		);
		gl_panel_pending_manager_letter.setVerticalGroup(
			gl_panel_pending_manager_letter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_pending_manager_letter.createSequentialGroup()
					.addGap(12)
					.addComponent(btn_back_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_pending, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_2MouseClicked(e);
			}
		});
		scrollPane_2.setViewportView(table_2);
		panel_pending_manager_letter.setLayout(gl_panel_pending_manager_letter);
		
		panel_leaving_history = new JPanel();
		panel.add(panel_leaving_history, "leaving_history");
		
		lbl_leave_history = new JLabel("Leaving Management Records");
		lbl_leave_history.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_leave_history.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_type_check = new JLabel("Check:");
		
		cbb_checktype = new JComboBox();
		cbb_checktype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_checktypeActionPerformed(e);
			}
		});
		cbb_checktype.setModel(new DefaultComboBoxModel(new String[] {"Checked letters", "Rejected letters", "Pending letters", "Leaving employees in selected day"}));
		
		scrollPane_3 = new JScrollPane();
		
		btn_back_day = new JButton("Back");
		btn_back_day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_dayActionPerformed(e);
			}
		});
		
		txt_day_to_check = new JTextField();
		txt_day_to_check.setEditable(false);
		txt_day_to_check.setHorizontalAlignment(SwingConstants.CENTER);
		txt_day_to_check.setColumns(10);
		
		btn_next_day = new JButton("Next");
		btn_next_day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_next_dayActionPerformed(e);
			}
		});
		
		btn_back_5 = new JButton("Back");
		btn_back_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_5ActionPerformed(e);
			}
		});
		
		lbl_search_2 = new JLabel("Search:");
		
		txt_search_2 = new JTextField();
		txt_search_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_search_2ActionPerformed(e);
			}
		});
		txt_search_2.setColumns(10);
		GroupLayout gl_panel_leaving_history = new GroupLayout(panel_leaving_history);
		gl_panel_leaving_history.setHorizontalGroup(
			gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_leaving_history.createSequentialGroup()
					.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_leaving_history.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbl_leave_history, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_leaving_history.createSequentialGroup()
									.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_type_check, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_search_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_search_2, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
										.addComponent(cbb_checktype, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(10))
						.addGroup(gl_panel_leaving_history.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_leaving_history.createSequentialGroup()
									.addComponent(btn_back_day)
									.addGap(18)
									.addComponent(txt_day_to_check, 148, 148, 148)
									.addGap(18)
									.addComponent(btn_next_day))
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
						.addGroup(gl_panel_leaving_history.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_back_5)))
					.addGap(53))
		);
		gl_panel_leaving_history.setVerticalGroup(
			gl_panel_leaving_history.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_leaving_history.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_5)
					.addGap(18)
					.addComponent(lbl_leave_history, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl_search_2)
						.addComponent(txt_search_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_type_check)
						.addComponent(cbb_checktype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_leaving_history.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_back_day)
						.addComponent(btn_next_day)
						.addComponent(txt_day_to_check, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		panel_leaving_history.setLayout(gl_panel_leaving_history);
		
		panel_sent_empself_letters = new JPanel();
		panel.add(panel_sent_empself_letters, "sent");
		
		lbl_sent_leaves = new JLabel("Sent Leaving Letters");
		lbl_sent_leaves.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sent_leaves.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		scrollPane_4 = new JScrollPane();
		
		btn_back_6 = new JButton("Back");
		btn_back_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back_6ActionPerformed(e);
			}
		});
		GroupLayout gl_panel_sent_empself_letters = new GroupLayout(panel_sent_empself_letters);
		gl_panel_sent_empself_letters.setHorizontalGroup(
			gl_panel_sent_empself_letters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sent_empself_letters.createSequentialGroup()
					.addGroup(gl_panel_sent_empself_letters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_sent_empself_letters.createSequentialGroup()
							.addGap(85)
							.addComponent(lbl_sent_leaves, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
							.addGap(72))
						.addGroup(gl_panel_sent_empself_letters.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
						.addGroup(gl_panel_sent_empself_letters.createSequentialGroup()
							.addGap(18)
							.addComponent(btn_back_6)))
					.addGap(35))
		);
		gl_panel_sent_empself_letters.setVerticalGroup(
			gl_panel_sent_empself_letters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sent_empself_letters.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_back_6)
					.addGap(15)
					.addComponent(lbl_sent_leaves)
					.addGap(51)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		
		table_4 = new JTable();
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_4MouseClicked(e);
			}
		});
		
		scrollPane_4.setViewportView(table_4);
		panel_sent_empself_letters.setLayout(gl_panel_sent_empself_letters);
		
		panel_contact_for_emp = new JPanel();
		panel.add(panel_contact_for_emp, "mgr_info");
		
		lbl_contact1 = new JLabel("Contact Manager Information:");
		lbl_contact1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contact1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_mgr_name = new JLabel("Manager's name:");
		
		txt_mgr_name = new JLabel("null");
		
		lbl_mgr_gender = new JLabel("Gender:");
		
		txt_mgr_gender = new JLabel("null");
		
		lbl_mgr_position = new JLabel("Position:");
		
		txt_mgr_position = new JLabel("null");
		
		lbl_mgr_phone = new JLabel("Phone number:");
		
		txt_mgr_phone = new JLabel("null");
		
		lbl_mgr_email = new JLabel("Email:");
		
		txt_mgr_email = new JLabel("null");
		
		btn_sendmail = new JButton("New button");
		GroupLayout gl_panel_contact_for_emp = new GroupLayout(panel_contact_for_emp);
		gl_panel_contact_for_emp.setHorizontalGroup(
			gl_panel_contact_for_emp.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_mgr_phone, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
								.addComponent(lbl_mgr_name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
									.addComponent(lbl_mgr_gender, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addGap(36))
								.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
									.addComponent(lbl_mgr_position, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addGap(36))
								.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
									.addComponent(lbl_mgr_email, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addGap(36)))
							.addGap(18)
							.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txt_mgr_name, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(txt_mgr_position, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_mgr_gender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_mgr_phone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_mgr_email, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
							.addGap(55)
							.addComponent(lbl_contact1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
					.addGap(88))
				.addGroup(Alignment.LEADING, gl_panel_contact_for_emp.createSequentialGroup()
					.addGap(146)
					.addComponent(btn_sendmail, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(153))
		);
		gl_panel_contact_for_emp.setVerticalGroup(
			gl_panel_contact_for_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_contact_for_emp.createSequentialGroup()
					.addGap(55)
					.addComponent(lbl_contact1)
					.addGap(31)
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_mgr_name)
						.addComponent(txt_mgr_name))
					.addGap(18)
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_mgr_gender)
						.addComponent(txt_mgr_gender))
					.addGap(18)
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_mgr_position)
						.addComponent(txt_mgr_position))
					.addGap(18)
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_mgr_phone)
						.addComponent(txt_mgr_phone))
					.addGap(18)
					.addGroup(gl_panel_contact_for_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_mgr_email)
						.addComponent(txt_mgr_email))
					.addGap(42)
					.addComponent(btn_sendmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		panel_contact_for_emp.setLayout(gl_panel_contact_for_emp);
		
		panel_getEmployeeInfo = new JPanel();
		panel.add(panel_getEmployeeInfo, "emp_info");
		
		lbl_emp_info = new JLabel("Employee's infomation");
		lbl_emp_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_emp_info.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_getEmployeeInfo = new GroupLayout(panel_getEmployeeInfo);
		gl_panel_getEmployeeInfo.setHorizontalGroup(
			gl_panel_getEmployeeInfo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_getEmployeeInfo.createSequentialGroup()
					.addGap(86)
					.addComponent(lbl_emp_info, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addGap(95))
				.addGroup(gl_panel_getEmployeeInfo.createSequentialGroup()
					.addGap(48)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addGap(43))
		);
		gl_panel_getEmployeeInfo.setVerticalGroup(
			gl_panel_getEmployeeInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_getEmployeeInfo.createSequentialGroup()
					.addGap(57)
					.addComponent(lbl_emp_info)
					.addGap(36)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		panel_getEmployeeInfo.setLayout(gl_panel_getEmployeeInfo);
		
		panel_add_new_emp = new JPanel();
		panel.add(panel_add_new_emp, "add_emp");
		
		lbl_add_new = new JLabel("Add New Employee");
		lbl_add_new.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_add_new.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_new_id = new JLabel("Emp id:");
		
		lbl_new_id_1 = new JLabel("null");
		lbl_new_id_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_fullname_3 = new JLabel("Fullname:");
		
		txt_namefield_emp = new JTextField();
		txt_namefield_emp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txt_namefield_empKeyPressed(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				txt_namefield_empKeyReleased(e);
			}
		});
		txt_namefield_emp.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				txt_namefield_empPropertyChange(evt);
			}
		});
		txt_namefield_emp.setColumns(10);
		
		lbl_gender_3 = new JLabel("Gender:");
		
		rd_male = new JRadioButton("Male");
		buttonGroup.add(rd_male);
		rd_male.setSelected(true);
		
		rd_female = new JRadioButton("Female");
		buttonGroup.add(rd_female);
		
		lbl_department_3 = new JLabel("Department:");
		
		cbb_department_3 = new JComboBox();
		
		lbl_position_3 = new JLabel("Position:");
		
		cbb_position_3 = new JComboBox();
		
		lbl_email_3 = new JLabel("Email:");
		
		txt_email_3 = new JTextField();
		txt_email_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txt_email_3KeyReleased(e);
			}
		});
		txt_email_3.setColumns(10);
		
		lbl_phone_3 = new JLabel("Phone number:");
		
		txt_phone_3 = new JTextField();
		txt_phone_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txt_phone_3KeyReleased(e);
			}
		});
		txt_phone_3.setColumns(10);
		
		btn_cancel_3 = new JButton("Cancel");
		btn_cancel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cancel_3ActionPerformed(e);
			}
		});
		
		btn_submit_3 = new JButton("Submit");
		btn_submit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_submit_3ActionPerformed(e);
			}
		});
		
		lbl_warning_1 = new JLabel("null");
		
		lbl_warning_2 = new JLabel("null");
		
		lbl_warning_3 = new JLabel("null");
		GroupLayout gl_panel_add_new_emp = new GroupLayout(panel_add_new_emp);
		gl_panel_add_new_emp.setHorizontalGroup(
			gl_panel_add_new_emp.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_add_new_emp.createSequentialGroup()
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_add_new_emp.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_add_new_emp.createSequentialGroup()
									.addComponent(lbl_email_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addGap(176))
								.addGroup(gl_panel_add_new_emp.createSequentialGroup()
									.addComponent(lbl_new_id, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addGap(29)
									.addComponent(lbl_new_id_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addGap(23))
								.addGroup(gl_panel_add_new_emp.createSequentialGroup()
									.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_position_3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addComponent(lbl_department_3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addComponent(lbl_fullname_3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addComponent(lbl_gender_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
											.addGap(16)))
									.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rd_male, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rd_female, 0, 82, Short.MAX_VALUE))
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addGap(23)
											.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.LEADING)
												.addComponent(cbb_position_3, 0, 135, Short.MAX_VALUE)
												.addComponent(cbb_department_3, 0, 135, Short.MAX_VALUE)))
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addGap(28)
											.addComponent(txt_namefield_emp, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
									.addGap(2))
								.addGroup(gl_panel_add_new_emp.createSequentialGroup()
									.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addGap(20)
											.addComponent(btn_cancel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lbl_phone_3, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.TRAILING)
										.addComponent(txt_phone_3, Alignment.LEADING, 134, 134, 134)
										.addComponent(txt_email_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
										.addGroup(gl_panel_add_new_emp.createSequentialGroup()
											.addGap(67)
											.addComponent(btn_submit_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGroup(gl_panel_add_new_emp.createSequentialGroup()
							.addGap(87)
							.addComponent(lbl_add_new, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
					.addGap(24)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_warning_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_warning_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_warning_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		gl_panel_add_new_emp.setVerticalGroup(
			gl_panel_add_new_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_add_new_emp.createSequentialGroup()
					.addGap(40)
					.addComponent(lbl_add_new)
					.addGap(18)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_new_id)
						.addComponent(lbl_new_id_1))
					.addGap(18)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_fullname_3)
						.addComponent(txt_namefield_emp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_warning_1))
					.addGap(18)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_gender_3)
						.addComponent(rd_male)
						.addComponent(rd_female))
					.addGap(18)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_department_3)
						.addComponent(cbb_department_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_position_3)
						.addComponent(cbb_position_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_email_3)
						.addComponent(txt_email_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_warning_2))
					.addGap(30)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_phone_3)
						.addComponent(txt_phone_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_warning_3))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_panel_add_new_emp.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_cancel_3)
						.addComponent(btn_submit_3))
					.addGap(24))
		);
		panel_add_new_emp.setLayout(gl_panel_add_new_emp);
		
		panel_newemp_table = new JPanel();
		panel.add(panel_newemp_table, "combinedEmpAndAcc");
		
		lblNewLabel_1 = new JLabel("New joining Employees");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		btn_makeacc = new JButton("Make multiple accounts");
		btn_makeacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_makeaccActionPerformed(e);
			}
		});
		
		btn_sendacc = new JButton("Send multiple accounts");
		btn_sendacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_sendaccActionPerformed(e);
			}
		});
		GroupLayout gl_panel_newemp_table = new GroupLayout(panel_newemp_table);
		gl_panel_newemp_table.setHorizontalGroup(
			gl_panel_newemp_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_newemp_table.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(85))
				.addGroup(gl_panel_newemp_table.createSequentialGroup()
					.addGap(68)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
				.addGroup(Alignment.TRAILING, gl_panel_newemp_table.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_panel_newemp_table.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_makeacc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(btn_sendacc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(129))
		);
		gl_panel_newemp_table.setVerticalGroup(
			gl_panel_newemp_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_newemp_table.createSequentialGroup()
					.addGap(63)
					.addComponent(lblNewLabel_1)
					.addGap(47)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_makeacc)
					.addGap(18)
					.addComponent(btn_sendacc)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		panel_newemp = new JPanel();
		tabbedPane.addTab("New Emps", null, panel_newemp, null);
		
		scrollPane_6 = new JScrollPane();
		GroupLayout gl_panel_newemp = new GroupLayout(panel_newemp);
		gl_panel_newemp.setHorizontalGroup(
			gl_panel_newemp.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
		);
		gl_panel_newemp.setVerticalGroup(
			gl_panel_newemp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_newemp.createSequentialGroup()
					.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table_6 = new JTable();
		scrollPane_6.setViewportView(table_6);
		panel_newemp.setLayout(gl_panel_newemp);
		
		panel_newacc = new JPanel();
		tabbedPane.addTab("New Accs", null, panel_newacc, null);
		
		scrollPane_7 = new JScrollPane();
		GroupLayout gl_panel_newacc = new GroupLayout(panel_newacc);
		gl_panel_newacc.setHorizontalGroup(
			gl_panel_newacc.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
		);
		gl_panel_newacc.setVerticalGroup(
			gl_panel_newacc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_newacc.createSequentialGroup()
					.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table_7 = new JTable();
		scrollPane_7.setViewportView(table_7);
		panel_newacc.setLayout(gl_panel_newacc);
		panel_newemp_table.setLayout(gl_panel_newemp_table);
		
		panel_sendEmail = new JPanel();
		panel.add(panel_sendEmail, "send_email");
		
		lbl_send_mail = new JLabel("Send Mail");
		lbl_send_mail.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_send_mail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lbl_toLabel = new JLabel("To:");
		
		txt_toField = new JTextField();
		txt_toField.setColumns(10);
		
		lbl_subjectLabel = new JLabel("Subject:");
		
		txt_subjectField = new JTextField();
		txt_subjectField.setColumns(10);
		
		lbl_content = new JLabel("Content:");
		
		btn_cancel_4 = new JButton("Cancel");
		
		btn_send_mail_4 = new JButton("Send mail");
		btn_send_mail_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_send_mail_4ActionPerformed(e);
			}
		});
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_sendEmail = new GroupLayout(panel_sendEmail);
		gl_panel_sendEmail.setHorizontalGroup(
			gl_panel_sendEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sendEmail.createSequentialGroup()
					.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_sendEmail.createSequentialGroup()
							.addGap(79)
							.addComponent(lbl_send_mail, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
						.addGroup(gl_panel_sendEmail.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_sendEmail.createSequentialGroup()
									.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_subjectLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_toLabel, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.TRAILING)
										.addComponent(txt_subjectField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
										.addComponent(txt_toField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
										.addGroup(gl_panel_sendEmail.createSequentialGroup()
											.addComponent(btn_cancel_4)
											.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
											.addComponent(btn_send_mail_4))
										.addComponent(scrollPane_8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
									.addGap(34))
								.addGroup(gl_panel_sendEmail.createSequentialGroup()
									.addComponent(lbl_content, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(55))
		);
		gl_panel_sendEmail.setVerticalGroup(
			gl_panel_sendEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sendEmail.createSequentialGroup()
					.addGap(53)
					.addComponent(lbl_send_mail)
					.addGap(28)
					.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_toLabel)
						.addComponent(txt_toField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_subjectLabel)
						.addComponent(txt_subjectField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(lbl_content)
					.addGap(8)
					.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_sendEmail.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_send_mail_4)
						.addComponent(btn_cancel_4))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		txt_message = new JTextArea();
		txt_message.setLineWrap(true);
		scrollPane_8.setViewportView(txt_message);
		panel_sendEmail.setLayout(gl_panel_sendEmail);
		
		lbl_status_check.setVisible(false);
//		getLeaveType();
		Timer timer = new Timer(1000, e -> {
            updateTime();
            autoCheckAndInsert();
            autoAddLeaveDays();
        });
        timer.start();
		lbl_warning_1.setVisible(false);
		lbl_warning_2.setVisible(false);
		lbl_warning_3.setVisible(false);
	}
	private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(new Date());
        lbl_time.setText(formattedTime);
    }
	protected void btn_loginActionPerformed(ActionEvent e) {
		login();
	}

	public void login() {
		var username= txt_username.getText();
		var password = new String(txt_password.getPassword());
		Account ac = new Account();
		ac.setUsername(username);
		ac.setPassword(password);
		AccountDAO dao = new AccountDAO();
		dao.login(ac);
		getAccess();
	}
	public void getAccess() {
		CardLayout card = (CardLayout) panel.getLayout();
		if(User.success) {
			txt_name.setText(User.fullname);
			txt_gender.setText(User.gender==true?"Male":"Female");
			txt_position.setText(User.position);
			txt_department.setText(User.department_name);
			txt_allowed.setText(""+User.allowed_dayoff);
			txt_dayoff.setText(""+User.dayoff);
			LeaveDayPermissionDAO dao = new LeaveDayPermissionDAO();
			var daysleft =dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
			txt_daysleft.setText(""+daysleft);
			switch(User.access_level) {
			case 0:
				card.show(panel, "login");
				break;
			case 1:
				btn_admin.setVisible(false);
				btn_admin.setEnabled(false);
				card.show(panel,"success");
				break;
			case 2:
				btn_admin.setVisible(false);
				btn_admin.setEnabled(false);
				card.show(panel, "leave_check");
				loadLetter();
				break;
			case 5:
				btn_admin.setVisible(true);
				btn_admin.setEnabled(true);
				card.show(panel, "admin");
				break;
				default:
				card.show(panel, "success");
					
			}
			
		}else {
			if(txt_username.getText().length()==0&&txt_password.getPassword().length==0) {
				JOptionPane.showMessageDialog(null, "You have to enter account information");
			}else if(txt_username.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "Missing username");
			}else if(txt_password.getPassword().length==0) {
				JOptionPane.showMessageDialog(null, "Missing Password");
			}else {
				JOptionPane.showMessageDialog(null, "Wrong username or password");
			}
			txt_password.setText(null);
			card.show(panel, "login");
		}
		if(User.success) {
			menuBar.setVisible(true);
			customMenu();
		}else {
			menuBar.setVisible(false);
		}
	}
	protected void txt_usernameKeyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			login();
		}
	}
	
	protected void txt_passwordKeyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			login();
		}
	}
	protected void btn_logoutActionPerformed(ActionEvent e) {
		if(add==true) {
			JOptionPane.showMessageDialog(null, "Can't close because you're not update the form");
			return;
		}
		User.emp_id=0;
		User.department_name=null;
		User.fullname=null;
		User.gender=true;
		User.position=null;
		User.success=false;
		User.access_level=0;
		CardLayout card = (CardLayout)panel.getLayout();
		txt_password.setText(null);
		card.show(panel, "login");
		customMenu();
	}
	protected void btn_to_infoActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "success");
	}
	protected void btn_adminActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "admin");
	}
	protected void btn_sendActionPerformed(ActionEvent e) {
		if(btn_send.getText().equals("Send")) {
			LeaveDayPermissionDAO perdao = new LeaveDayPermissionDAO();
			Dayoff day = new Dayoff();
			day.setEmp_id(User.emp_id);
			day.setReason(txt_reason.getText());
			day.setStarted_date(start_leave.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			day.setEnd_date(leave_util.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			day.setType_code(User.type_code);
			var daysleft =perdao.getInfoLeaveEmp(User.emp_id).getDaysleft();
			if(!checkWeekends()) {
				return;
			}
			Date datefrom = start_leave.getDate();
			Date dateto = leave_util.getDate();
			DayoffDAO dao1 = new DayoffDAO();
			var flag=dao1.dayCheckExist(datefrom, dateto, User.emp_id);
			if(flag) {
				return;
			}
			var flag2=caldayoff();
			
			if(daysleft<=0) {
				JOptionPane.showMessageDialog(null, "You have no allowed leaving days left, please contact the manager!");
			}else {
				DayoffDAO dao = new DayoffDAO();
				if(flag2) {
					return;
				}
				dao.create(day);
				
				getAccess();
				CardLayout card = (CardLayout) panel.getLayout();
				card.show(panel, "success");
				
			}
		}else if (btn_send.getText().equals("Update")) {
			updateLetter();
		} 
		
		
	}
	
	protected void mntmNewMenuItem_2ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		txt_name_empLeave.setText(User.fullname);
		getLeaveType();
		setToNormal();
		card.show(panel, "leave");
	}
	protected void btn_cancelActionPerformed(ActionEvent e) {
		if(btn_cancel.getText().equals("Cancel")) {
			JOptionPane.showMessageDialog(null, "Form deleted");
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel, "success");
		}else if(btn_cancel.getText().equals("Delete")) {
			deleteLetter();
		}else if(btn_cancel.getText().equals("Go back")) {
			CardLayout card = (CardLayout)panel.getLayout();
			getSentLetters();
			card.show(panel, "sent");
			btn_send.setText("Send");
			btn_send.setEnabled(true);
			btn_cancel.setText("Cancel");
			lbl_letter_id_modify.setVisible(false);
			lbl_id_no.setVisible(false);
			start_leave.setEnabled(true);
			leave_util.setEnabled(true);
			cbb_leave_type.setEnabled(true);
			txt_reason.setEnabled(true);
			lbl_checked.setText(null);
			lbl_checked.setVisible(false);
		}
		
	}
	
	protected void start_leavePropertyChange(PropertyChangeEvent evt) {
		 Calendar laterDate = Calendar.getInstance();
		 Date selDate = start_leave.getDate();
         laterDate.setTime(selDate);
         Date nextDay = laterDate.getTime();
         leave_util.setDate(laterDate.getTime());
         leave_util.setMinSelectableDate(nextDay);
         countdayoff();
         checkWeekends();
         
	}
	
	public void getLeaveType() {
		cbb_leave_type.removeAllItems();
		LeaveTypeDAO dao = new LeaveTypeDAO();
		dao.getType().forEach(x->cbb_leave_type.addItem(x));
	}
	
	protected void cbb_leave_typeActionPerformed(ActionEvent e) {
		if(cbb_leave_type.getItemCount()!=0) {
			LeaveType type = (LeaveType)cbb_leave_type.getSelectedItem();
			User.leaving_allowed_dayoff=type.getAllowed_day_off();
			txt_allowed_day.setText(""+User.leaving_allowed_dayoff);
			User.type_code=type.getDay_off_code();
			if(User.leaving_allowed_dayoff>1) {
				lbl_day_allowed.setText("days");
			}
			countdayoff();
		}
		
	}
	public void countdayoff() {
		if(User.success) {
			LocalDate dateFrom = start_leave.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate dateTo = leave_util.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			long daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo)+1;
			long numWeekends = ChronoUnit.WEEKS.between(dateFrom, dateTo);
			var valueFrom = dateFrom.getDayOfWeek().getValue();
			
			var valueTo = dateTo.getDayOfWeek().getValue();
			if(valueFrom>valueTo) {
				if(numWeekends==0||daysBetween>=7) {
					numWeekends+=1;
				}
			}

//			numWeekends -= dateFrom.getDayOfWeek().getValue() % 7;
//			numWeekends -= 7 - dateTo.getDayOfWeek().getValue() % 7;
			long dayoff = daysBetween - (numWeekends*2);
			String days = Long.toString(dayoff);
			if(dayoff>1) {
				lbl_countdays.setText("days");
			}
			txt_countday.setText(days);
		}
		
	}
	
	protected void leave_utilPropertyChange(PropertyChangeEvent evt) {
		countdayoff();
		checkWeekends();
	}
	public void loadLetter() {
		DefaultTableModel prevModel =(DefaultTableModel) table.getModel();
		prevModel.setRowCount(0);
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch(column) {
				default: return false;
				}
			}
		};
		
		model.addColumn("Id");
		model.addColumn("Employee Id");
		model.addColumn("Type code");
		model.addColumn("Start date");
		model.addColumn("End date");
		model.addColumn("Status");
		model.addColumn("Received at");
		model.addColumn("Details");
		DayoffDAO dao = new DayoffDAO();
		dao.loadData().forEach(x->model.addRow(new Object[] {x.getId(),x.getEmp_id(),x.getType_code(),x.getStarted_date(),x.getEnd_date(),x.getStatus_code()==3?"Pending":"Error",x.getReceived_at(),"See details"}));
		table.setModel(model);
		
	}
	protected void tableMouseClicked(MouseEvent e) {
		if(table.getRowCount()!=0) {
			leave_check(e,table);
			
		}
	}

	public void leave_check(MouseEvent e,JTable table) {
		if(e.getClickCount()==2) {
			int r = table.getSelectedRow();
			var id =(int) table.getValueAt(r, 0);
			var emp_id =(int) table.getValueAt(r, 1);
			DayoffDAO dao = new DayoffDAO();
			EmployeeDAO empdao = new EmployeeDAO();
			txt_letter_id.setText(""+id);
			txt_fullname_1.setText(empdao.getEmpInfo(emp_id).getFullname());
			txt_datefrom.setText(dao.getDataById(id).getStarted_date().toString());
			txt_to.setText(dao.getDataById(id).getEnd_date().toString());
			LeaveTypeDAO typedao = new LeaveTypeDAO();
			txt_typeof.setText(typedao.getTypeById(dao.getDataById(id).getType_code()));
			lbl_allowed_5.setText(typedao.getTypeById2(dao.getDataById(id).getType_code()).getAllowed_day_off()+"");
			txt_reasonwhy.setText(dao.getDataById(id).getReason());
			CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel,"check" );
			
		}
	}
	protected void btn_denyActionPerformed(ActionEvent e) {
		int option=JOptionPane.showConfirmDialog(null, "Are you sure to deny this leave letter?","deny",JOptionPane.OK_CANCEL_OPTION);
		if(option==JOptionPane.YES_OPTION) {
			DayoffDAO dao = new DayoffDAO();
			var id = Integer.parseInt(txt_letter_id.getText());
			dao.updateLetterStatus(Integer.parseInt(txt_letter_id.getText()), 2,User.account_id,dayChange(id));
			lbl_status_check.setText("Deny");
			lbl_status_check.setVisible(true);
			btn_deny.setEnabled(false);
			btn_approve.setEnabled(true);
			
		}	
	}
	protected void btn_approveActionPerformed(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure to approve this leave letter?",
				"approve",JOptionPane.OK_CANCEL_OPTION);
		if(option==JOptionPane.YES_OPTION) {
			DayoffDAO dao = new DayoffDAO();
			dao.updateLetterStatus(Integer.parseInt(txt_letter_id.getText()), 1,User.account_id,0);
			lbl_status_check.setText("Approved");
			lbl_status_check.setVisible(true);
			btn_approve.setEnabled(false);
			btn_deny.setEnabled(true);
		}
	}
	protected void btn_backActionPerformed(ActionEvent e) {
		if(User.access_level==2) {
			loadLetter();
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel,"leave_check" );
		}else if(User.access_level==5) {
			setUpPendingManagerPanel();
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel, "pending_manager_letter");
		}
		
	}
	public void getListNextLetter(JTable table) {
//		List<Integer> list2 = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
//		int rowsBefore = table.getRowCount();
//		int index = 0;
//		if(lbl_status_check.equals("Approved")||lbl_status_check.equals("Deny")) {
//			var i = 0;
//			while(i<rowsBefore) {
//				list2.add((int)table.getValueAt(i, 0));
//				i++;
//			}
//			index = list2.indexOf(txt_letter_id);
//			if(index==list2.get(list2.size()-1)) {
//				btn_next.setEnabled(false);
//				return;
//			}else {
//				btn_next.setEnabled(true);
//			}
//		}
//		loadLetter();
		int rows = table.getRowCount();
		var i =0;
		while(i<rows) {
			list.add((int)table.getValueAt(i, 0));
			i++;
		}
//		int currentIndex = 0;
//		if(lbl_status_check!=null) {
//			currentIndex = index;
//			txt_letter_id.setText(list.get(currentIndex).toString());
//		}else {
		int currentIndex = nextButton(list);
//		}
		emp_letter(list, currentIndex);
	}
	public void getListBackLetter(JTable table) {
//		List<Integer> list2 = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
//		int rowsBefore = table.getRowCount();
//		int index = rowsBefore;
//		if(lbl_status_check!=null) {
//			var i = 0;
//			while(i<rowsBefore) {
//				list2.add((int)table.getValueAt(i, 0));
//				i++;
//			}
//			index = list2.indexOf(txt_letter_id);
//			if(index==list2.get(0)) {
//				btn_backLetter.setEnabled(false);
//				return;
//			}else {
//				btn_backLetter.setEnabled(true);
//			}
//		}
//		loadLetter();
		int rows = table.getRowCount();
		var i =0;
		while(i<rows) {
			list.add((int) table.getValueAt(i, 0));
			i++;
		}
//		int currentIndex = 0;
//		if(lbl_status_check!=null) {
//			currentIndex = index;
//			txt_letter_id.setText(list.get(currentIndex).toString());
//		}else {
		int	currentIndex = backButton(list);
//		}
		emp_letter(list,currentIndex);
	}
	public int nextButton(List<Integer> list) {
		
			int currentIndex=list.indexOf(Integer.parseInt(txt_letter_id.getText()));
			if (currentIndex < list.size()-1 ) {
	            txt_letter_id.setText(list.get(currentIndex + 1).toString());
	            currentIndex++;
	        }
			return currentIndex;
		
		
	}
	public int backButton(List<Integer> list) {
		
			int currentIndex = list.indexOf(Integer.parseInt(txt_letter_id.getText()));
			if(currentIndex>0) {
				txt_letter_id.setText(list.get(currentIndex-1).toString());
				currentIndex--;
			}
			return currentIndex;
	}
	public void emp_letter(List<Integer> list, int currentIndex) {
		DayoffDAO dao = new DayoffDAO();
		EmployeeDAO empdao = new EmployeeDAO();
//		txt_letter_id.setText(""+list.get(b));
		var emp_id = dao.getDataById(list.get(currentIndex)).getEmp_id();
		txt_fullname_1.setText(empdao.getEmpInfo(emp_id).getFullname());
		txt_datefrom.setText(dao.getDataById(list.get(currentIndex)).getStarted_date().toString());
		txt_to.setText(dao.getDataById(list.get(currentIndex)).getEnd_date().toString());
		LeaveTypeDAO typedao = new LeaveTypeDAO();
		txt_typeof.setText(typedao.getTypeById(dao.getDataById(list.get(currentIndex)).getType_code()));
		txt_reasonwhy.setText(dao.getDataById(list.get(currentIndex)).getReason());
		String s = "";
		if(dao.getDataById(list.get(currentIndex)).getStatus_code()!=3) {
			s=dao.getDataById(list.get(currentIndex)).getStatus_code()==1?"Approved":"Deny";
			lbl_status_check.setText(s);
			lbl_status_check.setVisible(true);
			if(s.equals("Approved")) {
				btn_approve.setEnabled(false);
				btn_deny.setEnabled(true);
			}else {
				btn_deny.setEnabled(false);
				btn_approve.setEnabled(true);
			}
		}else {
			lbl_status_check.setText(null);
			lbl_status_check.setVisible(false);
			btn_approve.setEnabled(true);
			btn_deny.setEnabled(true);
		}
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel,"check" );
	}
	protected void btn_nextActionPerformed(ActionEvent e) {
		if(User.access_level==2) {
			getListNextLetter(table);
		}else if(User.access_level==5) {
			getListNextLetter(table_2);
		}
		
	}
	protected void btn_backLetterActionPerformed(ActionEvent e) {
		if(User.access_level==2) {
			getListBackLetter(table);
		}else if (User.access_level==5) {
			getListBackLetter(table_2);
		}
		
	}
	protected void btn_switchActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "ceo");
	}
	protected void btn_list_emp_by_dptActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		setUpCbb();
		setUpDptPanel();
		card.show(panel, "employee_dpt");
	}
	protected void btn_back_2ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "ceo");
	}
	public void setUpCbb() {
		cbb_department.removeAllItems();
		DepartmentDAO depdao= new DepartmentDAO();
		depdao.load().forEach(x->cbb_department.addItem(x));
	}
	public void setUpDptPanel() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch(column) {
				default:
					return false;
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("Fullname");
		model.addColumn("Department");
		model.addColumn("Role");
		model.addColumn("Left days");
		Department dpt =(Department) cbb_department.getSelectedItem();
		var dpt_id = dpt.getId();
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.getEmpByDpt(dpt_id).forEach(x->model.addRow(new Object[] {x.getEmp_id(),x.getFullname(),x.getDepartment_id(),x.getPosition(),x.getDayoff()}));
		
		table_1.setModel(model);
	}
	protected void cbb_departmentActionPerformed(ActionEvent e) {
		if(cbb_department.getItemCount()!=0) {
			setUpDptPanel();
		}
		
	}
	protected void txt_search_empActionPerformed(ActionEvent e) {
		cbb_department.setEnabled(false);
		String find = txt_search_emp.getText();
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch(column) {
				default:
					return false;
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("Fullname");
		model.addColumn("Department id");
		model.addColumn("Role");
		model.addColumn("Left days");
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.getAllEmpInDpt().forEach(x->model.addRow(new Object[] {x.getEmp_id(),x.getFullname(),x.getDepartment_id(),x.getPosition(),x.getDayoff()}));
		table_1.setModel(model);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table_1.getModel());
		table_1.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
		if(txt_search_emp.getText().equals("")) {
			table_1.setRowSorter(null);
			cbb_department.setEnabled(true);
			setUpDptPanel();
		}
	}
	protected void btn_make_letterActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "leave_2");
	}
	protected void btn_back_3ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "ceo");
	}
	protected void btn_leave_letterActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		setUpPendingManagerPanel();
		card.show(panel, "pending_manager_letter");
	}
	public void setUpPendingManagerPanel() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch(column) {
				default: return false;
				}
			}
		};
		
		model.addColumn("Id");
		model.addColumn("Employee Id");
		model.addColumn("Department");
		model.addColumn("Type code");
		model.addColumn("Start date");
		model.addColumn("End date");
		model.addColumn("Status");
		model.addColumn("Received at");
		model.addColumn("Details");
		DayoffDAO dayoffdao = new DayoffDAO();
		dayoffdao.loadData_Manager().forEach(a->model.addRow(new Object[] {a.getId(),a.getEmp_id(),a.getDepartment_name()
				,a.getType_code(),a.getStart_date(),a.getEnd_date(),a.getStatus(),a.getReceive_at(),"Details"}));
		table_2.setModel(model);
	}
	protected void btn_leave_todayActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		defaultLoadingRecords();
		card.show(panel, "leaving_history");
	}
	protected void btn_back_4ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "ceo");
	}
	protected void btn_back_5ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "ceo");
	}
	public void defaultLoadingRecords() {
		Calendar currentDate = Calendar.getInstance(); 
		changeDateCalendarToString(currentDate);
		loadTableRecords();
		
//		try {
//			Date rightNow = dateFormat.parse(now);
//			 txt_day_to_check.setText(rightNow.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	protected void btn_next_dayActionPerformed(ActionEvent e) {
		var current = txt_day_to_check.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		 try {
			date = dateFormat.parse(current);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		 Calendar currentDate=Calendar.getInstance();
		 currentDate.setTime(date);
		 currentDate.add(Calendar.DAY_OF_MONTH,1);		 
		 	changeDateCalendarToString(currentDate);
		 	loadTableRecords();
	}

	public void changeDateCalendarToString(Calendar currentDate) {
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int month = currentDate.get(Calendar.MONTH)+1;
		int year = currentDate.get(Calendar.YEAR);
		
		String now = null;
		if(month<10) {
			now = ""+year+"-0"+month+"-";
			if(day<10) {
				now+="0"+day;
			}else {
				now+=day;
			}
		}else {
			now = ""+year+"-"+month+"-";
			if(day<10) {
				now+="0"+day;
			}else {
				now+=day;
			}
		}
		txt_day_to_check.setText(now);
	}
	protected void btn_back_dayActionPerformed(ActionEvent e) {
		var current = txt_day_to_check.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		 try {
			date = dateFormat.parse(current);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		 Calendar currentDate=Calendar.getInstance();
		 currentDate.setTime(date);
		 currentDate.add(Calendar.DAY_OF_MONTH,-1);		 
		 	changeDateCalendarToString(currentDate);
		 	loadTableRecords();
	}
	public void loadTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Employee id");
		model.addColumn("Type code");
		model.addColumn("Department");
		model.addColumn("Start date");
		model.addColumn("End date");
		model.addColumn("Granted by id");
	}
	public void loadTableRecords() {
		DefaultTableModel prevModel = new DefaultTableModel();
		prevModel.setRowCount(0);
		table_3.setModel(prevModel);
		var current = txt_day_to_check.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		 try {
			date = dateFormat.parse(current);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	
		 var selItem =(String) cbb_checktype.getSelectedItem();
		 loadByCbb(selItem,date);
//		 if(selItem.equals("Checked letters")) {
//			 DefaultTableModel model = new DefaultTableModel();
//				model.addColumn("Id");
//				model.addColumn("Employee id");
//				model.addColumn("Type code");
//				model.addColumn("Department");
//				model.addColumn("Start date");
//				model.addColumn("End date");
//				model.addColumn("Granted by id");
//			 DayoffDAO dao = new DayoffDAO();
//			 	dao.getDayOffByDate(date).forEach(s->model.addRow(new Object[] {s.getId(),s.getEmp_id(),s.getType_code(),
//			 		s.getDepartment(),s.getStarted_date(),s.getEnd_date(),s.getGranted_by_id()}));
//			 	table_3.setModel(model);
//			
//		 }
	}
	public void loadByCbb(String a,Date date) {
		if(a.equals("Checked letters")) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Employee id");
			model.addColumn("Type code");
			model.addColumn("Department");
			model.addColumn("Start date");
			model.addColumn("End date");
			model.addColumn("Granted by id");
		 DayoffDAO dao = new DayoffDAO();
		 	dao.getDayOffByDate(date,1).forEach(s->model.addRow(new Object[] {s.getId(),s.getEmp_id(),s.getType_code(),
		 		s.getDepartment(),s.getStarted_date(),s.getEnd_date(),s.getGranted_by_id()}));
		 	table_3.setModel(model);
		}else if(a.equals("Rejected letters")) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Employee id");
			model.addColumn("Type code");
			model.addColumn("Department");
			model.addColumn("Start date");
			model.addColumn("End date");
			model.addColumn("Granted by id");
		 DayoffDAO dao = new DayoffDAO();
		 	dao.getDayOffByDate(date,2).forEach(s->model.addRow(new Object[] {s.getId(),s.getEmp_id(),s.getType_code(),
		 		s.getDepartment(),s.getStarted_date(),s.getEnd_date(),s.getGranted_by_id()}));
		 	table_3.setModel(model);
		}else if(a.equals("Pending letters")) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Employee id");
			model.addColumn("Type code");
			model.addColumn("Department");
			model.addColumn("Start date");
			model.addColumn("End date");
			model.addColumn("Granted by id");
		 DayoffDAO dao = new DayoffDAO();
		 	dao.getDayOffByDate().forEach(s->model.addRow(new Object[] {s.getId(),s.getEmp_id(),s.getType_code(),
		 		s.getDepartment(),s.getStarted_date(),s.getEnd_date(),"NULL"}));
		 	table_3.setModel(model);
		}else if (a.equals("Leaving employees in selected day")) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Employee id");
			model.addColumn("Employee's name");
			model.addColumn("Department");
			model.addColumn("Status");
			model.addColumn("Type code");
			model.addColumn("Reason");
		 DayoffDAO dayoffdao = new DayoffDAO();
		 	dayoffdao.getEmpLeft(date).forEach(f->model.addRow(new Object[] {f.getId(),f.getEmp_id(),f.getFullname(),f.getDepartment(),f.getStatus()==1?"Left":"At Work",f.getType_code(),f.getReason()	
		 	}));
		 	table_3.setModel(model);
		}
		
	}
	protected void cbb_checktypeActionPerformed(ActionEvent e) {
		loadTableRecords();
	}
	protected void txt_search_2ActionPerformed(ActionEvent e) {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table_3.getModel());
		String find = txt_search_2.getText();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		table_3.setRowSorter(sorter);
		sorter.setSortKeys(null);
	}
	protected void table_2MouseClicked(MouseEvent e) {
		if(table_2.getRowCount()!=0) {
			leave_check(e,table_2);
			
		}
	}
	protected void btn_sent_lettersActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout)panel.getLayout();
		getSentLetters();
		card.show(panel, "sent");
	}
	public void getSentLetters() {
		var emp_id = User.emp_id;
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch(column) {
				default:
					return false;
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("Type code");
		model.addColumn("Start date");
		model.addColumn("End date");
		model.addColumn("Status");
		model.addColumn("Granted by id account");
		DayoffDAO dayoffdao = new DayoffDAO();
		dayoffdao.getEmpDayOff(emp_id).forEach(f->model.addRow(new Object[] {f.getId(),f.getType_code(),f.getStarted_date(),f.getEnd_date(),f.getStatus()==3?"Pending":(f.getStatus()==2)?"Denied":"Approved",f.getGranted_by_id()}));
		table_4.setModel(model);
	}
	
	protected void table_4MouseClicked(MouseEvent e) {
		if(e.getClickCount()==2&&table_4.getRowCount()!=0) {
			int r =  table_4.getSelectedRow();
			var status = (String) table_4.getValueAt(r, 4);
			int stt = 0 ;
			if(status.equals("Pending")) {
				stt =3;
			}else if(status.equals("Denied")) {
				stt = 2;
			}else {
				stt = 1;
			}
			var id = (int) table_4.getValueAt(r, 0);
			var type = (int) table_4.getValueAt(r,1);
			
			updateForm(stt,id);
		}
	}
	public void updateForm(int status,int id) {
		CardLayout card = (CardLayout) panel.getLayout();
		txt_name_empLeave.setText(User.fullname);
		getLeaveType();
		LeaveTypeDAO leavedao = new LeaveTypeDAO();
		List<String> list = new ArrayList<>();
		leavedao.getType().stream().forEach(x->list.add(x.toString()));
		lbl_letter_id_modify.setVisible(true);
		lbl_id_no.setText(""+id);
		lbl_id_no.setVisible(true);
		if(status==3) {
			add=true;
			DayoffDAO dao3 = new DayoffDAO();
			dao3.changingStatus(id,4);
			preCheck();
			btn_send.setText("Update");
			btn_cancel.setText("Delete");
			DayoffDAO dao = new DayoffDAO();
			Dayoff day = dao.getDataById(id);
			Date datefrom = Date.from(day.getStarted_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			start_leave.setDate(datefrom);
			Date dateto = Date.from(day.getEnd_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			leave_util.setDate(dateto);
			start_leave.setSelectableDateRange(null, null);
			Date selectedDate = start_leave.getDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(selectedDate);
			Date nextDay = calendar.getTime();
			leave_util.setMinSelectableDate(nextDay);
			countdayoff();
			LeaveType type = leavedao.getTypeById2(day.getType_code());
			String newtype = type.toString();
			int index = 0;
			if(list.contains(newtype)) {
				 index = list.indexOf(newtype);
			}
			cbb_leave_type.setSelectedIndex(index);
			txt_reason.setText(day.getReason());
		}else {
			add= false;
			btn_send.setEnabled(false);
			btn_cancel.setText("Go back");
			DayoffDAO dao = new DayoffDAO();
			Dayoff day = dao.getDataById(id);
			Date datefrom = Date.from(day.getStarted_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			start_leave.setDate(datefrom);
			start_leave.setEnabled(false);
			Date dateto = Date.from(day.getEnd_date().atStartOfDay(ZoneId.systemDefault()).toInstant());
			leave_util.setDate(dateto);
			leave_util.setEnabled(false);
			countdayoff();
			LeaveType type = leavedao.getTypeById2(day.getType_code());
			String newtype = type.toString();
			int index = 0;
			if(list.contains(newtype)) {
				 index = list.indexOf(newtype);
			}
			cbb_leave_type.setSelectedIndex(index);
			cbb_leave_type.setEnabled(false);
			txt_reason.setText(day.getReason());
			txt_reason.setEnabled(false);
			if(status==2) {
				lbl_checked.setText("Denied");
				lbl_checked.setVisible(true);
			}else if(status==1) {
				lbl_checked.setText("Approved");
				lbl_checked.setVisible(true);
			}
		}
		card.show(panel, "leave");
	}
	public void updateLetter() {
		
		Date datefrom = start_leave.getDate();
		Date dateto = leave_util.getDate();
		if(!checkWeekends()) {
			return;
		}
		DayoffDAO dao1 = new DayoffDAO();
		var flag=dao1.dayCheckExist(datefrom, dateto, User.emp_id);
		if(flag) {
			return;
		}
		var flag2 = caldayoff();
		
		Dayoff day = new Dayoff();
		day.setId(Integer.parseInt(lbl_id_no.getText()));
		day.setReason(txt_reason.getText());
		day.setStarted_date(start_leave.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		day.setEnd_date(leave_util.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		day.setType_code(User.type_code);
		if(flag2) {
			return;
		}
		DayoffDAO dao = new DayoffDAO();
		dao.modifyLetters(day);
		
		add=false;
		btn_send.setText("Send");
		btn_cancel.setText("Cancel");
		lbl_letter_id_modify.setVisible(false);
		lbl_id_no.setVisible(false);
		DayoffDAO dao3 = new DayoffDAO();
		dao3.changingStatus(Integer.parseInt(lbl_id_no.getText()), 3);
		CardLayout card = (CardLayout)panel.getLayout();
		getSentLetters();
		card.show(panel, "sent");
	}
	public void deleteLetter() {
		add=false;
		Dayoff day = new Dayoff();
		day.setId(Integer.parseInt(lbl_id_no.getText()));
		DayoffDAO dao = new DayoffDAO();
		dao.deletePendingLetter(day);
		btn_send.setText("Send");
		btn_cancel.setText("Cancel");
		lbl_letter_id_modify.setVisible(false);
		lbl_id_no.setVisible(false);
		CardLayout card = (CardLayout)panel.getLayout();
		getSentLetters();
		card.show(panel, "sent");
	}
	protected void btn_back_6ActionPerformed(ActionEvent e) {
		getAccess();
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "success");
	}
	public void setToNormal() {
		add=false;
		lbl_letter_id_modify.setVisible(false);
		lbl_id_no.setText(null);
		lbl_id_no.setVisible(false);
		lbl_checked.setText(null);
		lbl_checked.setVisible(false);
		btn_send.setText("Send");
		btn_cancel.setText("Cancel");
		btn_send.setEnabled(true);
		btn_cancel.setEnabled(true);
		start_leave.setEnabled(true);
		start_leave.setDate(new Date());
		Date selectedDate = start_leave.getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		Date nextDay = calendar.getTime();
		leave_util.setMinSelectableDate(nextDay);
		leave_util.setDate(nextDay);
		countdayoff();
		leave_util.setEnabled(true);
		cbb_leave_type.setEnabled(true);
		cbb_leave_type.setSelectedIndex(0);
		txt_reason.setText("");
		txt_reason.setEnabled(true);
	}
	
	public boolean checkWeekends() {
		if(User.success) {
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			Date dateFrom = start_leave.getDate();
			Date dateTo = leave_util.getDate();
			calendar1.setTime(dateFrom);
			calendar2.setTime(dateTo);
			
			int dayFrom = calendar1.get(Calendar.DAY_OF_WEEK);
			int dayTo = calendar2.get(Calendar.DAY_OF_WEEK);
			if(dayFrom==Calendar.SATURDAY||dayFrom==Calendar.SUNDAY) {
				return false;
			}
			if(dayTo==Calendar.SATURDAY||dayTo==Calendar.SUNDAY) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean checkDatesAfter() {
		if(User.success) {
			Date datefrom = start_leave.getDate();
			Date dateto = leave_util.getDate();
			DayoffDAO dao1 = new DayoffDAO();
			dao1.dayCheckExist(datefrom, dateto, User.emp_id);
		}
		return true;
		
	}
	
	public boolean caldayoff() {
		if(User.success) {
			var leavetype =(LeaveType) cbb_leave_type.getSelectedItem();
			int code = leavetype.getDay_off_code();
			DayoffDAO daydao = new DayoffDAO();
			CalDayOff emp_cal=daydao.calculateDayoffTimes(User.emp_id, code);
			var times_per_year=emp_cal.getTimes_per_year();
			var times = emp_cal.getTimes();
			var days =Integer.parseInt(txt_countday.getText()) ;
			var allowed_day = Integer.parseInt(txt_allowed_day.getText());
			LeaveDayPermissionDAO dao = new LeaveDayPermissionDAO();
			if(times<times_per_year) { // th xet
				countdayoff();
				if(days>allowed_day) {
					var day_minus = days - allowed_day;
					var daysleft = dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
					if(day_minus<=daysleft) {
						dao.minusDay(day_minus, User.emp_id);
					}else {
						JOptionPane.showMessageDialog(null, "No leaving days left, contact the manager!");
						return true;
					}
				}
			}else {
				countdayoff();
				if (times_per_year!=0) {
					var day_minus = days;
					var daysleft = dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
					if(day_minus<=daysleft) {
						dao.minusDay(day_minus, User.emp_id);

					}else {
						JOptionPane.showMessageDialog(null, "No leaving days left, contact the manager!");
						return true;
					}
				}else {
					if(days>allowed_day) {
						var day_minus = days - allowed_day;
						var daysleft = dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
						if(day_minus<=daysleft) {
							dao.minusDay(day_minus, User.emp_id);
						}else {
							JOptionPane.showMessageDialog(null, "No leaving days left, contact the manager!");
							return true;
						}
					}
				}
				
				
			}
			
		}
		return false;
	}
	public int dayChange(int id) {
		DayoffDAO dao1 = new DayoffDAO();
		LocalDate dateFrom = dao1.getDataById(id).getStarted_date();
		LocalDate dateTo = dao1.getDataById(id).getEnd_date();
		var code = dao1.getDataById(id).getType_code();
		var emp_id_check = dao1.getDataById(id).getEmp_id();
		CalDayOff emp_cal=dao1.calculateDayoffTimes(emp_id_check, code);
		
		var times_per_year=emp_cal.getTimes_per_year();
		var times = emp_cal.getTimes();
		
		long daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo)+1;
		long numWeekends = ChronoUnit.WEEKS.between(dateFrom, dateTo);
		var valueFrom = dateFrom.getDayOfWeek().getValue();
		
		var valueTo = dateTo.getDayOfWeek().getValue();
		if(valueFrom>valueTo) {
			if(numWeekends==0||daysBetween>=7) {
				numWeekends+=1;
			}
		}
///////////////////////////////////////////
//		numWeekends -= dateFrom.getDayOfWeek().getValue() % 7;
//		numWeekends -= 7 - dateTo.getDayOfWeek().getValue() % 7;
		///////////////////////////////////////////////
		long dayoff = daysBetween - (numWeekends*2);
		int days = (int) dayoff;
		LeaveTypeDAO leave = new LeaveTypeDAO();
		var allowed_day = leave.getTypeById2(code).getAllowed_day_off();
		LeaveDayPermissionDAO dao = new LeaveDayPermissionDAO();
		if(times<times_per_year) {
			countdayoff();
			if(days>allowed_day) {
				 days = days - allowed_day;
//				var daysleft = dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
//				if(day_minus<=daysleft) {
//					dao.minusDay(day_minus, User.emp_id);
//				}
			}
		}else {
			countdayoff();
			var day_minus = days;
//			var daysleft = dao.getInfoLeaveEmp(User.emp_id).getDaysleft();
//			if(day_minus<=daysleft) {
//				dao.minusDay(day_minus, User.emp_id);
//
//			}
			return day_minus;
		}
		
		
		return days;
	}
	public void customMenu() {
		if(User.success) {
			menuBar.removeAll();//predefined
			switch(User.access_level) {
			
			case 1:
			menuBar.setVisible(true);
			JMenu menu1 = new JMenu("New");
			menuBar.add(menu1);
			mntmNewMenuItem_2 = new JMenuItem("New letter");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (add) {
			            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

			            if (choice == JOptionPane.YES_OPTION) {
			            	updateLetter();
			            } else if (choice == JOptionPane.NO_OPTION) {
			            }
			        } else {
			        	mntmNewMenuItem_2ActionPerformed(e);
			        }
					
				}
			});
			menu1.add(mntmNewMenuItem_2);
			JMenu menu1_1=new JMenu("Access");
			menuBar.add(menu1_1);
			JMenuItem basicInfo = new JMenuItem("Basic Information");
			basicInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (add) {
			            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

			            if (choice == JOptionPane.YES_OPTION) {
			            	updateLetter();
			            } else if (choice == JOptionPane.NO_OPTION) {
			            }
			        }else {
			        	CardLayout card = (CardLayout) panel.getLayout();
						getAccess();
						card.show(panel, "success");
			        }
					
				}
			});
			
			menu1_1.add(basicInfo);
			JMenuItem historyRecord = new JMenuItem("History Records");
			historyRecord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (add) {
			            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

			            if (choice == JOptionPane.YES_OPTION) {
			            	updateLetter();
			            } else if (choice == JOptionPane.NO_OPTION) {
			            }
			        }else {
			        	CardLayout card = (CardLayout)panel.getLayout();
						getSentLetters();
						card.show(panel, "sent");
			        }
					
				}
			});
			menu1_1.add(historyRecord);
			JMenu menu1_2 = new JMenu("Contact");
			menuBar.add(menu1_2);
			JMenuItem mgrcontact = new JMenuItem("Manager Contact");
			menu1_2.add(mgrcontact);
			mgrcontact.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (add) {
			            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

			            if (choice == JOptionPane.YES_OPTION) {
			            	updateLetter();
			            } else if (choice == JOptionPane.NO_OPTION) {
			            }
			        }else {
			        	loadMgrContact();
						CardLayout card = (CardLayout)panel.getLayout();
						card.show(panel, "mgr_info");
			        }
					
				}
			});
			JMenu menu1_3 = new JMenu("Exit");
			menuBar.add(menu1_3);
			mntmNewMenuItem_3 = new JMenuItem("Logout");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (add) {
			            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

			            if (choice == JOptionPane.YES_OPTION) {
			            	updateLetter();
			            } else if (choice == JOptionPane.NO_OPTION) {
			            }
			        }else {
			        	btn_logoutActionPerformed(e);
			        }
					
				}
			});

			menu1_3.add(mntmNewMenuItem_3);
			addReport(1);
			return;
			case 2:
				menuBar.setVisible(true);
				JMenu menu2 = new JMenu("New");
				menuBar.add(menu2);
				mntmNewMenuItem_2 = new JMenuItem("New letter");
				mntmNewMenuItem_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	mntmNewMenuItem_2ActionPerformed(e);
				        }
						
					}
				});
				menu2.add(mntmNewMenuItem_2);
				JMenu menu2_1=new JMenu("Access");
				menuBar.add(menu2_1);
				JMenuItem basicInfo2 = new JMenuItem("Basic Information");
				menu2_1.add(basicInfo2);
				basicInfo2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout) panel.getLayout();
							getAccess();
							card.show(panel, "success");
				        }
					}
				});
				JMenuItem historyRecord2 = new JMenuItem("History Records");
				menu2_1.add(historyRecord2);
				historyRecord2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout)panel.getLayout();
							getSentLetters();
							card.show(panel, "sent");
				        }	
					}
				});
				JMenuItem pendingletter = new JMenuItem("Pending letters");
				menu2_1.add(pendingletter);
				pendingletter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	loadLetter();
							CardLayout card = (CardLayout) panel.getLayout();
							card.show(panel,"leave_check" );
				        }	
					}
				});
				JMenuItem list = new JMenuItem("Department's employees");
				menu2_1.add(list);
				list.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	loadEmpContact();
							CardLayout card = (CardLayout)panel.getLayout();
							card.show(panel, "emp_info");
				        }						
					}
				});
				JMenu menu2_2 = new JMenu("Contact");
				menuBar.add(menu2_2);
				JMenuItem admincontact = new JMenuItem("Admin contact");
				menu2_2.add(admincontact);
				admincontact.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	loadAdminInfo();
							CardLayout card = (CardLayout)panel.getLayout();
							card.show(panel, "mgr_info");
				        }
					}
				});
				JMenu menu2_3 = new JMenu("Exit");
				menuBar.add(menu2_3);
				mntmNewMenuItem_3 = new JMenuItem("Logout");
				mntmNewMenuItem_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	btn_logoutActionPerformed(e);
				        }	
					}
				});
				menu2_3.add(mntmNewMenuItem_3);
				addReport(2);
				return;
			case 5:
				menuBar.setVisible(true);
				JMenu menu5 = new JMenu("New");
				menuBar.add(menu5);
				mntmNewMenuItem_2 = new JMenuItem("New letter");
				mntmNewMenuItem_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	mntmNewMenuItem_2ActionPerformed(e);
				        }
						
					}
				});
				menu5.add(mntmNewMenuItem_2);
				JMenuItem register = new JMenuItem("Add new employee");
				menu5.add(register);
				register.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	EmployeeDAO empdao = new EmployeeDAO();
							lbl_new_id_1.setText(empdao.getNewId()+"");
							loadPanelAddEmp();
							CardLayout card = (CardLayout)panel.getLayout();
							card.show(panel, "add_emp");
				        }
					}
				});
				JMenuItem sendmail = new JMenuItem("Send mail");
				
				sendmail.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout) panel.getLayout();
							card.show(panel, "send_email");
				        }					
					}
				});
				menu5.add(sendmail);
				JMenu menu5_1 = new JMenu("Access");
				menuBar.add(menu5_1);
				JMenuItem basicInfo5 = new JMenuItem("Basic Information");
				menu5_1.add(basicInfo5);
				basicInfo5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout) panel.getLayout();
							getAccess();
							card.show(panel, "success");
				        }	
					}
				});
				JMenuItem historyRecord5 = new JMenuItem("History Records");
				menu5_1.add(historyRecord5);
				historyRecord5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout)panel.getLayout();
							getSentLetters();
							card.show(panel, "sent");
				        }			
					}
				});
				JMenuItem pendingmgr = new JMenuItem("Pending manager letter");
				menu5_1.add(pendingmgr);
				pendingmgr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout)panel.getLayout();
							setUpPendingManagerPanel();
							card.show(panel, "pending_manager_letter");
				        }	
					}
				});
				JMenuItem list5 = new JMenuItem("All Department's employees");
				menu5_1.add(list5);
				list5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout)panel.getLayout();
							setUpCbb();
							setUpDptPanel();
							card.show(panel, "employee_dpt");
				        }	
					}
				});
				JMenuItem listleft = new JMenuItem("Employee leaving statistic");
				menu5_1.add(listleft);
				listleft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	CardLayout card = (CardLayout)panel.getLayout();
							defaultLoadingRecords();
							card.show(panel, "leaving_history");
				        }
					}
				});
				JMenu menu5_2 = new JMenu("Manager contact");
				menuBar.add(menu5_2);
				JMenuItem mgrcontactlist = new JMenuItem("Manager contact list");
				menu5_2.add(mgrcontactlist);
				mgrcontactlist.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	loadEmpContact();
							CardLayout card = (CardLayout)panel.getLayout();
							card.show(panel, "emp_info");
				        }	
					}
				});
				JMenu control = new JMenu("Control");
				menuBar.add(control);
				JMenuItem emp = new JMenuItem("New joining Employees list");
				control.add(emp);
				emp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	loadnewEmp();
							shownewAcc();
							CardLayout card =(CardLayout)panel.getLayout();
							card.show(panel, "combinedEmpAndAcc");
				        }
					}
				});
				JMenuItem leavetype = new JMenuItem("Leave Types");
				control.add(leavetype);
				JMenuItem dayoff = new JMenuItem("Dayoff");
				control.add(dayoff);
				JMenuItem account = new JMenuItem("Account");
				control.add(account);
				JMenuItem department = new JMenuItem("Department");
				control.add(department);
				JMenuItem leavepermis = new JMenuItem("Leave Day Permission");
				control.add(leavepermis);
				JMenuItem position = new JMenuItem("Position");
				control.add(position);
				JMenuItem role = new JMenuItem("Role");
				control.add(role);
				JMenuItem status = new JMenuItem("Status Dayoff");
				control.add(status);
				JMenu menu5_3 = new JMenu("Exit");
				menuBar.add(menu5_3);
				mntmNewMenuItem_3 = new JMenuItem("Logout");
				mntmNewMenuItem_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (add) {
				            int choice = JOptionPane.showConfirmDialog(null, "You have unsaved changes. Do you want to save them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);

				            if (choice == JOptionPane.YES_OPTION) {
				            	updateLetter();
				            } else if (choice == JOptionPane.NO_OPTION) {
				            }
				        }else {
				        	btn_logoutActionPerformed(e);
				        }
						
					}
				});
				menu5_3.add(mntmNewMenuItem_3);
				addReport(5);
				return;
			}
		}else {
			menuBar.removeAll();
			menuBar.setVisible(false);
		}
		
	}
	public static int preCheck() {
		add = true;
		var id = Integer.parseInt(lbl_id_no.getText());
		DayoffDAO dao = new DayoffDAO();
		Dayoff day =dao.getDataById(id);
		var code = day.getType_code();
		CalDayOff emp_cal=dao.calculateDayoffTimes(User.emp_id, code);
		var times_per_year=emp_cal.getTimes_per_year();
		var times = emp_cal.getTimes();
		LocalDate dateFrom = dao.getDataById(id).getStarted_date();
		LocalDate dateTo = dao.getDataById(id).getEnd_date();
		LeaveTypeDAO leave = new LeaveTypeDAO();
		var allowed_day = leave.getTypeById2(code).getAllowed_day_off();
		long daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo)+1;
		long numWeekends = ChronoUnit.WEEKS.between(dateFrom, dateTo);
		var valueFrom = dateFrom.getDayOfWeek().getValue();
		
		var valueTo = dateTo.getDayOfWeek().getValue();
		if(valueFrom>valueTo) {
			if(numWeekends==0||daysBetween>=7) {
				numWeekends+=1;
			}
		}
		long dayoff = daysBetween - (numWeekends*2);
		int days = (int) dayoff;
		if(times<times_per_year) { //dang nam trong truong hop con phep
			if(days>allowed_day) {
				days = days-allowed_day;
				dao.addDayBack(User.emp_id, days);
			}
			
		}else {
			if(times_per_year!=0) {
				dao.addDayBack(User.emp_id, days);
			}else {
				if(days>allowed_day) {
					days = days-allowed_day;
					dao.addDayBack(User.emp_id, days);
				}
			}
			
		}
		return days;
	}
	public void calDayoffUpdate() {
		
	}
	private void autoCheckAndInsert() {
		LeaveDayPermissionDAO dao = new LeaveDayPermissionDAO();
		dao.autoCheckAndInsert();
	}
	private void autoAddLeaveDays() {
		LeaveDayPermissionDAO dao = new LeaveDayPermissionDAO();
		dao.autoAddLeaveDays();
	}
	private void loadMgrContact() {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp=dao.getMgrInfo(User.department_code);
		txt_mgr_name.setText(emp.getFullname());
		txt_mgr_gender.setText(emp.isGender()?"Male":"Female");
		txt_mgr_position.setText(emp.getPosition());
		txt_mgr_phone.setText(emp.getPhoneNumber());
		txt_mgr_email.setText(emp.getEmail());
	}
	private void loadAdminInfo() {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp=dao.loadAdminInfo(User.emp_id);
		txt_mgr_name.setText(emp.getFullname());
		txt_mgr_gender.setText(emp.isGender()?"Male":"Female");
		txt_mgr_position.setText(emp.getPosition());
		txt_mgr_phone.setText(emp.getPhoneNumber());
		txt_mgr_email.setText(emp.getEmail());
	}
	private void loadEmpContact() {
		DefaultTableModel prevModel =(DefaultTableModel) table.getModel();
		prevModel.setRowCount(0);
		
		switch(User.access_level) {
		case 2:
			lbl_emp_info.setText("Employees Information");
			DefaultTableModel model = new DefaultTableModel() {
				public boolean isCellEditable(int row,int column) {
					switch(column) {
					default:
						return false;
					}
				}
			};
			model.addColumn("Id");
			model.addColumn("Fullname");
			model.addColumn("Gender");
			model.addColumn("Position");
			model.addColumn("Start to work");
			model.addColumn("Email");
			model.addColumn("Phone number");
			model.addColumn("Daysleft");
			EmployeeDAO empdao = new EmployeeDAO();
			empdao.getEmpInfo1(User.department_code).forEach(s->model.addRow(new Object[] {
					s.getEmp_id(),s.getFullname(),s.isGender()?"Male":"Female",s.getPosition(),s.getStart_to_work(),s.getEmail(),s.getPhoneNumber(),s.getDaysleft()
			}));
			table_5.setModel(model);
			break;
		case 5:
			lbl_emp_info.setText("Managers Information");
			DefaultTableModel model1 = new DefaultTableModel() {
				public boolean isCellEditable(int row,int column) {
					switch(column) {
					default:
						return false;
					}
				}
			};
			model1.addColumn("Id");
			model1.addColumn("Fullname");
			model1.addColumn("Gender");
			model1.addColumn("Position");
			model1.addColumn("Department");
			model1.addColumn("Email");
			model1.addColumn("Phone number");
			model1.addColumn("Days left");
			EmployeeDAO empdao2 = new EmployeeDAO();
			empdao2.getEmpInfo1().forEach(f->model1.addRow(new Object[] {f.getEmp_id(),
			f.getFullname(),f.isGender()?"Male":"Female",f.getPosition(),f.getDepartment(),f.getEmail(),
			f.getPhoneNumber(),f.getDaysleft()}));
			table_5.setModel(model1);
			break;
		}
		
		
	}
	private void loadPanelAddEmp() {
		if(User.success && User.access_level==5) {
			cbb_department_3.removeAllItems();
			cbb_position_3.removeAllItems();
			DepartmentDAO depdao = new DepartmentDAO();
			depdao.load().forEach(d->cbb_department_3.addItem(d));
			PositionDAO podao = new PositionDAO();
			podao.load().forEach(t->cbb_position_3.addItem(t));
		}
		
	}
	protected void txt_namefield_empPropertyChange(PropertyChangeEvent evt) {
		
	}
	protected void txt_namefield_empKeyPressed(KeyEvent e) {
		var name = txt_namefield_emp.getText().trim();
		int length = name.length();
		if(length<=3) {
			lbl_warning_1.setText("XXX");
			lbl_warning_1.setVisible(true);
			lbl_warning_1.setForeground(Color.RED);
		}
	}
	protected void txt_namefield_empKeyReleased(KeyEvent e) {
		var name = txt_namefield_emp.getText().trim();
		int length = name.length();
		if(length>3) {
			lbl_warning_1.setText("null");
			lbl_warning_1.setVisible(false);
			lbl_warning_1.setForeground(Color.black);
		}else if(length==0) {
			lbl_warning_1.setText("null");
			lbl_warning_1.setVisible(false);
			lbl_warning_1.setForeground(Color.black);
		}else if(name.matches(".*[!@#$%^&*()].*")||name.matches(".*\\d.*")) {
			lbl_warning_1.setText("XXX");
			lbl_warning_1.setVisible(true);
			lbl_warning_1.setForeground(Color.RED);
		}else if(name.matches("[a-zA-Z ]+")) {
			lbl_warning_1.setText("null");
			lbl_warning_1.setVisible(false);
			lbl_warning_1.setForeground(Color.black);
		}
	}
	protected void txt_email_3KeyReleased(KeyEvent e) {
		var email = txt_email_3.getText().trim();
		int length = email.length();
		if(email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			lbl_warning_2.setText("null");
			lbl_warning_2.setVisible(false);
			lbl_warning_2.setForeground(Color.black);
		}else if(length==0) {
			lbl_warning_2.setText("null");
			lbl_warning_2.setVisible(false);
			lbl_warning_2.setForeground(Color.black);
		}
		else {
			lbl_warning_2.setText("XXX");
			lbl_warning_2.setVisible(true);
			lbl_warning_2.setForeground(Color.RED);
		}
	}
	protected void txt_phone_3KeyReleased(KeyEvent e) {
		var phone = txt_phone_3.getText();
		int length = phone.length();
		if(phone.matches("[0-9]+")) {
			lbl_warning_3.setText("null");
			lbl_warning_3.setVisible(false);
			lbl_warning_3.setForeground(Color.black);
		}else if(length==0) {
			lbl_warning_3.setText("null");
			lbl_warning_3.setVisible(false);
			lbl_warning_3.setForeground(Color.black);
		}
		else {
			lbl_warning_3.setText("XXX");
			lbl_warning_3.setVisible(true);
			lbl_warning_3.setForeground(Color.RED);
		}
		
	}
	protected void btn_submit_3ActionPerformed(ActionEvent e) {
		if(User.success && lbl_warning_1.isVisible()==false && lbl_warning_2.isVisible()==false && lbl_warning_3.isVisible()==false) {
			Department department =(Department) cbb_department_3.getSelectedItem();
			var dep_id = department.getId();
			var dep_manager_id_account = department.getManager_dpt_id();
			Posistion position = (Posistion) cbb_position_3.getSelectedItem();
			var position_name = position.getName_of_position();
			PositionDAO po = new PositionDAO();
			List<String> po_list =new ArrayList<>();
					po.load().forEach(a->po_list.add(a.toString()));
			if(dep_manager_id_account!=0) {
				if(position_name.equals("Manager")) {
					JOptionPane.showMessageDialog(null, "Already existed manager in department, auto set to employee position");
					var emp_index = 0;
					if(po_list.contains("Employee")) {
						emp_index = po_list.indexOf("Employee");
					}
					cbb_position_3.setSelectedIndex(emp_index);
					return;
				}else if(position_name.equals("Administration")||position_name.equals("Administration Highest")) {
					dep_manager_id_account=100;
				}
			}else {
				dep_manager_id_account=100;
			}
			var id = Integer.parseInt(lbl_new_id_1.getText());
			var fullname = txt_namefield_emp.getText().trim();
			var email = txt_email_3.getText().trim();
			var phone = txt_phone_3.getText().trim();
			if(fullname.length()==0||email.length()==0||phone.length()==0) {
				JOptionPane.showMessageDialog(null, "fullname or email or phone is empty!!");
				return;
			}
			EmployeeDAO empdao = new EmployeeDAO();
			if(empdao.checkExistPhoneAndEmail(phone, email)) {
				JOptionPane.showMessageDialog(null, "Email or phone is existed!!");
				return;
			}
			boolean gender = rd_male.isSelected()?true:false;
			Calendar calendar = Calendar.getInstance();
			
			
			var picture = "/image/abc.png";
			Employee emp = new Employee(id,fullname,gender,position_name,dep_id,dep_manager_id_account,
					LocalDate.now(),email,phone,picture);
			empdao.addEmp(emp);
			setCleanForm();
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel, "admin");
		}
		
	}
	public void setCleanForm() {
		if(User.success) {
			txt_namefield_emp.setText("");
			rd_male.setSelected(true);
			cbb_department_3.setSelectedIndex(0);
			cbb_position_3.setSelectedIndex(0);
			txt_email_3.setText("");
			txt_phone_3.setText("");
			
		}
		
	}
	private void sendEmail() {
        String to = txt_toField.getText();
        String subject = txt_subjectField.getText();
        String message = txt_message.getText();
        if(!to.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
        	JOptionPane.showMessageDialog(null, "Recepient email is invalid");
        	return;
        }
        if(to.trim().length()==0) {
        	JOptionPane.showMessageDialog(null, "Recepient email is blank");
        	return;
        }
        if(subject.trim().length()==0) {
        	JOptionPane.showMessageDialog(null, "Subject is blank");
        	return;
        }
        if(message.trim().length()==0) {
        	JOptionPane.showMessageDialog(null, "Content is blank! Type something!");
        	return;
        }
      
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "new.vytruong.1812@gmail.com";
        String password = "osthyqaqrwfmpyvq";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);

            JOptionPane.showMessageDialog(this, "Email sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(this, "Failed to send email. Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	protected void btn_send_mail_4ActionPerformed(ActionEvent e) {
		sendEmail();
		txt_toField.setText("");
		txt_subjectField.setText("");
		txt_message.setText("");
		CardLayout card = (CardLayout)panel.getLayout();
		card.show(panel, "send_email");
	}
	private void loadnewEmp() {
		EmployeeDAO empdao1 = new EmployeeDAO();
		DefaultTableModel prevModel = (DefaultTableModel)table_6.getModel();
		prevModel.setRowCount(0);
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column) {
				switch(column) {
				default:
					return false;
				}
			}
		};
		model.addColumn("Emp id");
		model.addColumn("Fullname");
		model.addColumn("Department");
		model.addColumn("Department id");
		model.addColumn("Position");
		model.addColumn("Email");
		model.addColumn("Phone number");
		empdao1.getnewjoins().forEach(e->model.addRow(new Object[] {
				e.getEmp_id(),e.getFullname(),e.getDepartment(),e.getDepartment_code(),e.getPosition(),e.getEmail(),e.getPhoneNumber()
		}));
		table_6.setModel(model);
	}
	protected void btn_makeaccActionPerformed(ActionEvent e) {
		if(table_6.getRowCount()!=0) {
			AccountDAO acdao = new AccountDAO();
			acdao.makeNewAcc();
		}
		loadnewEmp();
		shownewAcc();
		
	}
	private void shownewAcc() {
		DefaultTableModel prevModel = (DefaultTableModel)table_7.getModel();
		prevModel.setRowCount(0);
		DefaultTableModel model1 = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column) {
				switch(column) {
				default:
					return false;
				}
			}
		};
		model1.addColumn("Account id");
		model1.addColumn("Username");
		model1.addColumn("Password");
		model1.addColumn("Role");
		model1.addColumn("Emp id");
		model1.addColumn("Email");
		AccountDAO acdao1 = new AccountDAO();
		acdao1.showNewAcc().forEach(r->model1.addRow(new Object[] {r.getAccount_id(),r.getUsername(),r.getPassword(),
				r.getRole(),r.getEmp_id(),r.getEmail()}));
		table_7.setModel(model1);
	}
	private void sendEmail(String Recepient, String username, String password) {
		AccountDAO acdao2 = new AccountDAO();
        String to = Recepient;
        String subject = "Send account";
        String message = "Hi I'm Tuong Vy, I'm administrator of ABC Company.\n Here's your account, please log in and change password for security!\n"
        		+"Username: "+username+"\n"
        		+"Password: "+password+"\n"
        		+"Have a good day! :)";
        
      
        String host = "smtp.gmail.com";
        int port = 587;
        String adminusername = "new.vytruong.1812@gmail.com";
        String adminpassword = "osthyqaqrwfmpyvq";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(adminusername, adminpassword);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(adminusername));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);
            sent=true;
            JOptionPane.showMessageDialog(this, "Email sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            shownewAcc();
       
        } catch (MessagingException ex) {
        	sent = false;
            JOptionPane.showMessageDialog(this, "Failed to send email. Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	protected void btn_sendaccActionPerformed(ActionEvent e) {
		if(table_7.getRowCount()!=0) {
			AccountDAO acdao2 = new AccountDAO();
			acdao2.showNewAcc().forEach(d->sendEmail(d.getEmail(),d.getUsername(),d.getPassword()));
			if(sent) {
				acdao2.activate();
				sent=false;
			}
			shownewAcc();
			return;
		}
	}
	protected void btn_cancel_3ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Form deleted");
		txt_namefield_emp.setText(null);
		rd_male.setSelected(true);
		cbb_department_3.setSelectedIndex(0);
		cbb_position_3.setSelectedIndex(0);
		txt_email_3.setText(null);
		txt_phone_3.setText(null);
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "admin");
	}

	public void addReport(int access_level) {
		// add menu

		JMenu mnuReport = new JMenu("Reports");
		JMenuItem jMnu_Dept = new JMenuItem("Department List");
		jMnu_Dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jMnuActionPerformed(e);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JMenuItem jMnuEmployeebyDept = new JMenuItem("Employee in Department");
		jMnuEmployeebyDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jMnuActionPerformed(e);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		switch (access_level) {
		case 1:

			return;
		case 2:
			mnuReport.add(jMnu_Dept);
			menuBar.add(mnuReport);
			return;
		case 5:
			mnuReport.add(jMnu_Dept);
			mnuReport.add(jMnuEmployeebyDept);
			menuBar.add(mnuReport);
			return;
		}

	}

	public void jMnuActionPerformed(ActionEvent e) throws JRException {

		switch (e.getActionCommand()) {

		case "Department List":
			showDeptReport();
			return;
		case "Employee in Department":
		//	showEmployeeInDeptReport();
			testJasper();
			return;

		}
	}

	// add Connection
	public void showDeptReport() {
      	           
		try {
			// Truong hop load bang DAO
//	        	JRBeanCollectionDataSource DataSource = new JRBeanCollectionDataSource((new DepartmentDAO().load()));
			String path = "src/main/resources/reports/DepartmentList.jrxml";

			HashMap param = new HashMap();

			JasperReport report = JasperCompileManager.compileReport(path);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, param, ConnectDB.getDBProperty());
//	            JasperPrint jasperPrint = JasperFillManager.fillReport(path, param, conn);
			JasperViewer reportViewer = new JasperViewer(jasperPrint, false);
			reportViewer.setZoomRatio(new Float(0.5)); //the frame fit ratio

			reportViewer.setVisible(true);
		} catch (JRException ex) {
			System.out.println("Error:\n" + ex.getLocalizedMessage());
		}

	}
	public void loadCompileReport() {
		String path = "src/main/resources/reports/employeeDep.jrxml";
		String compiledReport = "src/main/resources/reports/compiled_report.jasper";
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			JasperCompileManager.writeReportToXmlFile(jasperReport, compiledReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void showEmployeeInDeptReport() throws JRException{
//		loadCompileReport();
//		String path = "src/main/resources/reports/compiled_report.jasper";
//		 String outputPdf = "src/main/resources/reports/report.pdf";
//		// Connection con = ConnectDB.getDBProperty();
//		try {
//			var cs = con.prepareCall("{call getAllEmpInDpt}");
//			var rs =cs.executeQuery();
			// Truong hop load bang DAO
//			EmployeeDAO dao = new EmployeeDAO();
	//		List<EmployeeManagerSite> list = new ArrayList<>();
			//List<Emplo> dataList = new HashMap<>();
//			 int rowNumber = 1;
//			 while(rs.next()) {
//				 Map<String, Object> rowData = new HashMap<>();
//				 rowData.put("Emp id", rs.getInt("emp_id"));
//	             rowData.put("Fullname", rs.getString("fullname"));
//	             rowData.put("Department id", rs.getInt("department_id"));
//	             rowData.put("Position", rs.getString("position"));
//	             rowData.put("Dayoff", rs.getInt("dayoff"));
//	             dataSource.add(rowData);
//	             rowNumber++;
//			 }
			 //(String) JRLoader.loadObjectFromFile(path)
			
//			Map<String, Object> data1 = new HashMap<>();
//            data1.put("name", "John Doe");
//            data1.put("age", 30);
//            dataList.put("Data ", data1);
//
//            Map<String, Object> data2 = new HashMap<>();
//            data2.put("name", "Jane Smith");
//            data2.put("age", 28);
//            dataList.put("Data ", data2);
          //  JRBeanCollectionDataSource DataSource = new JRBeanCollectionDataSource((Collection<?>) dataList);
      //      JasperReport jasperReport=JasperCompileManager.compileReport(path);
//			JasperReport jasperReport = new JasperReport();
//            jasperReport.setPageFormat(PageFormat.A4);
//			JasperPrint jasperPrint = JasperFillManager.fillReport(report,new HashMap<>(),DataSource);
//			JasperExportManager.exportReportToPdfFile(jasperPrint, outputPdf);
////	            JasperPrint jasperPrint = JasperFillManager.fillReport(path, param, conn);
//			JasperViewer reportViewer = new JasperViewer(jasperPrint, false);
//			reportViewer.setZoomRatio(new Float(0.5)); //the frame fit ratio
//
//			reportViewer.setVisible(true);
////			JasperViewer.viewReport(jasperPrint, false);
//		//	con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
			public void testJasper() throws JRException {
//				loadCompileReport();
				String path = "src/main/resources/reports/Flower.jrxml";
				JasperReport jasperReport = JasperCompileManager.compileReport(path);
				JRDataSource dataSource = new JRBeanCollectionDataSource((new EmployeeDAO().getAllEmpInDpt()));
				 JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource);
				// JasperExportManager.exportReportToPdfFile(jasperPrint, "output.pdf");
				 JasperViewer reportViewer = new JasperViewer(jasperPrint, false);
					reportViewer.setZoomRatio(new Float(0.5)); //the frame fit ratio

					reportViewer.setVisible(true);
			}
	public void showEmployeeByDeptReport() {
        
		try {
			// Truong hop load bang DAO
			
			
	        	
			String path = "src/main/resources/reports/employeeDep.jrxml";
//	        	System.out.println(path);

			HashMap param = new HashMap();
			JasperReport report = JasperCompileManager.compileReport(path);
			
			if(cbb_department.getItemCount()!=0) {
				Department dpt =(Department) cbb_department.getSelectedItem();
				var dpt_id = dpt.getId();
				param.put("DepID", dpt_id);
				JRBeanCollectionDataSource DataSource = new JRBeanCollectionDataSource((new EmployeeDAO().getEmpByDpt(dpt_id)));
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, param, DataSource);
//	            JasperPrint jasperPrint = JasperFillManager.fillReport(path, param, conn);
			JasperViewer reportViewer = new JasperViewer(jasperPrint, false);
			reportViewer.setZoomRatio(new Float(0.5)); //the frame fit ratio

			reportViewer.setVisible(true);
//			JasperViewer.viewReport(jasperPrint, false);
			}
			
			

		} catch (JRException ex) {
			System.out.println("Error:\n" + ex.getLocalizedMessage());
		}

	}
}
