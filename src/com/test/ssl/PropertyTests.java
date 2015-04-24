package com.test.ssl;

import java.util.Properties;

import org.xvolks.jnative.misc.HKEY;
import org.xvolks.jnative.util.Advapi32;

public class PropertyTests {

	public static void main(String[] args) {
		System.setProperty("javax.net.ssl.trustStore", "E:/test.keystore");//安装证书
		Properties ps = System.getProperties();
		System.out.println(ps.getProperty("javax.net.ssl.trustStore"));
		
		try {
			String test = Advapi32.RegQueryDefaultValue(HKEY.HKEY_CLASSES_ROOT,  "TypeLib\\{81677532-E37E-4A79-B547-5C25F5164BE1}\\1.0\\0\\win32");
			System.out.println(test);
			String regValue = Advapi32.RegQueryDefaultValue(HKEY.HKEY_CURRENT_USER,  "Software\\Microsoft\\SystemCertificates\\TrustedPeople\\Certificates\\4DFF7063A19BB2514C0279804423BF78E0CAB7F2");
			System.out.println(regValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
