package com.nqmysb.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 代理类，必须实现JDK中的InvocationHandler  这是JDK动态代理的标志
 * 可以理解：需要实现JDK的代理，必须要这个证书 
 * @author liaocan
 *
 */
public class DynamicProxy implements InvocationHandler {
	
	private Subject target; //被代理对象的引用  这里是代理对象的接口  说明 该代理类是可以代理该接口下的所有子类的
	
	//动态生成代理对象
	public Object getInstance(Subject target) throws Exception{
		//获取代理对象
		this.target = target;
		//代理的对象必须是 suject的实现类
		Class<? extends Subject> clazz = target.getClass();
		
		//被代理对象的class是:class com.nqmysb.proxy.jdk.impl.RealSubject
		System.out.println("被代理对象的class是:"+clazz);
		
		//被代理对象的类加载器:sun.misc.Launcher$AppClassLoader@20eb607d
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println("被代理对象的类加载器:"+classLoader);
		
		//被代理对象的class是:[Ljava.lang.Class;@602f892f  返回所有实现接口的数组 [interface com.nqmysb.proxy.jdk.Subject]
		Class<?>[] classs = clazz.getInterfaces();
		System.out.println("被代理对象实现的接口:"+Arrays.asList(classs));
		//proxy的静态方法 newProxyInstance
		// 参数说明：被代理对象的类加载器 clazz.getClassLoader  ,被代理对象实现的接口 clazz.getInterfaces() ,当前对象 this
		//this 参数传入 把代理类和被代理类产生关联 当要执行被代理对象的方法时 会自动调用代理对象invoke方法进行代理执行
		return Proxy.newProxyInstance(classLoader, classs, this);
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("开始代理...");
		System.out.println("代理之前做的事情...");
		System.out.println("------------"); 
		
		//执行代理方法
		method.invoke(this.target, args);
		
		System.out.println("------------");
		System.out.println("代理之后做的事情...");
		System.out.println("结束代理...");
		return null;
	}
	
	



}
