package com.nqmysb.factory.abstractfactory.product.impl;

import com.nqmysb.factory.abstractfactory.product.Keyboard;


/**
 * 华硕键盘
 * @author liaocan
 *
 */
public class AsusKeyboard implements Keyboard {

	
	@Override
	public String keyboardProduct() {
		
		return "抽象工厂产品：华硕键盘";
	}


}
