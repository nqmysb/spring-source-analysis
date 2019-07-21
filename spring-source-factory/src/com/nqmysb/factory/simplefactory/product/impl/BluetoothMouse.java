package com.nqmysb.factory.simplefactory.product.impl;

import com.nqmysb.factory.simplefactory.product.Mouse;

/**
 * 
 * 蓝牙鼠标产品
 * @author liaocan
 *
 */
public class BluetoothMouse implements Mouse {

	
	@Override
	public String mouseProduct() {
		
		return "简单工厂产品：蓝牙鼠标";
	}


}
