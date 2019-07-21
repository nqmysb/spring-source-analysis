package com.nqmysb.factory.factorymethod.factory;

import com.nqmysb.factory.factorymethod.product.Mouse;

/**
 * 鼠标工厂
 * @author liaocan
 *
 */
public  interface MouseFactory {
	
	/**
	 * 生产鼠标
	 * @return
	 */
	Mouse produceMouse();

}
