package com.test.serversocket;

import static org.junit.Assert.*;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

import org.junit.Test;

public class ReUseAddrTests {
	private static int PORT = 3131; // 端口号
	
	@Test
	public void reUseAddrIsFalseTests(){
		boolean flag=true;
		try {
			makeNewServerSetReUseAddrFalse1();
			makeNewServerSetReUseAddrFalse2();
			fail("没有抛出异常，测试失败");
		} catch (Exception e) {
			flag=false;
			assertEquals("Address already in use: JVM_Bind", e.getMessage());// 抛出的异常信息是否和期望一致
		}
		assertFalse(flag);
	}
	
	@Test
	public void reUseAddrIsTrueTests(){
		boolean flag=true;
		try {
			assertTrue(makeNewServerSetReUseAddrTrue1());
			assertTrue(makeNewServerSetReUseAddrTrue2());
		} catch (Exception e) {
			flag=false;
		}
		assertTrue(flag);
	}
	
	public boolean makeNewServerSetReUseAddrFalse1() throws Exception{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(PORT));
		return true;
	}
	
	public boolean makeNewServerSetReUseAddrFalse2() throws Exception{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(PORT));
		return true;
	}
	
	public boolean makeNewServerSetReUseAddrTrue1() throws Exception{
		ServerSocket server = new ServerSocket();
		server.setReuseAddress(true);//这句必须在端口绑定前边，否则无效！
		server.bind(new InetSocketAddress(PORT));
		return true;
	}
	
	public boolean makeNewServerSetReUseAddrTrue2() throws Exception{
		ServerSocket server = new ServerSocket();
		server.setReuseAddress(true);
		server.bind(new InetSocketAddress(PORT));
		return true;
	}
}
