package com.star.factory.reflect.properties;

import java.util.Properties;

import com.star.factory.Fruit;
import com.star.factory.reflect.Factory;

public class Test {

	public static void main(String[] args) {
		Properties pro = Init.getPro();
		Fruit fruit = Factory.getInstance(pro.getProperty("Banana"));
		fruit.eat();
		Long ll = 11L;
		System.out.println(Long.valueOf(String.valueOf(ll)));
	}
	
}
