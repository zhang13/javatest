package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {

	/**
	 * 根据类名，参数返回类实例
	 * 
	 * @param className
	 *            类名
	 * @param args
	 *            参数
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Object getInstance(String className, Object[] args)
			throws Exception {
		Class<?> clas = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Constructor con = clas.getConstructor(argsClass);
		return con.newInstance();
	}

	/**
	 * 通过对象和属性名，获取属性值
	 * 
	 * @param owner
	 *            对象
	 * @param fieldName
	 *            属性名
	 * @return
	 * @throws Exception
	 */
	public static Object getProperty(Object owner, String fieldName)
			throws Exception {
		Class<?> ownerClass = owner.getClass();
		Field field = ownerClass.getDeclaredField(fieldName);
		field.setAccessible(true);// 设置通过反射访问该Field时取消访问权限检查，这样就可以访问私有属性了。
		Object property = field.get(owner);
		return property;
	}

	/**
	 * 执行某类的方法
	 * 
	 * @param owner
	 *            类对象
	 * @param methodName
	 *            方法名
	 * @param args
	 *            参数
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class<?> ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
		return method.invoke(owner, argsClass);

	}

	/**
	 * 执行某类的静态方法
	 * 
	 * @param className
	 *            类名
	 * @param methodName
	 *            方法名
	 * @param args
	 *            参数
	 * @return
	 * @throws Exception
	 */
	public static Object invokeStaticMethod(String className,
			String methodName, Object[] args) throws Exception {
		Class<?> ownerClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
		return method.invoke(null, argsClass);

	}

	/**
	 * 判断是不是某个类的实例
	 * 
	 * @param obj
	 *            实例
	 * @param clas
	 *            类
	 * @return
	 */
	public static boolean isInstance(Object obj, Class<?> clas) {
		return clas.isInstance(obj);
	}

	/**
	 * 复制一个对象，条件是此对象符合javabean规范
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object copy(Object object) throws Exception {
		// 获得对象的类型
		Class<?> classType = object.getClass();
		System.out.println("Class:" + classType.getName());

		// 通过默认构造方法创建一个新的对象
		Object objectCopy = classType.getConstructor(new Class[] {})
				.newInstance(new Object[] {});

		// 获得对象的所有属性
		Field fields[] = classType.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			// 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// 获得和属性对应的setXXX()方法的名字
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			// 获得和属性对应的getXXX()方法
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			// 获得和属性对应的setXXX()方法
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });

			// 调用原对象的getXXX()方法
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + ":" + value);
			// 调用拷贝对象的setXXX()方法
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}

	/**
	 * 获取类属性类型
	 * @param clas
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public Type getType(Class<?> clas ,String fieldName) throws Exception{
		Field field = clas.getDeclaredField(fieldName);
		Class<?> type = field.getType();//得到普通类型
		Type gType = field.getGenericType();//得到泛型类型
		//如果是泛型类型
		if(gType instanceof ParameterizedType){
			ParameterizedType pType = (ParameterizedType)gType;
			Type rType = pType.getRawType();
			//Type[] tArgs = pType.getActualTypeArguments();//获取泛型参数类型
			return rType;
		}else{
			return type;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Person p = (Person) getInstance("com.test.reflect.Person",
				new Object[] {});
		p.setId("1");
		p.setName("charles");
		System.out.println(p.getName());

		System.out.println(getProperty(p, "name"));

	}
}
