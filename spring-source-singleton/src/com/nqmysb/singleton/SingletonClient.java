package com.nqmysb.singleton;


/**
 * 单例模式client
 * 
 * 单例模式特点：类从始自终只有一个实例
 * 
 * 
 * @author liaocan
 *
 */
public class SingletonClient {
	
	
	public static void main(String[] args) {
		
		//1.饿汉式单例
		Singleton1 singleton11 = Singleton1.getInstance();
		Singleton1 singleton12 = Singleton1.getInstance();
		
		System.out.println("1.两个对象是否相等："+singleton11.equals(singleton12));
		
		//2.懒汉式单例
		Singleton2 singleton21 = Singleton2.getInstance();
		Singleton2 singleton22 = Singleton2.getInstance();
		
		System.out.println("2.两个对象是否相等："+singleton21.equals(singleton22));
		
		//3.懒汉式单例-同步方法
		Singleton3 singleton31 = Singleton3.getInstance();
		Singleton3 singleton32 = Singleton3.getInstance();
		
		System.out.println("3.两个对象是否相等："+singleton31.equals(singleton32));
		
		//4.懒汉式单例-同步代码块
		Singleton4 singleton41 = Singleton4.getInstance();
		Singleton4 singleton42 = Singleton4.getInstance();
		
		System.out.println("4.两个对象是否相等："+singleton41.equals(singleton42));
		
		/*5.静态内部类方式 解决安全和性能问题
		 * 类加载时没有实例化对象，外部类调用内部类时才实例化对象
		 * 3种类加载方式：1，2为动态加载，3为静态加载
		 * 静态加载的时候如果在运行环境中找不到要初始化的类,抛出的是NoClassDefFoundError,它在JAVA的异常体系中是一个Error
		 * 动态加载的时候如果在运行环境中找不到要初始化的类,抛出的是ClassNotFoundException,它在JAVA的异常体系中是一个checked异常
		 * 
		 * 第一种加载方式会初始化类，class.forName实际调用forName0(String name, boolean initialize,ClassLoader loader,Class<?> caller)
		 * boolean initialize参数为true 代表初始化类
		 * 需要依赖类加载初始化类的必须使用Class.forName方式,如JDBC加载驱动
		 * 第三种加载方式也会初始化类，因为new直接实例化
		 * 第二种加载方式不会初始化类，loadClass实际调用loadClass(name, false) fasle代表不连接link
		 * 
		 * 类的装载分为3步：
		 * 加载（loading）：将class文件加载到JVM
		 * 连接（link）：验证class文件规范，默认初始化
		 * 初始化（initialize）：静态代码块，赋值初始化，构造函数
		 * 
		 */
		try {
			//1.class.forName加载类方式 
			Class.forName("com.nqmysb.singleton.Singleton5");
			System.out.println("forName方式加载类");
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
			//2.SingletonClient.class.getClassLoader().loadClass加载类方式
			try {
				Class<?> loadClass = SingletonClient.class.getClassLoader().loadClass("com.nqmysb.singleton.Singleton5");
				System.out.println("loadClass方式加载类: "+loadClass);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
	
			//3. new 方式加载类
			Singleton5 singleton51 = Singleton5.getInstance();
			Singleton5 singleton52 = Singleton5.getInstance();
			
			System.out.println("5.两个对象是否相等："+singleton51.equals(singleton52));
			
			

	}

}
