package com.test.pattern.LSP;

/*
 * 
 */
public abstract class AbstractToyGun {

	protected AbstractGun gun;
	
	public void setGun(AbstractGun gun) {
		this.gun = gun;
	}
	
	public void shape(){
		this.gun.shape();
	}
	
	public abstract void shoot();
	
}
