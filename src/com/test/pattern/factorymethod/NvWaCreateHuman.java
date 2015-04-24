package com.test.pattern.factorymethod;


public class NvWaCreateHuman {

	//≈ÆÊ¥‘Ï»À
	public static void main(String[] args) {
		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		blackHuman.laugh();
		blackHuman.cry();
		blackHuman.talk();
		
		Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
		whiteHuman.laugh();
		whiteHuman.cry();
		whiteHuman.talk();
		
		Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
		yellowHuman.laugh();
		yellowHuman.cry();
		yellowHuman.talk();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<10;i++){
			Human human = HumanFactory.createHumanRandom();
			human.cry();
			human.laugh();
			human.talk();
		}
	}
}
