package com.star.factory.reflect;

import com.star.factory.Fruit;

public class Test {

	public static void main(String[] args) {
		Fruit fruit = Factory.getInstance("com.star.factory.Orange");
		fruit.eat();
	}
	
}
