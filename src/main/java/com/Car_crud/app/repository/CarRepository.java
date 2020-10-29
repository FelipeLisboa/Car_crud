package com.Car_crud.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Car_crud.app.entity.Car;
import com.Car_crud.app.entity.Model;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	public Optional<Car> findByRegistration(String registration);
	public List<Car> findByColor(String color);
	public List<Car> findByYear(int year);
	public List<Car> findByEnabled(boolean enabled);
	public List<Car> findByModel(Model model);
}
