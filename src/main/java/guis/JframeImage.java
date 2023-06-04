package guis;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.Timer;
import java.awt.*;
public class JframeImage extends JFrame {

	private JPanel contentPane;
	private Point mouse = null;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeImage frame = new JframeImage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JframeImage() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				thisMousePressed(e);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				thisMouseDragged(e);
			}
		});
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		Image i = new ImageIcon(
				new ImageIcon(
						JframeImage.class.getResource("/image/trasua.png")
						).getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH)).getImage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		float alpha = 0.8f; // draw half transparent
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
		contentPane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2D = (Graphics2D) g;
				g2D.setComposite(ac);
				g.drawImage(i, 0, 0, null);
			}
		};
		
//		Timer timer = new Timer(3000, event -> {
//            dispose();
//        });
//		timer.setRepeats(false);
//		   timer.start();
		   //cach 1 dung toolkit getscreensize
//		   Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//		   int x = (dimension.width-getWidth())/2;
//		   int y = (dimension.height-getHeight())/2;
//		   setLocation(x,y);
		   //cach 2 dung setLocationRelativeto(null)
		   setLocationRelativeTo(null);
		contentPane.setBackground(new Color(0,0,0,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnNewButton = new JButton("X");
		btnNewButton.setEnabled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(360, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(btnNewButton)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void thisMouseDragged(MouseEvent e) {
		//
		Point currentMouse = e.getLocationOnScreen();
		//lay toa do
		this.setLocation(currentMouse.x-mouse.x,currentMouse.y-mouse.y);
	}
	protected void thisMousePressed(MouseEvent e) {
		mouse = e.getPoint();
		//lay toa do khi nhan chuot luu vao bien point
//		if(e.getX()<0||e.getX()>getWidth()||e.getY()<0||e.getY()>getHeight()) {
//			dispose();
//		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
			dispose();
	}
}
