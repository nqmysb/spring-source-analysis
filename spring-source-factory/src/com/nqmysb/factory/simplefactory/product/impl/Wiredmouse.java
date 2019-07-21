package com.nqmysb.factory.simplefactory.product.impl;

import com.nqmysb.factory.simplefactory.product.Mouse;

/**
 * 
 * 有线鼠标产品
 * @author liaocan
 *
 */
public class Wiredmouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "简单工厂产品：有线鼠标";
	}


}
