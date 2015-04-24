package com.test.pattern.factorymethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.utils.ClassUtils;

/**
 * 工厂方法模式
 * @author 张超
 * 2012-7-30下午02:40:41
 *
 */
public class HumanFactory {

	//用于延迟始化
	private static Map<String,Human> humans= new HashMap<String,Human>();
	/**
	 * 创建对象方法
	 * @param c 类
	 * @return
	 */
	public static Human createHuman(Class c) {
		
		Human human = null;
		try {
			if(humans.containsKey(c.getSimpleName())){
				human = humans.get(c.getSimpleName());
			}else{
				human = (Human) Class.forName(c.getName()).newInstance();
				humans.put(c.getSimpleName(), human);
			}
		} catch (InstantiationException e) {
			System.out.println("必须指定人类颜色！");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("人类定义错误！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("混蛋，你指定 的人类找不到！");
			e.printStackTrace();
		}
		return human;
	}
	
	//随机制造人类对象
	public static Human createHumanRandom(){
		Human human = null;
		List<Class> humanImplementsList = ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(Human.class);//得到实现了human接口的类
		Random rand = new Random();
		int randInt = rand.nextInt(humanImplementsList.size());
		human = createHuman(humanImplementsList.get(randInt));
		return human;
	}
	
}
