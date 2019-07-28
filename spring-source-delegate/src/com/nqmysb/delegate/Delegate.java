package com.nqmysb.delegate;

import java.util.Random;

/**
 * 委派者角色
 */
public class Delegate implements Task{
	
    public void doTask() {
 
        Task task = null;
        if (new Random().nextBoolean()){
        task = new ConcreteTaskA();
        task.doTask();
        }else{
            task = new ConcreteTaskB();
            task.doTask();
        }

    }
}