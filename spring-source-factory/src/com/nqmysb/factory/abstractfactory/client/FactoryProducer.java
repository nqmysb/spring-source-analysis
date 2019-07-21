package com.nqmysb.factory.abstractfactory.client;

import com.nqmysb.factory.abstractfactory.factory.AbstractFactory;
import com.nqmysb.factory.abstractfactory.factory.impl.AsusFactory;
import com.nqmysb.factory.abstractfactory.factory.impl.DellFactory;

/**
 * 生产工厂的工厂
 * 
 * 这里用简单工厂模式
 * 
 * @author liaocan
 *
 */
public class FactoryProducer {
	
	/**
	 * 根据参数生产不同的工厂对象
	 * @param type
	 * @return
	 */
	public AbstractFactory  produceFactory(String type){
		if("Dell" .equalsIgnoreCase(type)){
			return new DellFactory();
		}else if("Asus".equalsIgnoreCase(type)){
			return new AsusFactory();
		}
		//默认生产华硕工厂类对象
		return new AsusFactory();
		
	}

}
