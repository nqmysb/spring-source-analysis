package com.nqmysb.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 策略模式client
 * 
 * @author liaocan
 *
 */
public class StrategyClient {
	public static void main(String[] args) {

		/**
		 * java中的 arrays collections 的排序就使用了策略模式 针对不同的排序对象，采用不同的排序策略
		 * 例如：Collections.sort(list,comparator) 传入需要排序的对象和排序的策略 它底层实现其实时
		 * 调用this.sort(comparator) 然后将list转为数组然后 调用数组排序工具类Arrays.sort(a,
		 * (Comparator) comparator) Object[] a = this.toArray(); Arrays.sort(a,
		 * (Comparator) comparator);
		 */

		// 推荐几本书
		Book book1 = new Book("Java工程师修炼之道", 61.40, 83000);
		Book book2 = new Book("揭秘Java虚拟机：JVM设计原理与实现", 105.40, 103000);
		Book book3 = new Book("Spring+MyBatis企业应用实战", 47.60, 14000);
		Book book4 = new Book("亿级流量网站架构核心技术：跟开涛学搭建高可用高并发系统", 68.3, 82000);
		Book book5 = new Book("轻量级Java EE企业应用实战", 88.40, 18000);

		// 书架
		List<Book> bookList = new ArrayList<Book>();

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		
		/**
		 * 我们根据不同的需求采用不同的策略来对书进行排序
		 * 价格和销量
		 */
		// 按价格排序
		Collections.sort(bookList, new PriceComparator());
		
		/*
		 * 按价格排序[ 
		 * Book [书名=Spring+MyBatis企业应用实战, 价格=47.6, 销量=14000], 
		 * Book [书名=Java工程师修炼之道, 价格=61.4, 销量=83000], 
		 * Book [书名=亿级流量网站架构核心技术：跟开涛学搭建高可用高并发系统, 价格=68.3, 销量=82000], 
		 * Book [书名=轻量级JavaEE企业应用实战, 价格=88.4, 销量=18000], 
		 * Book [书名=揭秘Java虚拟机：JVM设计原理与实现,价格=105.4, 销量=103000] 
		 * ]
		 */
		System.out.println("按价格排序" + bookList.toString());
		//按价格排序[Ljava.lang.Object;@15db9742
		System.out.println("按价格排序" + bookList.toArray());

		// 按销量排序
		Collections.sort(bookList, new SalesComparator());

		System.out.println("按销量排序" + bookList);
		/*	按销量排序[
		      Book [书名=Spring+MyBatis企业应用实战, 价格=47.6, 销量=14000], 
		      Book [书名=轻量级Java EE企业应用实战, 价格=88.4, 销量=18000], 
		      Book [书名=亿级流量网站架构核心技术：跟开涛学搭建高可用高并发系统, 价格=68.3, 销量=82000], 
		      Book [书名=Java工程师修炼之道, 价格=61.4, 销量=83000], 
		      Book [书名=揭秘Java虚拟机：JVM设计原理与实现, 价格=105.4, 销量=103000]
		 ]*/
		System.out.println("按销量排序" + bookList.toString());
		//按销量排序[Ljava.lang.Object;@6d06d69c
		System.out.println("按销量排序" + bookList.toArray());

	}
}
