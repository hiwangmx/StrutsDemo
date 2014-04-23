package com.star.reflect.test;

public class Person implements China{

	private String name;
	private int age;

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Person(){
		
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(int age){
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.getName() + "," + this.getAge() + "]";
	}

	@Override
	public void sayChina() {
		// TODO Auto-generated method stub
		System.out.println("hello, china");
	}

	@Override
	public void sayHello(String name, int age) {
		// TODO Auto-generated method stub
		System.out.println(this.toString());
	}

}
