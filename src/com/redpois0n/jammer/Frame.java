package com.redpois0n.jammer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private static Frame instance;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JSpinner spPort;
	private JTextField txtProxyHost;
	private JSpinner spProxyPort;
	private JButton btnStop;
	private JButton btnStart;
	private JTextField txtSwitcherHost;
	private JSpinner spSwitcherDelay;
	private JSpinner spSwitcherPort;
	private JTextField txtSwitcherPass;
	private JCheckBox chckbxEnableProxy;
	private JCheckBox chckbxEnableTorSwitcher;

	public Frame() {
		setResizable(false);
		setTitle("jammer - Idle...");
		instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Host"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Proxy"));
		
		JLabel lblHost = new JLabel("Host");
		
		txtProxyHost = new JTextField();
		txtProxyHost.setText("127.0.0.1");
		txtProxyHost.setColumns(10);
		
		JLabel lblPort_1 = new JLabel("Port");
		
		spProxyPort = new JSpinner();
		spProxyPort.setModel(new SpinnerNumberModel(9050, 1, 65535, 1));
		
		JSeparator separator = new JSeparator();
		
		JLabel label = new JLabel("Host");
		
		JLabel label_1 = new JLabel("Port");
		
		spSwitcherPort = new JSpinner();
		spSwitcherPort.setModel(new SpinnerNumberModel(9051, 1, 65535, 1));
		
		txtSwitcherHost = new JTextField();
		txtSwitcherHost.setText("127.0.0.1");
		txtSwitcherHost.setColumns(10);
		
		spSwitcherDelay = new JSpinner();
		spSwitcherDelay.setModel(new SpinnerNumberModel(new Integer(15), null, null, new Integer(1)));
		
		txtSwitcherPass = new JTextField();
		txtSwitcherPass.setColumns(10);
		
		chckbxEnableProxy = new JCheckBox("Enable Proxy");
		chckbxEnableProxy.setSelected(true);
		
		chckbxEnableTorSwitcher = new JCheckBox("Enable Tor Switcher");
		chckbxEnableTorSwitcher.setSelected(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxEnableTorSwitcher)
							.addContainerGap())
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(lblHost)
									.addComponent(lblPort_1))
								.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(spProxyPort, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtProxyHost, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGap(8))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(chckbxEnableProxy)
								.addContainerGap(168, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSwitcherHost, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(spSwitcherDelay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spSwitcherPort, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtSwitcherPass, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(chckbxEnableProxy)
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHost)
						.addComponent(txtProxyHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPort_1)
						.addComponent(spProxyPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxEnableTorSwitcher)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(txtSwitcherHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(spSwitcherPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spSwitcherDelay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSwitcherPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		
		JButton btnExit = new JButton("Exit");
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		btnStop.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnStart)
						.addComponent(btnStop))
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
	
	public void stop() {
		Main.running = false;
		
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
		
		setWindowTitle("Idle...");
	}
	
	public void start() {
		Main.running = true;
		
		btnStart.setEnabled(false);
		btnStop.setEnabled(true);
		
		if (chckbxEnableTorSwitcher.isSelected()) {
			new Thread(new Switcher(txtSwitcherHost.getText().trim(), (Integer) spSwitcherPort.getValue(), (Integer) spSwitcherDelay.getValue(), txtSwitcherPass.getText().trim())).start();
		}
		for (int i = 0; i < 256; i++) {
			new Thread(new Hammer(getAddress(), (Integer) spPort.getValue(), chckbxEnableProxy.isSelected(), getProxyAddress(), (Integer) spProxyPort.getValue())).start();
		}
		
		setWindowTitle("Busy...");
	}
	
	public String getAddress() {
		return txtAddress.getText().trim();
	}
	
	public String getProxyAddress() {
		return txtProxyHost.getText().trim();
	}
	
	public static void setWindowTitle(String title) {
		instance.setTitle("jammer - " + title);
	}
	
	public static void getDelayMin() {
		
	}
	
	public static void getDelayMax() {
		
	}
}
