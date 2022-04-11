package com.zookeeper.sts;

public class Gorilla extends Mammal {
	public int throwSomething() {
		System.out.println("Harambe threw something");
		return energyLevel -= 5;
	}
	public int eatBananas() {
		System.out.println("Harambe is satisfied");
		return energyLevel += 10;
	}
	public int climb() {
		System.out.println("Harambe has climbed a tree");
		return energyLevel -= 10;
	}
}
