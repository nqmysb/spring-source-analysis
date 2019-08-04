package com.nqmysb.strategy;

import java.util.Comparator;

/**
 * 按照价格排序策略实现类
 * @author liaocan
 *
 */
public class PriceComparator implements Comparator<Book> {

	
	/**
	 * @return a negative integer, zero, or a positive integer as the
	 *         first argument is less than, equal to, or greater than
	 *         the second.
	 */
	@Override
	public int compare(Book book1, Book book2) {

		double price1 = book1.getPrice();
		double price2 = book2.getPrice();
		if (price1 < price2) {
			return -1;
		} else if (price1 > price2) {
			return 1;
		} else {
			return 0;
		}
	}

}
