package com.Car_crud.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "brands")
public class Brand implements Serializable{

	private static final long serialVersionUID = -7141851872196576393L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
		
	
	public Brand(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	public Brand() {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	//1 marca a muchos modelos
//	@OneToMany(mappedBy = "models")
//	private Set<Model> setModels;
}
