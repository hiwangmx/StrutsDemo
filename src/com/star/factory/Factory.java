package com.star.factory;

public class Factory {

	public static Fruit getInstance(String fruit){
		Fruit f = null;
		if("Apple".equals(fruit)){
			f = new Apple();
		}else if("Orange".equals(fruit)){
			f = new Orange();
		}
		return f;
	}
	
}

