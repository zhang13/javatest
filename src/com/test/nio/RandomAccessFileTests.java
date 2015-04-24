package com.test.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

public class RandomAccessFileTests {

	public static void main(String[] args) throws Exception{
		File file = new File("D:/workspace/javatest/src/com/test/nio/myTest.txt");
		RandomAccessFile aFile = new RandomAccessFile(file, "r");
		long fileLength = aFile.length();
		System.out.println(fileLength);
		System.out.println(aFile.read());
		System.out.println(aFile.readLine());
		System.out.println(aFile.readLine());
	}
	
	class FileReaderThread extends Thread{
		private int skipLength;
		private int startPosition;
		private CountDownLatch cdl;
		private RandomAccessFile aFile;
		public FileReaderThread(int skipLength, int startPosition,
				CountDownLatch cdl,RandomAccessFile aFile) {
			this.skipLength = skipLength;
			this.startPosition = startPosition;
			this.cdl = cdl;
			this.aFile = aFile;
		}
		
		@Override
		public void run() {
		}
		
	}
}