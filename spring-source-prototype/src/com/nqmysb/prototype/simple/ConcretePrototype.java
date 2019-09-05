package com.nqmysb.prototype.simple;


import java.util.ArrayList;

public class ConcretePrototype implements Cloneable{

	private int age;

	private String name;
	
	public ArrayList<String> list = new ArrayList<String>();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ConcretePrototype prototype = null;
		try{
			prototype = (ConcretePrototype)super.clone();
			//要调用list的clone()方法 可以实现深拷贝 不然会共用一个list  
			prototype.list = (ArrayList)list.clone();
			
			//克隆基于字节码的
			//用反射，或者循环
		}catch(Exception e){
			
		}
		
		return prototype;
	}

	
	//定义上100个属性
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
