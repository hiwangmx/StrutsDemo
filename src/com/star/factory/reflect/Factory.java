package com.star.factory.reflect;

import com.star.factory.Fruit;

public class Factory {

	public static Fruit getInstance(String fruitName) {
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(fruitName).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruit;
	}
	
}
