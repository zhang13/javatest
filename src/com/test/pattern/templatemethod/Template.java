package com.test.pattern.templatemethod;

/**
 * 模板方法模式：在模板方法中按照一个规则和顺序执行基本方法，并且可以由isAlarm方法决定执行顺序的变更。
 * @author 张超
 * 2012-7-31下午04:22:50
 *
 */
public abstract class Template {

	//基本方法
	protected abstract void start();
	//基本方法
	protected abstract void alarm();
	//基本方法
	protected abstract void stop();


	//模板方法
	public void run() {
		this.start();
		//钩子，通过子类重写isAlarm方法，可以达到你决定是否执行这段代码。
		if (this.isAlarm()) {
			this.alarm();
		}
		this.stop();
	}

	//钩子方法
	protected boolean isAlarm() {
		return true;
	}


}
