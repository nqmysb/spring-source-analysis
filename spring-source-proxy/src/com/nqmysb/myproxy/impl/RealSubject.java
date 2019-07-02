package com.nqmysb.myproxy.impl;

import com.nqmysb.myproxy.Subject;

/**
 * 具体的目标对象，实现目标接口的方法
 * @author liaocan
 *
 */
public class RealSubject implements Subject {

	@Override
	public void businessMethod() {
		System.out.println("我在进行具体的业务操作。。。。。。");
	}

}
