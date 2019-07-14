package com.nqmysb.proxy.cglib;

/**
 * CGLIB动态代理测试类
 * 
 * @author liaocan
 *
 */
public class CGLIBDynamicProxyTest {

	public static void main(String[] args) {
		
	try {
		Subject subject = (Subject) new CGLIBDynamicProxy().getInstance(Subject.class);
		subject.businessMethod();
		
		Subject2 subject2 = (Subject2) new CGLIBDynamicProxy().getInstance(Subject2.class);
		subject2.businessMethod();
		/* 输出结果如下：
		 开始代理...
		代理之前做的事情...
		------------
		我是被代理对象的，我正在执行业务操作。。。
		------------
		代理之后做的事情...
		结束代理...
		开始代理...
		代理之前做的事情...
		------------
		我是被代理对象的2，我正在执行业务操作。。。
		------------
		代理之后做的事情...
		结束代理...*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
