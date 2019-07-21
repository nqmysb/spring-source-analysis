package com.nqmysb.factory.factorymethod.product.impl;

import com.nqmysb.factory.factorymethod.product.Mouse;


/**
 * 戴尔鼠标
 * @author liaocan
 *
 */
public class DellMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "工厂方法产品：戴尔鼠标";
	}


}
