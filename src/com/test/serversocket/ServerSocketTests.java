package com.test.serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketTests {

	private static int PORT = 3131; // 端口号
	private List<RecieveTask> clientList = new ArrayList<RecieveTask>(); // 保存连接对象
	private ExecutorService pool;
	private static ServerSocketTests socketServer;
	
	private boolean stoped=false;
	private Thread serverThread;
	
	private ServerSocketTests() {

	}
	
	public static synchronized ServerSocketTests getInstance() {
		if (socketServer==null) {
			socketServer = new ServerSocketTests();
		}
		return socketServer;
	}
	private ServerSocket server;
	public void startServer(){
		serverThread = new Thread("stratServer"){
			@Override
			public void run() {
				try {
					server = new ServerSocket(PORT);
					System.out.println(server.getReceiveBufferSize()/1024);//8k
					System.out.println(server.getReuseAddress());
					pool = Executors.newCachedThreadPool();
					Socket client = null;
					String ip;
					while (!stoped) {
						client = server.accept(); // 接收客户连接
						ip = client.getInetAddress().getHostAddress();
						RecieveTask task = new RecieveTask(client,ip);
						addClient(task);
						System.out.println("接收到一个连接:"+ip);
						pool.execute(task);
					}
				} catch (Exception e) {
					System.out.println("接收客户连接出错"+e);
				}
			}};
			serverThread.start();
	}
	
	public void stopServer(){
		stoped=true;
		pool.shutdown();
		pool=null;
		if(server!=null){
			try {
				server.close();
				server=null;
			} catch (IOException e) {
				System.out.println("交调设备采集停止"+e);
			}
		}
		if(serverThread!=null&&serverThread.isAlive()){
			serverThread.interrupt();
			serverThread=null;
		}
	}
	
	private synchronized void addClient(RecieveTask task) {
		int index = getTask(task);
		if(index>-1){
			clientList.get(index).destroy();
		}
		clientList.add(task);
	}

	private synchronized void removeTask(RecieveTask task){
		int index = getTask(task);
		if(index>-1){
			clientList.remove(index);
		}
	}
	
	private synchronized int getTask(RecieveTask rt){
		for(int i=0;i<clientList.size();i++){
			if(clientList.get(i).clientIp.equals(rt.clientIp)){
				return i;
			}
		}
		return -1;
	}
	
	class RecieveTask implements Runnable {
		private Socket socket;
		private InputStream  iis;
		private String clientIp;
		private byte[] responses;
		private boolean isAcceptData=true;
		
		public void destroy(){
			try {
				isAcceptData=false;
				removeTask(this);
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public RecieveTask(Socket socket,String clientIp) throws IOException {
			this.socket = socket;
			this.clientIp = clientIp;
		}

		public void run() {
			while(isAcceptData){
				dealData();
			}
		}

		private void dealData() {
			try{
				iis = socket.getInputStream();
				int availabeLength = iis.available();//获取可接受数据长度
				if(availabeLength>0){
					responses = new byte[availabeLength];
					int result = iis.read(responses);//接受数据长度
					if(result==-1){//用来判断客户端是否还在连接，一旦客户端异常中断，此处为-1
						destroy();
						throw new RuntimeException();
					}
				}
				/*
				 * 数据处理-------------------------------
				 */
			}catch(Exception e){
				throw new RuntimeException("从socket连接读取数据出错，可能由于客户端连接中断导致。ip:"+clientIp);
			}
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}

		public String getClientIp() {
			return clientIp;
		}

		public void setClientIp(String clientIp) {
			this.clientIp = clientIp;
		}

		public boolean isAcceptData() {
			return isAcceptData;
		}

		public void setAcceptData(boolean isAcceptData) {
			this.isAcceptData = isAcceptData;
		}
	}
}
