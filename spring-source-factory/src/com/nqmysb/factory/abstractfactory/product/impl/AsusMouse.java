package com.nqmysb.factory.abstractfactory.product.impl;

import com.nqmysb.factory.abstractfactory.product.Mouse;

/**
 * 华硕鼠标
 * @author liaocan
 *
 */
public class AsusMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "抽象工厂产品：华硕鼠标";
	}


}
