package edu.zahr.websec.car;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@author ivan
@project IntelliJ IDEA 
@class CarRestController
@version 1.0.0 
@since 18.03.2025 - 22.12
*/

@RestController
@RequestMapping("/api/v1/items")
@AllArgsConstructor

public class CarRestController {

    private final CarService service;

    @GetMapping
    public List<Car> getCars() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Car getOneCar(@PathVariable String id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id) {
        service.deleteById(id);
    }
    @PostMapping
    public Car create(@RequestBody Car car) {
        return service.create(car);
    }
    @PutMapping
    public Car update(@RequestBody Car car) {
        return service.update(car);
    }

    }


