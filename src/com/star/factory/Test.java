package com.star.factory;

public class Test {

	public static void main(String[] args) {
		Fruit f = Factory.getInstance("Orange");
		f.eat();
	}
	
}
