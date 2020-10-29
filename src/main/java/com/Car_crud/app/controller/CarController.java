package com.Car_crud.app.controller;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Car_crud.app.entity.Car;
import com.Car_crud.app.services.CarService;
import java.util.List;
@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	//create
	@PostMapping
	//clase responseEntity para devolver un obeto tipo usuario
	public ResponseEntity<?> create (@RequestBody Car car){
		return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
	}
	
	//read by id
	@GetMapping("/{id}")
	public ResponseEntity<?> readById (@PathVariable Long id){
		Optional<Car> oCar = carService.findById(id);
				
		if(!oCar.isPresent()) {
			//404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
		//200 todo ok
		return ResponseEntity.ok(oCar);
	}
	
	//read by registration
	@GetMapping("getregistration/{registration}")
	public ResponseEntity<?> readByRegistration (@PathVariable String registration){
		Optional<Car> oCar = carService.findByRegistration(registration);
				
		if(!oCar.isPresent()) {
			//404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
		//200 todo ok
		return ResponseEntity.ok(oCar);
	}
	
//	//read by brand
//	@GetMapping("getbrand/{brand}")
//	public ResponseEntity<?> readByBrand (@PathVariable String brand){
//		List<Car> oCar = carService.findByBrand(brand);
//				
//		if(oCar.isEmpty()) {
//			//404 si no lo encuentra
//			return ResponseEntity.notFound().build();
//		}
//		//200 todo ok
//		return ResponseEntity.ok(oCar);
//	}
//	
//	//read by model
//	@GetMapping("getmodel/{model}")
//	public ResponseEntity<?> readByModel (@PathVariable String model){
//		List<Car> oCar = carService.findByModel(model);
//				
//		if(oCar.isEmpty()) {
//			//404 si no lo encuentra
//			return ResponseEntity.notFound().build();
//		}
//		//200 todo ok
//		return ResponseEntity.ok(oCar);
//	}

	//read by color
	@GetMapping("getcolor/{color}")
	public ResponseEntity<?> readByColor (@PathVariable String color){
		List<Car> oCar = carService.findByColor(color);
				
		if(oCar.isEmpty()) {
			//404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
		//200 todo ok
		return ResponseEntity.ok(oCar);
	}
	
	//read by year
	@GetMapping("getyear/{year}")
	public ResponseEntity<?> readByYear (@PathVariable int year){
		List<Car> oCar = carService.findByYear(year);
				
		if(oCar.isEmpty()) {
			//404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
		//200 todo ok
		return ResponseEntity.ok(oCar);
	}
	
	//read by enabled
	@GetMapping("getenabled/{enabled}")
	public ResponseEntity<?> readByEnabled (@PathVariable boolean enabled){
		List<Car> oCar = carService.findByEnabled(enabled);
				
		if(oCar.isEmpty()) {
			//404 si no lo encuentra
			return ResponseEntity.notFound().build();
		}
		//200 todo ok
		return ResponseEntity.ok(oCar);
	}
	
	//read all
	@GetMapping
	//lista tipo Car java api 8 stream
	public List<Car> readAll (){
		List<Car> cars = StreamSupport
				.stream(carService.findAll().spliterator(), false) //encontrar el iterable, recorrer de manera secuencial
				.collect(Collectors.toList()); //convertir la coleccion de todos los registros en una lista
		
		return cars;//devuelve la lista completa
	}
	
//	//update putmapping("/{id}")
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update (@RequestBody Car carDetails, @PathVariable Long id){
//		Optional<Car> oCar = carService.findById(id);
//		
//		if(!oCar.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		oCar.get().setRegistration(carDetails.getRegistration());
//		oCar.get().setBrand(carDetails.getBrand());
//		oCar.get().setModel(carDetails.getModel());
//		oCar.get().setColor(carDetails.getColor());
//		oCar.get().setYear(carDetails.getYear());
//		oCar.get().setEnabled(carDetails.getEnabled());
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(oCar.get()));		
//	}
	
	//delete deletemapping("/{id}")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		if(!carService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		carService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	

}
