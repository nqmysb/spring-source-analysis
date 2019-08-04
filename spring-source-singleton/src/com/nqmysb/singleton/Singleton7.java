package com.nqmysb.singleton;

/*
 * 枚举类方式单例
 * 线程安全 防止反射攻击和序列化问题  effective java作者Joshua Bloch 推荐方式
 * 通过对Singleton的序列化与反序列化得到的对象是一个新的对象，这就破坏了Singleton的单例性。
 * 反序列化时会利用反射生成新的对象
 * @author liaocan 
 */
public enum Singleton7 {
	INSTANCE;
	public Singleton7 getInstance() {
		return INSTANCE;
	}
}
