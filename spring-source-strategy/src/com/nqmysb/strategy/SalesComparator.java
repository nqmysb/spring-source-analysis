package com.nqmysb.strategy;

import java.util.Comparator;

/**
 * 按照销量排序策略实现类
 * 
 * @author liaocan
 *
 */
public class SalesComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {

		int sales1 = book1.getSales();
		int sales2 = book2.getSales();
		if (sales1 < sales2) {
			return -1;
		} else if (sales1 > sales2) {
			return 1;
		} else {
			return 0;
		}
	}

}
