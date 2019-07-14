package com.nqmysb.proxy.cglib;


/**
 * 被代理的类
 * 注意： 被代理类和方法 不能用final修饰，否则无法使用CGLIB动态代理，会报错 
 * 
 * @author liaocan
 *
 */
public class Subject {
	
	/*
	 * 业务方法
	 */
	void businessMethod() {
		System.out.println("我是被代理对象的，我正在执行业务操作。。。");
	}

}
