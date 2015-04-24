package com.test.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingTest {

	/*
	 * public static void main(String[] args) { try { String ip="192.168.0.13";
	 * InetAddress address = InetAddress.getByName(ip);
	 * System.out.println("Name: " + address.getHostName());
	 * System.out.println("Addr: " + address.getHostAddress());
	 * System.out.println("Reach: " + address.isReachable(3000)); } catch
	 * (UnknownHostException e) {
	 * System.err.println("Unable to lookup web.mit.edu"); } catch (IOException
	 * e) { System.err.println("Unable to reach web.mit.edu"); } }
	 */
	public static void main(String[] args) {
		Socket server = null;
		try {
			server = new Socket();
			InetSocketAddress address = new InetSocketAddress(
					"20.61.23.2", 23);
			server.connect(address, 5000);
			System.out.println("ok!");
		} catch (UnknownHostException e) {
			System.out.println("wrong!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
	}
}
