package com.nqmysb.factory.factorymethod.factory.impl;

import com.nqmysb.factory.factorymethod.factory.MouseFactory;
import com.nqmysb.factory.factorymethod.product.Mouse;
import com.nqmysb.factory.factorymethod.product.impl.DellMouse;


/**
 * 
 *  戴尔鼠标工厂
 * @author liaocan
 *
 */
public class DellMouseFactory implements MouseFactory {
	/**
	 * 生产戴尔鼠标
	 */
	@Override
	public Mouse produceMouse() {
		
		return new DellMouse();
	}

}
