package com.nqmysb.singleton;

/*
 * 懒汉式单例类.在第一次调用的时候实例化自己  存在线程安全问题 如何测试？
 * 
 * @author liaocan
 */
public class Singleton2 {
	// 1、第一步先将构造方法私有化
	private Singleton2() {
	}

	// 2、然后声明一个静态变量保存单例的引用
	private static Singleton2 single = null;

	// 3、通过提供一个静态方法来获得单例的引用
	// 不安全的
	public static Singleton2 getInstance() {
		if (single == null) {
			single = new Singleton2();
		}
		return single;
	}
}
