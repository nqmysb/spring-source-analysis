package com.nqmysb.factory.abstractfactory.product.impl;

import com.nqmysb.factory.abstractfactory.product.Mouse;

/**
 * 戴尔鼠标
 * @author liaocan
 *
 */
public class DellMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "抽象工厂产品：戴尔鼠标";
	}


}
