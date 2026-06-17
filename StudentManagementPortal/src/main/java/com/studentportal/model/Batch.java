package com.studentportal.model;

public class Batch {
	private int id;
	private String name;
	private String timing;
	private String trainer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public Batch(int id, String name, String timing, String trainer) {
		super();
		this.id = id;
		this.name = name;
		this.timing = timing;
		this.trainer = trainer;
	}
	public Batch(String name, String timing, String trainer) {
		super();
		this.name = name;
		this.timing = timing;
		this.trainer = trainer;
	}
	public Batch() {
		super();
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", timing=" + timing + ", trainer=" + trainer + "]";
	}
	
	

}
