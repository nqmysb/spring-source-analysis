package com.nqmysb.prototype.upgrade;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class ColoneUtilsTest {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person zhangsan = new Person();
		zhangsan.setAge("36");
		zhangsan.setName("张三");
		zhangsan.setBirthday(new Date());

		Person zhangsi = new Person();
		zhangsi.setAge("12");
		zhangsi.setName("张四");
		zhangsi.setBirthday(new Date());

		Person zhangwu = new Person();
		zhangwu.setAge("13");
		zhangwu.setName("张五");
		zhangwu.setBirthday(new Date());

		ArrayList<Person> sons = new ArrayList<Person>();

		sons.add(zhangsi);
		sons.add(zhangwu);
		zhangsan.setSons(sons);

		//深拷贝
		Person clonezhangsan1 = ColoneUtils.clone(zhangsan);
		//浅拷贝
		Person clonezhangsan2 =  zhangsan.clone();
		
		System.out.println("姓名：" + zhangsan.getName() + "年龄：" + zhangsan.getAge() + "生日：" +zhangsan.getBirthday()+ zhangsan.getName() + "儿子们："
				+ zhangsan.getSons().stream().map(person -> person.getName()).collect(Collectors.toList()).toString()+zhangsan.getSons());
		
		System.out.println("姓名：" + clonezhangsan1.getName() + "年龄：" + clonezhangsan1.getAge() + "生日：" +clonezhangsan1.getBirthday()+ clonezhangsan1.getName() + "儿子们："
				+ clonezhangsan1.getSons().stream().map(person -> person.getName()).collect(Collectors.toList()).toString()+clonezhangsan1.getSons());
		
		System.out.println("姓名：" + clonezhangsan2.getName() + "年龄：" + clonezhangsan2.getAge() + "生日：" +clonezhangsan2.getBirthday()+ clonezhangsan2.getName() + "儿子们："
				+ clonezhangsan2.getSons().stream().map(person -> person.getName()).collect(Collectors.toList()).toString()+clonezhangsan2.getSons());
	
/*		
 		姓名：张三年龄：36生日：Thu Sep 05 22:52:00 CST 2019张三儿子们：[张四, 张五]
 		[com.nqmysb.prototype.upgrade.Person@41629346, com.nqmysb.prototype.upgrade.Person@404b9385]
 		
		姓名：张三年龄：36生日：Thu Sep 05 22:52:00 CST 2019张三儿子们：[张四, 张五]
		[com.nqmysb.prototype.upgrade.Person@4e50df2e, com.nqmysb.prototype.upgrade.Person@1d81eb93]
		
		姓名：张三年龄：36生日：Thu Sep 05 22:52:00 CST 2019张三儿子们：[张四, 张五]
		[com.nqmysb.prototype.upgrade.Person@41629346, com.nqmysb.prototype.upgrade.Person@404b9385]
		
		可以看出第一个跟第三个的地址值是相同的说明clone方法只是拷贝引用，没有拷贝内存
		第二个是完全拷贝了新的对象，地址值改变了
*/
	
	
	}
	
	


}
