package com.jdk8.interfaces;

/**
 * 
 * @author charles.zhang13
 * <li>Java 8 ��������ʹ��default�ؼ��֣�Ϊ�ӿ�������ӷǳ���ķ���ʵ�֡���������ֱ���Ϊ��չ������
 * ʵ����ֻ��Ҫʵ�ֽӿڷ�����Ĭ�Ϸ�������ֱ��ʹ�ã�����Ҳ�ɱ���д����Ҫ�����໹�к����أ�������
 * 
 */
public interface DefaultInterface {

	double calculate(int a);
	
	default double sqrt(int a){
		System.out.println("�ӿ�");
		return Math.sqrt(a);
	}
}
