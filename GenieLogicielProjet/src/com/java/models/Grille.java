package com.java.models;

public class Grille {
	private int id;
	private int date;
	
	public Grille() {
		// TODO Auto-generated constructor stub
	}

	public Grille(int id, int date) {
		super();
		this.id = id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Grille [id=" + id + ", date=" + date + "]";
	}
	
}
