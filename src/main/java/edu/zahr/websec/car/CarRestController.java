package edu.zahr.websec.car;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/*
@author ivan
@project IntelliJ IDEA 
@class CarRestController
@version 1.0.0 
@since 18.03.2025 - 22.12
*/

@RestController
@RequestMapping("/api/v1/cars")
@AllArgsConstructor

public class CarRestController {

    private final CarService service;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPERADMIN')")
    public List<Car> getCars() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPERADMIN')")
    public Car getOneCar(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SUPERADMIN')")
    public void delete (@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SUPERADMIN')")
    public Car create(@RequestBody Car car) {
        return service.create(car);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SUPERADMIN')")
    public Car update(@RequestBody Car car) {
        return service.update(car);
    }

    @GetMapping("/brand/{brand}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPERADMIN')")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return service.getByBrand(brand);
    }

    @GetMapping("/model/{model}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPERADMIN')")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return service.getByModel(model);
    }

    @GetMapping("/count")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPERADMIN')")
    public long getCarCount() {
        return service.countCars();
    }


    }


