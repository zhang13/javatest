package com.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

	/**
	 * 得到一个类的所有子类，或一个接口的所有实现类(默认是输入class的包下，如果要搜索全项目下，取消注释)
	 * @param c
	 * @return
	 */
	public static List<Class> getAllSubClassesOrInterfaceImplementsClasses(Class c) {
		List<Class> returnClassList = new ArrayList<Class>();

		String packageName = c.getPackage().getName();
		/*int firstDotIndex = packageName.indexOf('.');
		if(firstDotIndex!=-1){
			packageName=packageName.substring(0, firstDotIndex);
		}*/
		List<Class> allClasses;
		try {
			allClasses = getClassesInPackage(packageName);
			// 获得当前包下及子包下所有的类
			for (int i = 0; i < allClasses.size(); i++) {
				if (c.isAssignableFrom(allClasses.get(i))) {
					if (!c.equals(allClasses.get(i))) {
						returnClassList.add(allClasses.get(i));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return returnClassList;

	}

	// 找出一个包中所有的类(包含内部类)，jar包的不行
	private static List<Class> getClassesInPackage(String packageName)
			throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}

		List<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}

	private static List<Class> findClasses(File directory, String packageName)
			throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "."
						+ file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName
						+ '.'
						+ file.getName().substring(0,
								file.getName().length() - 6)));
			}
		}
		return classes;

	}

}
