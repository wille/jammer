package com.redpois0n.jammer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private static Frame instance;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JSpinner spPort;
	private JTextField txtProxyHost;

	public Frame() {
		setResizable(false);
		setTitle("jammer - Idle...");
		instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Host"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Host"));
		
		JLabel lblHost = new JLabel("Host");
		
		txtProxyHost = new JTextField();
		txtProxyHost.setText("127.0.0.1");
		txtProxyHost.setColumns(10);
		
		JLabel lblPort_1 = new JLabel("Port");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(9050, 1, 65535, 1));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHost)
						.addComponent(lblPort_1))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtProxyHost, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHost)
						.addComponent(txtProxyHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPort_1)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addContainerGap())
		);
		
		JLabel lblAddress = new JLabel("Address");
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		
		spPort = new JSpinner();
		spPort.setModel(new SpinnerNumberModel(80, 1, 65535, 1));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAddress)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAddress, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPort, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spPort, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPort)
						.addComponent(spPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void start() {
		Main.running = true;
		
		for (int i = 0; i < 256; i++) {
			new Thread(new Hammer()).start();
		}
	}
	
	public static void setWindowTitle(String title) {
		instance.setTitle("jammer - " + title);
	}
	
	public static void getDelayMin() {
		
	}
	
	public static void getDelayMax() {
		
	}
}
