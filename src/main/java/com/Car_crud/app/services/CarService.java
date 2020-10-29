package com.Car_crud.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Car_crud.app.entity.Car;
import com.Car_crud.app.entity.Model;

public interface CarService {
	
	public Car save(Car car);
	
	public Optional<Car> findById(Long id);
	
	public Optional<Car> findByRegistration(String registration);
	
	public List<Car> findByColor(String color);
	
	public List<Car> findByYear(int year);
	
	public List<Car> findByEnabled(boolean enabled);
	
	public List<Car> findByModel(Model model);

	public Iterable<Car> findAll();

	public void deleteById(Long id);

}
