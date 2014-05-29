package com.redpois0n.jammer;

import javax.swing.UIManager;

public class Main {

	public static boolean running;
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		new Frame().setVisible(true);
	}

}
