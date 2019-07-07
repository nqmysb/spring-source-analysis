package com.nqmysb.myproxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.nqmysb.myproxy.proxytools.MyClassLoader;
import com.nqmysb.myproxy.proxytools.MyInvocationHandler;
import com.nqmysb.myproxy.proxytools.MyProxy;

/**
 * 代理类，必须实现JDK中的InvocationHandler  这是JDK动态代理的标志
 * 可以理解：需要实现JDK的代理，必须要这个证书 
 * @author liaocan
 *
 */
public class MyDynamicProxy implements MyInvocationHandler {
	
	private Subject target; //被代理对象的引用  这里是代理对象的接口  说明 该代理类是可以代理该接口下的所有子类的
	
	//动态生成代理对象
	public Object getInstance(Subject target) throws Exception{
		//获取代理对象
		this.target = target;
		//代理的对象必须是 suject的实现类
		Class<? extends Subject> clazz = target.getClass();
		//获取被代理类实现的所有接口  从这里可以看出如果被代理类没有实现接口，是无法使用动态代理的
		Class<?>[] classs = clazz.getInterfaces();
		System.out.println("被代理对象实现的接口:"+Arrays.asList(classs));
		return MyProxy.newProxyInstance(new MyClassLoader(), classs, this);
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
