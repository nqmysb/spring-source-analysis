package com.nqmysb.myproxy.proxytools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


/**
 * 自定义类加载器
 * 
 * 作用：将我们动态生成的class文件生成class对象加载JVM内存中
 * @author liaocan
 *
 */
public class MyClassLoader extends ClassLoader{
	
	private File baseDir;
	
	public MyClassLoader(){
		
		Class<MyClassLoader> clazz = MyClassLoader.class;
		String basePath = clazz.getResource("").getPath();
//		String basePath = clazz.getResource("/").getPath() +"com/nqmysb/myproxy/proxytools";
		this.baseDir = new java.io.File(basePath);
	}
	/**
	 * 自定义类加载方法 ，加载自定义类
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//获取需要加载的类的全名  com.nqmysb.myproxy.proxytools.$Proxy0
		String className = MyClassLoader.class.getPackage().getName() + "." + name;
		if(baseDir != null){
			//获取 class文件对象 E:\workspace\spring-source-analysis\spring-source-proxy\bin\com\nqmysb\myproxy\proxytools\$Proxy0.class
			File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
			if(classFile.exists()){
				FileInputStream in = null;
				ByteArrayOutputStream out = null;
				try{
					in = new FileInputStream(classFile);
					out = new ByteArrayOutputStream();
					byte [] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
					//根据class文件和类名生成class对象 并加载到JVM中
					return defineClass(className, out.toByteArray(), 0,out.size());
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(null != in){
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(null != out){
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					//删除Class文件
					classFile.delete();
				}
				
			}
		}
		
		return null;
	}
	
	/**
	 * 测试了解Java类加载机制
	 * 1.类加载器的作用：类加载器负责将class文件读入JVM内存，并为之生成对应的java.lang.Class对象。
	 * java类加载器分为三类：
	 * （Bootstrap ClassLoader） 启动类加载器 ： 负责加载Java的核心类（如String、System等）, rt.jar
	 * 							它比较特殊，因为它是由原生C++代码实现的，并不是java.lang.ClassLoader的子类
	 * （Extension ClassLoader ）扩展类加载器：它负责加载JRE的扩展目录（%JAVA_HOME%/jre/lib/ext）中JAR包的类，java实现
	 * 							我们可以通过把自己开发的类打包成JAR文件放入扩展目录来为Java扩展核心类以外的新功能。
	 * （ApplicationClassLoader）应用程序类加载器：它负责在JVM启动时加载来自Java命令的-classpath选项、java.class.path系统属性，java实现
	 * 							或CLASSPATH环境变量所指定的JAR包和类路径。程序可以通过ClassLoader的静态方法getSystemClassLoader来获取系统类加载器：
	 * 
	 * 类加载机制之双亲委派
	 *        加载类时 会现递归交于父类加载器加载，如果所有父类没有加载才有自己加载，好处防止类的重复加载
	 * 
	 */
	
	public static void main(String[] args) {
		//（Bootstrap ClassLoader） 启动类加载器 ： 负责加载Java的核心类（如String、System等）rt.jar
		//它比较特殊，因为它是由原生C++代码实现的，并不是java.lang.ClassLoader的子类 所以输出结果为null
		//Returns the class loader for the class.  Some implementations may use
		//null to represent the bootstrap class loader. This method will return
		//null in such implementations if this class was loaded by the bootstrap
		//class loader.
		System.out.println(String.class.getClassLoader());
		System.out.println(HashMap.class.getClassLoader());
		
		//sun.misc.Launcher$AppClassLoader
		System.out.println(MyClassLoader.class.getClassLoader().getClass().getName());

		//sun.misc.Launcher$AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

		
		
	}

}
