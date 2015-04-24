package com.test.pattern.Strategy;

public class Context {

	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void doMethod(){
		strategy.helloWorld();
	}
	public static void main(String[] args) {
		Context c ;
		c = new Context(new StrategyA());
		c.doMethod();
		c = new Context(new StrategyB());
		c.doMethod();
	}

}
