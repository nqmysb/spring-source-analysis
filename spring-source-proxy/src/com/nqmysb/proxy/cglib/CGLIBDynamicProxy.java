package com.nqmysb.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author liaocan
 *
 */
public class CGLIBDynamicProxy implements MethodInterceptor {
	
	
	
	public Object getInstance(Class<?> clazz) throws Exception{
		
		Enhancer enhancer = new Enhancer();
		
		//通过动态生成被代理类的子类
		enhancer.setSuperclass(clazz);
		//设置函数回调，动态代理模式的重要两个基础之一：函数回调
		enhancer.setCallback(this);
		
		//第一步、动态生成子类的源代码
		//第二步、编译成class文件
		//第三步、加载到JVM中，并返回被代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		System.out.println("开始代理...");
		System.out.println("代理之前做的事情...");
		System.out.println("------------"); 
		
		//执行代理方法
		proxy.invokeSuper(obj, args);
		
		System.out.println("------------");
		System.out.println("代理之后做的事情...");
		System.out.println("结束代理...");
		return null;
	}
	

	
	



}
