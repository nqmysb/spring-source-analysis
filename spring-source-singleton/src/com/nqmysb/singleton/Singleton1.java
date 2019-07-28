package com.nqmysb.singleton;

/**
 * 单例模式-饿汉式
 * 
 * @author liaocan
 *
 */
public class Singleton1 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton1 INSTANCE = new Singleton1();

	// 让构造函数为 private，这样该类就不会被实例化
	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		return INSTANCE;
	}
}
