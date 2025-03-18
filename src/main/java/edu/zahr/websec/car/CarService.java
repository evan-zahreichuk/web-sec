package edu.zahr.websec.car;

/*
@author ivan
@project IntelliJ IDEA
@class CarRestController
@version 1.0.0
@since 18.03.2025 - 22.08
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CarService {
    private final CarRepository carRepository;

    private List<Car> cars;

    @PostConstruct
    void init() {
        cars.add(new Car("1","Audi","Universal","Black"));
        cars.add(new Car("2","BMW","Coupe","White"));
        cars.add(new Car("3","Mercedes","Hatchback","Red"));
        cars.add(new Car("4","Volkswagen","Van","Green"));
        carRepository.saveAll(cars);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(String id) {
        return carRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        carRepository.deleteById(id);
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car car) {
        return carRepository.save(car);
    }
}
