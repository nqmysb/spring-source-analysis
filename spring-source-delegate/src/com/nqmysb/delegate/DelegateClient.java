package com.nqmysb.delegate;

/**
 * 委派模式client端
 * 委派模式不属于GOF23种设计模式, 主要角色有三种: 抽象任务角色, 委派者角色, 具体任务角色.
 * 代码实现上和静态代理有点像，但是思想，应用的侧重点是不 一样的
 * 代理模式关注过程，对被代理对象执行任务的过程进行扩展
 * 委派模式关注结果，对外只暴露委派者，具体执行由谁去执行，怎么执行不需要关心，只关心执行后的结果
 * 
 */
public class DelegateClient {

	public static void main(String[] args) {
		
		Delegate delegate = new Delegate();
		
		delegate.doTask();
		
	}
}