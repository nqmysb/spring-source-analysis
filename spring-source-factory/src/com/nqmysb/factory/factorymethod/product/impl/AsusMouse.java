package com.nqmysb.factory.factorymethod.product.impl;

import com.nqmysb.factory.factorymethod.product.Mouse;


/**
 * 华硕鼠标
 * @author liaocan
 *
 */
public class AsusMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "工厂方法产品：华硕鼠标";
	}


}
