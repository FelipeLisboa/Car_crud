package com.Car_crud.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Car_crud.app.entity.Car;
import com.Car_crud.app.entity.Model;
import com.Car_crud.app.repository.CarRepository;

@Service
public class CarServiceImplement implements CarService{
	
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Optional<Car> findById(Long id) {
		return carRepository.findById(id);
	}

	@Override
	public Optional<Car> findByRegistration(String registration) {
		return carRepository.findByRegistration(registration);
	}

	@Override
	public List<Car> findByColor(String color) {
		return carRepository.findByColor(color);
	}

	@Override
	public List<Car> findByYear(int year) {
		return carRepository.findByYear(year);
	}

	@Override
	public List<Car> findByEnabled(boolean enabled) {
		return carRepository.findByEnabled(enabled);
	}

	@Override
	public List<Car> findByModel(Model model) {
		return carRepository.findByModel(model);
	}
	
	@Override
	public Iterable<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		carRepository.deleteById(id);
	}
	
	


}
