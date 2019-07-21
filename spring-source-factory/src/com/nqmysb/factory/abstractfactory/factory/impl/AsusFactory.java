package com.nqmysb.factory.abstractfactory.factory.impl;

import com.nqmysb.factory.abstractfactory.factory.AbstractFactory;
import com.nqmysb.factory.abstractfactory.product.Keyboard;
import com.nqmysb.factory.abstractfactory.product.Mouse;
import com.nqmysb.factory.abstractfactory.product.impl.AsusKeyboard;
import com.nqmysb.factory.abstractfactory.product.impl.AsusMouse;


/*
 * 
 * 华硕工厂
 * 
 */
public class AsusFactory implements AbstractFactory{

	@Override
	public Mouse produceMouse() {
		return new AsusMouse();
	}

	@Override
	public Keyboard produceKeyboard() {
		
		return new AsusKeyboard();
	
	}
	
	

}
