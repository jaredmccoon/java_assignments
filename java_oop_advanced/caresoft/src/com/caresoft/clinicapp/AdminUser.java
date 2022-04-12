package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	private ArrayList<String> securityIncidents;
	

	public AdminUser(Integer id, String role) {
		super(id);
		securityIncidents = new ArrayList<String>();
	}
	

	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000) {
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
		this.authIncident();
		return false;
	}
	
	

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
	
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %d\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	

}
