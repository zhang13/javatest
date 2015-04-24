package com.test.pattern.LSP;

public class Soldier {

	public void killEnemys(AbstractGun gun){
		System.out.println("士兵开始杀人了");
		gun.shape();
		gun.shoot();
	}
	
	public void playGame(AbstractToyGun gun){
		System.out.println("士兵玩杀人游戏了");
		gun.shape();
		gun.shoot();
	}
	
}
