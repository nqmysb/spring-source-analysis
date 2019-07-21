package com.nqmysb.factory.abstractfactory.client;

import com.nqmysb.factory.abstractfactory.factory.AbstractFactory;
import com.nqmysb.factory.abstractfactory.factory.impl.AsusFactory;
import com.nqmysb.factory.abstractfactory.factory.impl.DellFactory;
import com.nqmysb.factory.abstractfactory.product.Keyboard;
import com.nqmysb.factory.abstractfactory.product.Mouse;

/**
 * 抽象工厂client 类
 * 
 * 抽象工厂特点： 多个工厂类，多个产品抽象类 。一个工厂可以生产多种产品
 * 新增一个产品：
 * 1.新增产品抽象类和产品实现类
 * 2.需要在抽象工厂中新增生产产品方法，然后再子工厂中添加实现
 * 
 * 和工厂方法，简单工厂的不同点：
 * 抽象工厂可以生产多种类型的产品，不但可以生产鼠标还可以生产键盘，主机等等
 * 
 * @author liaocan
 *
 */
public class AbstractFactoryClient {
	
	public static void main(String[] args) {
		
		//1.直接new 获取工厂
		AsusFactory asusFactory = new AsusFactory();
		//生产产品
		Keyboard asusKeyboard = asusFactory.produceKeyboard();
		Mouse asusMouse = asusFactory.produceMouse();
		System.out.println("产品名称："+asusMouse.mouseProduct());
		System.out.println("产品名称："+asusKeyboard.keyboardProduct());

		DellFactory dellFactory = new DellFactory();
		//生产产品
		Keyboard dellKeyboard = dellFactory.produceKeyboard();
		Mouse dellMouse = dellFactory.produceMouse();
		
		System.out.println("产品名称："+dellMouse.mouseProduct());
		System.out.println("产品名称："+dellKeyboard.keyboardProduct());

		
		//2.通过简单工厂模式获取工厂对象
		FactoryProducer factoryProducer = new FactoryProducer();
		
		AbstractFactory asusFactory2 = factoryProducer.produceFactory("ASUS");
		
		Keyboard asusKeyboard2 = asusFactory2.produceKeyboard();
		Mouse asusMouse2 = asusFactory.produceMouse();
		
		System.out.println("产品名称："+asusMouse2.mouseProduct());
		System.out.println("产品名称："+asusKeyboard2.keyboardProduct());

		AbstractFactory dellFactory2 = factoryProducer.produceFactory("DELL");
		
		Keyboard dellKeyboard2 = dellFactory2.produceKeyboard();
		Mouse dellMouse2 = dellFactory.produceMouse();
		
		System.out.println("产品名称："+dellMouse2.mouseProduct());
		System.out.println("产品名称："+dellKeyboard2.keyboardProduct());

		/*		
 		产品名称：抽象工厂产品：华硕鼠标
		产品名称：抽象工厂产品：华硕键盘
		产品名称：抽象工厂产品：戴尔鼠标
		产品名称：抽象工厂产品：戴尔键盘
		产品名称：抽象工厂产品：华硕鼠标
		产品名称：抽象工厂产品：华硕键盘
		产品名称：抽象工厂产品：戴尔鼠标
		产品名称：抽象工厂产品：戴尔键盘
		*/
		
		
	}

}
