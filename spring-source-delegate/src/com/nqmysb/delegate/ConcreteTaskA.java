package com.nqmysb.delegate;

/**
 * 任务类ConcreteTaskA
 * 
 * @author liaocan
 *
 */
public class ConcreteTaskA implements Task {
	public void doTask() {
		System.out.println("具体执行者A");
	}
}