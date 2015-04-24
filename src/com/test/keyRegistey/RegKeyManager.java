package com.test.keyRegistey;

import java.io.*;
public class RegKeyManager {
    private final String TYPES[] = { "SZ", "BINARY", "DWORD", "QWORD", "DWORD_LITTLE_ENDIAN", "QWORD_LITTLE_ENDIAN", "DWORD_BIG_ENDIAN", "EXPAND_SZ", "LINK", "MULTI_SZ", "NONE", "RESOURCE_LIST" };
    private String type = "", value = "", key = "";
    /**
     * 查询注册表
     * @param loc 注册表路径
     * @param k 项名称
     * @throws Exception
     */
    public void query(String loc, String k) throws Exception {
        Process p = Runtime.getRuntime().exec("reg QUERY \"" + loc + "\" /v \"" + k + "\"");
        BufferedReader in = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
        String out = "";
        while ( ( out = in.readLine() ) != null ) {
            if (out.matches("(.*)\\s+REG_(.*)")) { break; }
        }
        in.close();
        int typeIndex = out.indexOf("REG_");
        key = out.substring(0, typeIndex).trim();
        int firstBlockAfterType = out.substring(typeIndex).indexOf(" ");
        type = out.substring(typeIndex, firstBlockAfterType+typeIndex).trim();
        value = out.substring(firstBlockAfterType+typeIndex).trim();
    }
    public String getKey() { return key; }
    public String getType() { return type; }
    public String getValue() { return value; }
    protected boolean add(String loc, String name, String dType, String value) throws Exception {
        boolean comp = false, valid = false;
        for (int a = 0; a < TYPES.length; a++) {
            if (dType.equalsIgnoreCase("REG_" + TYPES[a])) { valid = true; break; }
        }
        if ( valid ) {
            Process p = Runtime.getRuntime().exec("reg ADD \"" + loc + "\" /v \"" + name + "\" /t \"" + dType + "\" /d \"" + value + "\"");
            BufferedReader in = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
            String out = "";
            while ( (out = in.readLine() ) != null ) {
                if (out.equalsIgnoreCase("The operation completed successfully.")) { comp = true; }
            }
            in.close();
        }
        return comp;
    }
    protected boolean delete(String loc, String key) throws Exception {
        boolean comp = false;
        Process p = Runtime.getRuntime().exec("reg DELETE \"" + loc + "\" /v \"" + key + "\" /f");
        BufferedReader in = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
        String out = "";
        while ( ( out = in.readLine() ) != null ) {
            if (out.equalsIgnoreCase("The operation completed successfully.")) { comp = true; }
        }
        in.close();
        return comp;
    }
    
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