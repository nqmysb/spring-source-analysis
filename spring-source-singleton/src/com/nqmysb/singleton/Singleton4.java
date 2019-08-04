package com.nqmysb.singleton;

/*
 * 懒汉式单例.双重锁检查 DCL，即 double-checked locking 双检锁/双重校验锁
 * 
 * @author liaocan
 */
public class Singleton4 {
	// 1、第一步先将构造方法私有化
	private Singleton4() {
	}

	// 2、然后声明一个静态变量保存单例的引用
	private static Singleton4 single = null;

	// 3、通过提供一个静态方法来获得单例的引用
	// 为了保证多线程环境下的另一种实现方式，双重锁检查
	// 性能，第一次的时候
	public static Singleton4 getInstance() {
		if (single == null) {
			synchronized (Singleton4.class) {
				if (single == null) {
					single = new Singleton4();
				}
			}
		}
		return single;
	}
}
