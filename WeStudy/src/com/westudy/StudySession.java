package com.westudy;

import java.util.Date;

public class StudySession {

	private Date sessionDate;
	private String name;
	private String title;
	private String description;
	private String locat;
	private double locX;
	private double locY;
	
	public StudySession(Date d, String n, String t, String l, String desc, double x, double y) {
		sessionDate = d;
		name = n;
		title = t;
		description = desc;
		locX = x;
		locY = y;
		locat = l;
	}
	public String toString() {
		return ("Name: " + name + "\n"
				+ "Location: " + locat + "\n"
				+ "Title: " + title + "\n"
				+ "Description: " + description + "\n" 
				+ "Date: " + sessionDate + "\n"
				+ "Coordinates: " + locX + " " + locY + "\n");
	}
	public String getLocat() {
		return locat;
	}

	public void setLocat(String locat) {
		this.locat = locat;
	}

	public Date getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLocX() {
		return locX;
	}

	public void setLocX(double locX) {
		this.locX = locX;
	}

	public double getLocY() {
		return locY;
	}

	public void setLocY(double locY) {
		this.locY = locY;
	}

	
	
}
