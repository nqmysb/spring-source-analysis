package com.nqmysb.factory.factorymethod.client;

import com.nqmysb.factory.factorymethod.factory.MouseFactory;
import com.nqmysb.factory.factorymethod.factory.impl.AsusMouseFactory;
import com.nqmysb.factory.factorymethod.factory.impl.DellMouseFactory;
import com.nqmysb.factory.factorymethod.product.Mouse;

/**
 * 工厂方法client端
 * 
 * 工厂方法模式特点： 多个工厂类，一个产品抽象类。 多个工厂生成一类产品，一个工厂生产一种
 * 对比简单工厂：
 * 1.不同点：
 * 简单工厂：生产产品类型由传入工厂的参数决定，不同的参数生产不同的产品，只有一个工厂
 * 新增产品：需要修改工厂生产方法，添加对新增产品的处理 ，和产品类
 * 工厂方法：生产产品类型由工厂决定，不同的工厂生产不同的产品，存在多个工厂
 * 新增产品：需要新增工厂类和产品类
 * 所以相比而言工厂方法模式有更好的扩展性，新增产品不需要修改现有工厂类，符合开闭原则
 * 2.相同点：
 * 都是只生产一类产品  ，生产的产品拥有同一父类
 * 
 * @author liaocan
 *
 */
public class FactoryMethodClient {
	
	public static void main(String[] args) {

		//使用不同的工厂生产鼠标
		MouseFactory  dellMouseFactory = new DellMouseFactory();
		Mouse  dellMouse = dellMouseFactory.produceMouse();
		System.out.println("产品名称："+dellMouse.mouseProduct());

		MouseFactory  asusMouseFactory = new AsusMouseFactory();
		Mouse  asusMouse = asusMouseFactory.produceMouse();
		System.out.println("产品名称："+asusMouse.mouseProduct());
		
		/*
		 * 产品名称：戴尔鼠标
		 * 产品名称：华硕鼠标
		 */
	}

}
