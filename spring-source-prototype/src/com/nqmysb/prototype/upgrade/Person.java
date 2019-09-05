package com.nqmysb.prototype.upgrade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.nqmysb.prototype.simple.ConcretePrototype;

public class Person implements Serializable ,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String age;
	
	private Date birthday;

	private ArrayList<Person> sons ;
	
	
	
	protected Person clone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public ArrayList<Person> getSons() {
		return sons;
	}


	public void setSons(ArrayList<Person> sons) {
		this.sons = sons;
	}

}
