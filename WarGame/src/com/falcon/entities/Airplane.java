package com.falcon.entities;

public class Airplane {
	private String type;
	private int crew;
	private String weapons;
	private boolean radar;
	private double autonomy;
	private double fuel;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	public boolean isRadar() {
		return radar;
	}

	public void setRadar(boolean radar) {
		this.radar = radar;
	}

	public double getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(double autonomy) {
		this.autonomy = autonomy;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
}
