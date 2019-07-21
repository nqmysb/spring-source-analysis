package com.nqmysb.factory.abstractfactory.product.impl;

import com.nqmysb.factory.abstractfactory.product.Keyboard;


/**
 * 戴尔键盘
 * @author liaocan
 *
 */
public class DellKeyboard implements Keyboard {

	
	@Override
	public String keyboardProduct() {
		
		return "抽象工厂产品：戴尔键盘";
	}


}
