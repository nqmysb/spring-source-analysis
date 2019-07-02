package com.nqmysb.myproxy.proxytools;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/**
 * 自己实现的Proxy  对应JDK中的java.lang.reflect.Proxy类
 * 
 * @author liaocan
 *
 */
public class MyProxy {
	
	//换行符
	private static String ln = "\r\n";


	/**
	 * 生成代理类对象  
	 *  对应JDK中Proxy的newProxyInstance方法生成代理类对象
	 *  JDK1.8中的实现是：通过Proxy 中的的静态内部类ProxyClassFactory =>(private static final class ProxyClassFactory)中的apply方法
	 *  注意：JDK1.7中是通过getProxyClass()方法实现 有点小区别 但是核心代码大致相同
	 *  核心代码如下：
	 *      //所有代理类的前缀
	 *  	private static final String proxyClassNamePrefix = "$Proxy";
	 *      //代理类的序号
	 *      long num = nextUniqueNumber.getAndIncrement();
	 *      //代理类的全名
     *      String proxyName = proxyPkg + proxyClassNamePrefix + num;
     *      //生成代理类class字节码文件 ,反编译生成的class文件可以发现代理类继承Proxy类实现了被代理类的implements的所有接口 =>(public final class $Proxy0 extends Proxy  implements Subject ) 
     *      //generateProxyClass()可以再看看具体实现
     *      byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces, accessFlags);
     *      try {
     *      //根据class字节码生成实例对象
     *          return defineClass0(loader, proxyName,proxyClassFile, 0, proxyClassFile.length);
     *         } 
     *          
	 * @param classLoader
	 * @param interfaces
	 * @param myInvocationHandler
	 * @return
	 */
	public static Object newProxyInstance(MyClassLoader classLoader,Class<?>[] interfaces,MyInvocationHandler myInvocationHandler){
		
		
		try{
			//1、生成源代码
			String proxySrc = generateSrc(interfaces[0]);
			
			
			//2、将生成的源代码输出到磁盘，保存为.java文件
			String filePath = MyProxy.class.getResource("").getPath();
			File f = new File(filePath + "$Proxy0.java");
			FileWriter fw = new FileWriter(f);
			fw.write(proxySrc);
			fw.flush();
			fw.close();
		
			//3、编译源代码，并且生成.class文件
			JavaCompiler  compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);
			
			CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
		
			//4.将class文件中的内容，动态加载到JVM中来
			
			//5.返回被代理后的代理对象
			Class<?> proxyClass = classLoader.findClass("$Proxy0");
			Constructor<?> c = proxyClass.getConstructor(MyInvocationHandler.class);
			f.delete();
			
			return c.newInstance(myInvocationHandler);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/**
	 * 
	 * 动态生成代理类的.java文件的代码内容
	 * @param interfaces
	 * @return
	 */
	private static String generateSrc(Class<?> interfaces){
		StringBuffer src = new StringBuffer();
		//代理类包名
		src.append("package com.nqmysb.myproxy.proxytools;" + ln);
		//导入反射包method类  
		src.append("import java.lang.reflect.Method;" + ln);
		//声明类名 实现被代理类的接口这里简化处理只实现一个接口, JDK中生成的代理类会继承proxy类 实现被代理类的所有接口
		src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
		//生成代理类中持有MyInvocationHandler引用
		//JDK中InvocationHandler是Proxy中的成员变量=>(protected InvocationHandler h;)
		//生成的代理类继承Proxy也继承了它的protected的成员变量,我们自己生成的代理类没有继承Proxy 所有需要自己提供
		src.append("MyInvocationHandler h;" + ln);
		//代理类中构造方法中传入MyInvocationHandler给InvocationHandler初始化
		src.append("public $Proxy0(MyInvocationHandler h) {" + ln);
		src.append("this.h = h;" + ln);
		src.append("}" + ln);
		//生成所有代理方法
		for (Method m : interfaces.getMethods()) {
			src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
			src.append("try{" + ln);
			//通过代理方法对象
			src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
			//调用代理方法
			src.append("this.h.invoke(this,m,null);" + ln);
			src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
			src.append("}" + ln);
		}
		
		src.append("}");
		System.out.println("动态生成的代理类$Proxy0:"+ln+src);
		/*
		生成代理类如下：
		package com.nqmysb.myproxy.proxytools;
		
		import java.lang.reflect.Method;
		
		public class $Proxy0 implements com.nqmysb.myproxy.Subject{
		
		MyInvocationHandler h;
		
		public $Proxy0(MyInvocationHandler h) {
			this.h = h;
		}
		
		public void businessMethod(){
		try{
			
				Method m = com.nqmysb.myproxy.Subject.class.getMethod("businessMethod",new Class[]{});
				//此处调用的其实就是传入的com.nqmysb.myproxy.MyDynamicProxy对象的invoke方法
				//然后再在invoke中对代理对象的方法前后进行业务方法操作
				this.h.invoke(this,m,null);
				
				}catch(Throwable e){
				e.printStackTrace();
				}
			}
		}
		*/
		return src.toString();
	}

}
