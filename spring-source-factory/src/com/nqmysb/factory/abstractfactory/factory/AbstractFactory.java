package com.nqmysb.factory.abstractfactory.factory;

import com.nqmysb.factory.abstractfactory.product.Keyboard;
import com.nqmysb.factory.abstractfactory.product.Mouse;

/**
 * 
 * 生产电脑的抽象工厂类
 * 
 * @author liaocan
 *
 */
public interface AbstractFactory {
	
	/**
	 * 生产鼠标
	 */
	Mouse produceMouse();
	
	
	/**
	 * 生产键盘
	 */
	Keyboard produceKeyboard();

}
