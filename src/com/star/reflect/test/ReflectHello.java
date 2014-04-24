package com.star.reflect.test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectHello {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		ReflectHello reflectHello = new ReflectHello();
		//获取方法名（包括包名）
		System.out.println(reflectHello.getClass().getName());
		
		//所有类的对象其实都是Class的实例。
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		demo1 = Class.forName("com.star.reflect.test.ReflectHello");
		demo2 = ReflectHello.class;
		demo3 = new ReflectHello().getClass();
		System.out.println(demo1.getName());
		System.out.println(demo2.getName());
		System.out.println(demo3.getName());
		
		Class<?> person = Class.forName("com.star.reflect.test.Person");
		//构造方法
		Constructor<?>[] cons =  person.getConstructors();
		System.out.println(cons.length);
		for(Constructor<?> con : cons){
			System.out.println(con);
			if(con.getParameterTypes().length == 0){
				Person person2 = (Person) con.newInstance();
				System.out.println(person2.toString());
			}else if(con.getParameterTypes().length == 1){
				if(con.getParameterTypes()[0].getName().endsWith("String")){
					Person person3 = (Person) con.newInstance("we");
					System.out.println(person3.toString());
				}else if(con.getParameterTypes()[0].getName().endsWith("int")){
					Person person4 = (Person) con.newInstance(23);
					System.out.println(person4.toString());
				}
			}else{
				Person person1 = (Person) con.newInstance("haha", 22);
				System.out.println(person1.toString());
			}
		}
		
		//实现的接口 可以有多个
		Class<?>[] inter = person.getInterfaces();
		for(Class<?> clazz : inter){
			System.out.println(clazz.getName());
		}
		
		//父类 只有一个
		Class<?> superClazz = person.getSuperclass();
		System.out.println(superClazz.getName());
		
		//构造方法 + 修饰符
		for(Constructor<?> con : cons){
			int m = con.getModifiers(); //取修饰符
			System.out.print(Modifier.toString(m) + " ");
			System.out.print(con.getName() + "(");
			Class<?>[] parameters = con.getParameterTypes();
			for(Class<?> clazz : parameters){
				System.out.print(clazz.getName()+ ",");
			}
			System.out.println(")");
		}
		
		//方法
		Method[] method = person.getMethods();
		for(int i = 0;i<method.length;i++){
			int m = method[i].getModifiers();
			System.out.print(Modifier.toString(m) + " ");
			System.out.print(method[i].getName() + "(");
			Class<?>[] ps = method[i].getParameterTypes();
			for(int j = 0;j<ps.length;j++){
				System.out.print(ps[j].getName());
				if(j < ps.length - 1){
					System.out.print(",");
				}
			}
			System.out.print(") ");
			Class<?>[] et = method[i].getExceptionTypes();
			for(int j = 0;j<et.length;j++){
				System.out.print("throws" + et[j].getName());
				if(j < ps.length - 1){
					System.out.print(",");
				}
			}
			System.out.println();
		}
		
		//属性
		System.out.println("-------本类属性-----");
		Field[] field = person.getDeclaredFields();
		for(Field f : field){
			int mod = f.getModifiers();
			System.out.print(Modifier.toString(mod));
			Class<?> type = f.getType();
			System.out.println( " " + type.getName() + " " + f.getName());
		}
		System.out.println("-------父类或接口属性-----");
		Field[] field1 = person.getFields();
		for(Field f : field1){
			int mod = f.getModifiers();
			System.out.print(Modifier.toString(mod));
			Class<?> type = f.getType();
			System.out.println( " " + type.getName() + " " + f.getName());
		}
		
		//调用类的方法
		Method sayChina = person.getMethod("sayChina");
		sayChina.invoke(person.newInstance());
		Method sayHello = person.getMethod("sayHello", String.class, int.class);
		sayHello.invoke(person.newInstance(), "ss", 33);
		
		//set 和 get 方法
		Person person1 = (Person) person.newInstance();
		setter(person1, "Name", "ss", String.class);
		System.out.println(getter(person1, "Name"));
		
		//属性值
		person1 = (Person) person.newInstance();
		Field field2 = person.getDeclaredField("name");
		field2.setAccessible(true);
		field2.set(person1, "adf");
		System.out.println(field2.get(person1));
		
		//修改数组值
		int[] temp = {1, 2, 3, 4};
		Class<?> arrayClass = temp.getClass().getComponentType();
		System.out.println("数组类型：" + arrayClass.getName());
		System.out.println("数组长度：" + Array.getLength(temp));
		System.out.println("第一个值：" + Array.get(temp, 0));
		Array.set(temp, 0, 100);
		System.out.println("修改之后第一个值：" + Array.get(temp, 0));
		
		//数组
		int[] temp1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] newTemp1 = (int[]) arrayInc(temp1, 3);
		print(newTemp1);
		char[] c = {'a', 'b', 'c'};
		char[] newC = (char[]) arrayInc(c, 5);
		print(newC);
		  
	}
	
	public static void setter(Object obj, String attr, Object value, Class<?> type) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = obj.getClass().getMethod("set" + attr, type);
		method.invoke(obj, value);
	}
	
	public static Object getter(Object obj, String attr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = obj.getClass().getMethod("get" + attr);
		Object returnObj = method.invoke(obj);
		return returnObj;
	}
	
	public static Object arrayInc(Object obj, int len){
		Class<?> objClass = obj.getClass().getComponentType();
		Object newObj = Array.newInstance(objClass, len);
		int co = Array.getLength(obj);
		if(co > len){
			System.arraycopy(obj, 0, newObj, 0, len);
		}else{
			System.arraycopy(obj, 0, newObj, 0, co);
		}
		return newObj;
	}
	
	public static void print(Object obj){
		Class<?> clazz = obj.getClass();
		if(!clazz.isArray()){
			System.out.println("不是数组");
		}else{
			System.out.println("数组长度：" + Array.getLength(obj));
			for(int i = 0;i<Array.getLength(obj); i++){
				System.out.print(Array.get(obj, i) + " ");
			}
			System.out.println();
		}
	}
	
}
