package com.redpois0n.jammer;

import de.mud.telnet.TelnetWrapper;

public class Switcher implements Runnable {
	
	private String address;
	private int port;
	private int interval;
	private String pass;

	public Switcher(String address, int port, int interval, String pass) {
		this.address = address;
		this.port = port;
		this.interval = interval;
		this.pass = pass;
	}

	@Override
	public void run() {
		try {
			TelnetWrapper tn = new TelnetWrapper();
			tn.connect(address, port);
			
			tn.login("", "");
			
			if (pass.length() == 0) {
				tn.send("AUTHENTICATE\r\n");
			} else {
				tn.send("AUTHENTICATE \"" + pass + "\"r\n");
			}
			
			tn.waitfor("250 OK");
			
			while (Main.running) {
				Thread.sleep(interval * 1000L);
				tn.send("signal NEWNYM\r\n");
				tn.waitfor("250 OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
