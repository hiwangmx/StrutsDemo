package com.star.reflect.invocation;

public class Hello {

	public static void main(String[] args) {
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		Subject sub = (Subject) myInvocationHandler.bind(new RealSubject());
		String str = sub.say("是的", 11);
		System.out.println(str);
	}
	
}
