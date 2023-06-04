package app;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Clock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel lbl_anni;

    public Clock() {
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        lbl_anni = new JLabel("Default");
        lbl_anni.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lbl_anni.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(115)
        					.addComponent(lbl_anni, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        				.addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        			.addGap(108)
        			.addComponent(lbl_anni, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(159, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(696, 562);
        setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateTimeAndDate();
                checkAnnouncement();
            }
        });
        timer.start();
    }

    private void updateTimeAndDate() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy");
        Date now = new Date();
        String timeStr = timeFormat.format(now);
        String dateStr = dateFormat.format(now);
        timeLabel.setText(timeStr);
        dateLabel.setText(dateStr);
    }

    private void checkAnnouncement() {
        Date now = new Date();
        SimpleDateFormat announcementFormat = new SimpleDateFormat("MMM dd");
        List<String> listSpecial = new ArrayList<>();
        listSpecial.add("Sep 01");
        listSpecial.add("Sep 02");
        listSpecial.add("Sep 03");
      //  String anniversaryDateStr = "Oct 01";
        Date anniversaryDate = null;
        try {
        	listSpecial.stream().forEach(x->{
				try {
					var anni=announcementFormat.parse(x.toString());
					 if (now.getMonth() == anni.getMonth() && now.getDate() == anni.getDate()) {
		                 lbl_anni.setText("Anni day!");
		             }
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			});
            //anniversaryDate = announcementFormat.parse(anniversaryDateStr);
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
    private boolean isNearHoliday(Date currentDate) {
        SimpleDateFormat holidayFormat = new SimpleDateFormat("MMM dd");
        String holidayDateStr = "Dec 25";
        Date holidayDate = null;
        try {
            holidayDate = holidayFormat.parse(holidayDateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long diff = holidayDate.getTime() - currentDate.getTime();
        long days = diff / (24 * 60 * 60 * 1000);
        if (days <= 7 && days >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        new Clock();
    }
}
