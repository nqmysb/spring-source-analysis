package com.nqmysb.factory.simplefactory.client;

import com.nqmysb.factory.simplefactory.factory.SimpleFactory;
import com.nqmysb.factory.simplefactory.product.Mouse;

/**
 * 简单工厂client端
 * 
 * 鼠标简单工厂： 只能生产鼠标
 * 如果需要添加一个鼠标产品：wifi鼠标
 * 1.添加一个wifi鼠标产品实现类 ：WifiMourse implements Mourse 
 * 2.鼠标简单工厂SimpleFactory 生产方法 produceMourse 需要添加一个参数处理逻辑 
 * 
 * 简单工厂特点： 一个工厂类，一个产品抽象类。
 * 比如：一个鼠标工厂只能生产鼠标这一类产品
 * 
 * @author liaocan
 *
 */
public class SimpleFactoryClient {
	
	public static void main(String[] args) {
		
		//一个工厂根据传入的参数决定生产的鼠标产品
		SimpleFactory mourseFactory = new SimpleFactory();
		//生产蓝牙鼠标
		Mouse mourse1 = mourseFactory.produceMouse(1);
		System.out.println("产品名称："+mourse1.mouseProduct());
		//生产无线鼠标
		Mouse mourse2 = mourseFactory.produceMouse(2);
		System.out.println("产品名称："+mourse2.mouseProduct());
		//生产有线鼠标
		Mouse mourse3 = mourseFactory.produceMouse(3);
		System.out.println("产品名称："+mourse3.mouseProduct());
		
		/**
		 	产品名称：蓝牙鼠标
			产品名称：无线鼠标
			产品名称：有线鼠标
		 */

	}

}
