package com.nqmysb.factory.simplefactory.product.impl;

import com.nqmysb.factory.simplefactory.product.Mouse;

/**
 * 
 * 无线鼠标产品
 * @author liaocan
 *
 */
public class RemoteMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "简单工厂产品：无线鼠标";
	}


}
