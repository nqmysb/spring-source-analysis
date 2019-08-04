package com.nqmysb.strategy;

public class Book {

	/**
	 * 书名
	 */
	private String name;

	/**
	 * 价格
	 */
	private double price;

	/**
	 * 销量
	 */
	private int sales;

	public Book(String name, double price, int sales) {
		this.name = name;
		this.price = price;
		this.sales = sales;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override

	public String toString() {

		return "Book [书名=" + name + ", 价格=" + price + ", 销量=" + sales + "]";

	}

}
