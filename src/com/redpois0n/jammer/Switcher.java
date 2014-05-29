package com.redpois0n.jammer;

public class Switcher implements Runnable {
	
	private String address;
	private int port;
	private int interval;

	public Switcher(String address, int port, int interval) {
		this.address = address;
		this.port = port;
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
