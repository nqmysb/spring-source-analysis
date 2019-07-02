package com.nqmysb.proxy.jdk;

import java.io.FileOutputStream;

import com.nqmysb.proxy.jdk.impl.RealSubject;

import sun.misc.ProxyGenerator;

public class DynamicProxyTest {

	public static void main(String[] args) {
		
	try {
			
//			
			Subject subject = (Subject)new DynamicProxy().getInstance(new RealSubject());
			System.out.println(subject.getClass());
			subject.businessMethod();
			
			//JDK代理的原理：
			//1.拿到被代理对象的引用，然后获取它的接口
			//2.JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
			//3.把被代理对象的引用也拿到了
			//4.重新动态生成一个class字节码
			//5.然后编译
			
			//获取字节码内容        需要修改JDK 路径不能用默认JDK 不然没有ProxyGenerator这个包 
			//动态生成代理class字节码文件
			byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Subject.class});
			FileOutputStream os = new FileOutputStream("C:/Users/liaocan/Desktop/$Proxy0.class");
			os.write(data);
			os.close();
			
			
			byte[] data1 = ProxyGenerator.generateProxyClass("$Proxy1", new Class[]{RealSubject.class,Subject.class});
			FileOutputStream os1 = new FileOutputStream("C:/Users/liaocan/Desktop/$Proxy1.class");
			os1.write(data1);
			os1.close();
			//是什么?
			//为什么？
			//怎么做？
			
			//手写一个
//			Person obj = (Person)new GPMeipo().getInstance(new XiaoXingxing());
//			System.out.println(obj.getClass());
//			obj.findLove();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
