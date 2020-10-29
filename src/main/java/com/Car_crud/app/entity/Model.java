package com.Car_crud.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "models")
public class Model implements Serializable{

	private static final long serialVersionUID = 3486852384305735315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	private String description;
	
	
	public Model(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	public Model() {
		super();
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
//	//relacion 1 modelo a muchos autos
//	@OneToMany(mappedBy = "cars")
//	private Set<Car> setCars;
	
	//relacion muchos modelos a 1 marca
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idBrand")
	Brand brand;
	
}

