package com.nqmysb.factory.factorymethod.factory.impl;

import com.nqmysb.factory.factorymethod.factory.MouseFactory;
import com.nqmysb.factory.factorymethod.product.Mouse;
import com.nqmysb.factory.factorymethod.product.impl.AsusMouse;


/**
 * 
 *  华硕鼠标工厂
 * @author liaocan
 *
 */
public class AsusMouseFactory implements MouseFactory {
	/**
	 * 生产华硕鼠标
	 */
	@Override
	public Mouse produceMouse() {
		
		return new AsusMouse();
	}

}
