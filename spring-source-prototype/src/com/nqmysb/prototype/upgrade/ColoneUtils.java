package com.nqmysb.prototype.upgrade;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * 使用序列化实现对象的深拷贝
 * 
 * 当然，被拷贝的对象必须实现Serializeable接口，否则没办法拷贝的。 
 * 还要注意： 
 * （1）对象的内部属性都是可序列化的
 * （2）方法和属性的特殊修饰符。
 * 
 * @transient 瞬态变量，不进行序列化的变量。
 * 
 * 
 * 
 * 
 * @author liaocan
 *
 * @param <T>
 */
public class ColoneUtils {

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T cloneObj = null;
		try {
			//序列化  
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			
			//将对象序列化
			oos.writeObject(obj);
			
			oos.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			
			ObjectInputStream ois = new ObjectInputStream(bais);
			//反序列化
			cloneObj = (T) ois.readObject();
			
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloneObj;

	}
}
