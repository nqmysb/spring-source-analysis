package com.nqmysb.myproxy;

import com.nqmysb.myproxy.impl.RealSubject;

/**
 * 手写JDK动态代理Client类
 * 
 * 
 * @author liaocan
 *
 */
public class MyDynamicProxyClient {

	public static void main(String[] args) {
		
	try {
			
			Subject subject = (Subject)new MyDynamicProxy().getInstance(new RealSubject());
			System.out.println(subject.getClass());
			subject.businessMethod();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
