package com.caresoft.clinicapp;

public class Physician extends User implements HIPAACompliantUser {

	
	public Physician(Integer id) {
		super(id);
	}
	

	@Override
	public boolean assignPin(int pin) {
		if ((pin < 1000) || (pin > 9999)) {
			return false;										
		}
		this.pin = pin;
		return true;
	}


	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id.equals(confirmedAuthID)) {
			return true;
		}
		return false;
	}


}
