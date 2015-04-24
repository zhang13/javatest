package com.test.ssl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Simple_SSLServerSocket {
	
	private final static int LISTEN_PORT = 54321;// 定义了监听端口号
	private final static String CERT_STORE = "E:/test.keystore";// 要使用的证书名
	private final static String CERT_STORE_PASSWORD = "123456";// 证书密码
	private final static String KEY_STORE_PASSWORD = "admin.123";// 证书别称所使用的主要密码

	public static void main(String args[]) throws Exception {
		startServer();
	}

	public static void startServer() throws Exception, IOException {
		SSLServerSocket serverSocket = null;
		SSLSocket clientSocket = null;
		// 使用默认方式获取套接字工厂实例
		// SSLServerSocketFactory ssf = (SSLServerSocketFactory)
		// SSLServerSocketFactory.getDefault();

		// 相关的 jks 文件及其密码定义
		// 载入 jks 文件
		SSLServerSocketFactory ssf = getSSLServerSocketFactory();

		try {
			serverSocket = (SSLServerSocket) ssf.createServerSocket(LISTEN_PORT);
			// 设置不需要验证客户端身份
			serverSocket.setNeedClientAuth(false);
			System.out.println("SSLServer is listening on " + LISTEN_PORT+ " port");
			// 循环监听端口，如果有客户端连入就新开一个线程与之通信
			while (true) {
				// 接受新的客户端连接
				clientSocket = (SSLSocket) serverSocket.accept();
				ClientConnection clientConnection = new ClientConnection(clientSocket);
				// 启动一个新的线程
				Thread clientThread = new Thread(clientConnection);
				System.out.println("Client " + clientThread.getId()+ " is connected");
				clientThread.run();
			}
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}

	private static SSLServerSocketFactory getSSLServerSocketFactory() {
		System.setProperty("javax.net.ssl.trustStore", CERT_STORE);
		SSLServerSocketFactory ssf = null;
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
			ssf = (SSLServerSocketFactory) context.getServerSocketFactory();
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

class ClientConnection implements Runnable {
	private Socket clientSocket = null;

	public ClientConnection(SSLSocket sslsocket) {
		clientSocket = sslsocket;
	}

	public void run() {
		BufferedReader reader = null;
		// 将接收到的来自客户端的文字打印出来
		try {
			reader = new BufferedReader(new InputStreamReader(clientSocket
					.getInputStream()));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					System.out.println("Communication end.");
					break;
				}
				System.out.println("Receive message: " + line);
			}
			reader.close();
			clientSocket.close();
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}