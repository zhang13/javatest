package com.test.pattern.LSP;

public class Client {

	public static void main(String[] args) {
		Soldier soldier = new Soldier();
		soldier.killEnemys(new HandGun());
		soldier.killEnemys(new Rifle());
		soldier.killEnemys(new ToyGunExtendsAbstractGun());
		
		
		System.out.println("//---------------------------------------");
		soldier.playGame(new ToyGunExtendsAbstractToyGun(new HandGun()));
		soldier.playGame(new ToyGunExtendsAbstractToyGun(new Rifle()));
	}
}
