package com.star.reflect.invocation;

//真实项目
public class RealSubject implements Subject{

	@Override
	public String say(String name, int age) {
		// TODO Auto-generated method stub
		return name + " " + age;
	}

}
