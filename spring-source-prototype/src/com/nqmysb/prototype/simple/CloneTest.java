package com.nqmysb.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式：
 * 提高效率  对象实现Cloneable接口就可以被拷贝
 * clone()就是用到原型模式，但是只能浅拷贝，基本类型和string类型可以拷贝
 * 实现clone()方法的时候，
如果用默认的super.clone()方法会调用Object类的默认拷贝，缺陷：不会把所有的属性全部拷贝一份，拷贝规则：
（1）基本类型，拷贝其值
（2）对象：
拷贝引用地址，新拷贝的对象和原有对象共享该实例变量，不受访问权限控制。
（3）String字符串：拷贝的是引用，但有点特殊，在修改时，会从字符串池中重新生成新的字符串。原有的字符串内容保持不变，故可以认为String是一个基本类型。

 * 要实现深拷贝可以使用序列化
 * 
 * 
 * 
 * @author liaocan
 *
 */
public class CloneTest {

	
	
	public static void main(String[] args) {
		
		ConcretePrototype cp = new ConcretePrototype();
		cp.setAge(18);
		cp.setName("Tom");
		
		//cp.list.add("Tom");
		
		try {
			ConcretePrototype copy = (ConcretePrototype)cp.clone();
			
			System.out.println(copy  == cp);
			System.out.println(copy.list  == cp.list);
			System.out.println(copy.getAge() + "," + copy.getName() + ","+copy.list.size());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//clone方法的效果 
		//就是一个现成的对象，这个对象里面有已经设置好的值
		//当我要新建一个对象，并且要给新建的对象赋值，而且赋值内容要跟之前的一模一样
		//如果属性多循环反射效率很低
		
		//反射一般在初始化过程中，不在运行过程中，因为性能低
		
		//没有原型模式的做法  new两个对象 然后再获取值进行赋值
		//ConcretePrototype cp = new ConcretePrototype();
		//cp.setAge(18);
		
		//ConcretePrototype copy = new ConcretePrototype();
		//copy.setAge(cp.getAge());
		//copy.setName(cp.getName());
		//用循环，用反射，确实可以的（反射性能并不高）
		//字节码复制newInstance()
		
		//ConcretePrototype copy = cp;
		//ORM的时候经常用到的
		
		
		//能够直接拷贝其实际内容的数据类型/只支持9种,八大基本数据类型+String 浅拷贝  基本类型
		//深拷贝  可以拷贝引用类型
		
	}
	
}
