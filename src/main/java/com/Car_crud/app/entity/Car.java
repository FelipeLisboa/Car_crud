package com.Car_crud.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//se declara como entidad
@Entity
//se declara la tabla cque creara la entidad
@Table(name = "cars")
public class Car implements Serializable{
	
	private static final long serialVersionUID = 804725111299487510L;

	//el atributo se declara como id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//la columna no puede ser nula, largo de 6 y unico
	@Column(nullable = false, length = 6, unique = true)
	private String registration;

	private String color;
	private int year;
	private boolean enabled;	

	public Car(long id, String registration, String color, int year, boolean enabled) {
		super();
		this.id = id;
		this.registration = registration;
		this.color = color;
		this.year = year;
		this.enabled = enabled;
	}

	public Car() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

	//muchos autos a 1 modelo
	@ManyToOne //(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "model")
	Model model;
}
