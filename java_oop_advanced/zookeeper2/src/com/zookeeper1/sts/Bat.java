package com.zookeeper1.sts;

public class Bat {
	int energyLevel = 300;
    public int fly() {
        System.out.println("fly");
        return energyLevel -= 50;
    }
    public int eatHumans() {
        return energyLevel += 50;
    }
    public int attackTown() {
        System.out.println("attacktown");
        return energyLevel -= 100;  
    }
}
