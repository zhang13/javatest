package com.test.pattern.abstractfactory;

public abstract class AbstractHumanFactory implements HumanFactory{

	/**
	 * 给定一个性别人类，创建一个人类出来，专业术语叫产品等级
	 * @param humanEnum
	 * @return
	 */
	public Human createHuman(HumanEnum humanEnum){
		Human human = null;
		if(!humanEnum.getValue().equals("")){
			try {
				human = (Human) Class.forName(humanEnum.getValue()).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return human;
	}
}
