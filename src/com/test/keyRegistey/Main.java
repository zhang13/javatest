package com.test.keyRegistey;

public class Main {

	public static void main(String[] args) {
        try {
            RegKeyManager rkm = new RegKeyManager();
//            64位系统的注册表目录
//            rkm.query("HKEY_LOCAL_MACHINE\\SOFTWARE\\Wow6432Node\\Tencent\\QQ2009", "Install");
//            32位系统的注册表目录
            rkm.query("HKEY_CLASSES_ROOT\\TypeLib\\{81677532-E37E-4A79-B547-5C25F5164BE1}\\1.0\\0\\win32", "");
            //rkm.query("HKEY_LOCAL_MACHINE\\SOFTWARE\\Tencent\\QQ2009", "Install"); 
            System.out.println("KEY: " + rkm.getKey() + " DATA TYPE: " + rkm.getType() + " DATA VALUE: " + rkm.getValue());
//            rkm.add("HKEY_LOCAL_MACHINE\\SOFTWARE\\Tencent\\QQ2009","TESTING","REG_SZ","VALUE DATA");
//            rkm.delete("HKEY_LOCAL_MACHINE\\SOFTWARE\\Tencent\\QQ2009","TESTING");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
