package com.nqmysb.factory.simplefactory.factory;

import com.nqmysb.factory.simplefactory.product.Mouse;
import com.nqmysb.factory.simplefactory.product.impl.BluetoothMouse;
import com.nqmysb.factory.simplefactory.product.impl.RemoteMouse;
import com.nqmysb.factory.simplefactory.product.impl.Wiredmouse;

/**
 * 
 * 生产鼠标的简单工厂
 * 
 * @author liaocan
 *
 */
public class SimpleFactory {
	
	/**
	 * 根据type类型生产不同类型的鼠标产品
	 * @param type
	 * @return
	 */
	public Mouse produceMouse(int type){
		
		if(1 == type ){
			return new BluetoothMouse();
		}else if(2 == type ){
			return new RemoteMouse();
		}else if(3 == type ){
			return new Wiredmouse();
		}
		//默认生产有线鼠标
		return new Wiredmouse();
	}

}
