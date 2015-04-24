package com.test.ssl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Simple_SSLSocket {
	
	private final static String CERT_STORE = "E:/test.keystore";// 要使用的证书名
	private final static String CERT_STORE_PASSWORD = "123456";// 证书密码
	private final static String KEY_STORE_PASSWORD = "admin.123";// 证书别称所使用的主要密码
	// 定义要连接的服务器名和端口号
	private static final String DEFAULT_HOST = "192.168.0.33";
	private static final int DEFAULT_PORT = 54321;

	public static void main(String args[]) {
		SSLSocket socket = null;
		// 使用默认的方式获取工厂实例
		SSLSocketFactory sf = getSSLSocketFactory();
		try {
			// 连接服务端的端口，完成握手过程
			socket = (SSLSocket) sf.createSocket(DEFAULT_HOST, DEFAULT_PORT);
			socket.startHandshake();
			System.out.println("Connected to " + DEFAULT_HOST + ":"+ DEFAULT_PORT + " !");
			// 从控制台输入要发送给服务端的文字
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			// 可以反复向服务端发送消息
			boolean done = false;
			while (!done) {
				System.out.print("Send Message: ");
				String line = reader.readLine();
				if (line != null) {
					writer.write(line + "\n");
					writer.flush();
				} else {
					done = true;
				}
			}
			socket.close();
		} catch (Exception e) {
			System.out.println("Connection failed: " + e);
			try {
				socket.close();
			} catch (IOException ioe) {
			}
			socket = null;
		}
	}
	
	private static SSLSocketFactory getSSLSocketFactory() {
		System.setProperty("javax.net.ssl.trustStore", CERT_STORE);//安装证书
		SSLSocketFactory ssf = null;
		try {
			FileInputStream f_certStore = new FileInputStream(CERT_STORE);
			// 创建JKS密钥库
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(f_certStore, CERT_STORE_PASSWORD.toCharArray());
			// 创建管理JKS密钥库的X.509密钥管理器
			KeyManagerFactory kf = KeyManagerFactory.getInstance("SunX509");
			kf.init(ks, KEY_STORE_PASSWORD.toCharArray());

			KeyManager[] kms = kf.getKeyManagers();

			// 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。
			SSLContext context = SSLContext.getInstance("SSLv3");
			context.init(kms, null, null);
			ssf = (SSLSocketFactory) context.getSocketFactory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return ssf;
	}
}