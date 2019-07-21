package com.nqmysb.factory.abstractfactory.factory.impl;

import com.nqmysb.factory.abstractfactory.factory.AbstractFactory;
import com.nqmysb.factory.abstractfactory.product.Keyboard;
import com.nqmysb.factory.abstractfactory.product.Mouse;
import com.nqmysb.factory.abstractfactory.product.impl.DellKeyboard;
import com.nqmysb.factory.abstractfactory.product.impl.DellMouse;


/*
 * 
 * 戴尔工厂
 * 
 */
public class DellFactory implements AbstractFactory{

	@Override
	public Mouse produceMouse() {
		return new DellMouse();
	}

	@Override
	public Keyboard produceKeyboard() {
		
		return new DellKeyboard();

	}
	
	

}
