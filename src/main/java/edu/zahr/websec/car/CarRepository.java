package edu.zahr.websec.car;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@author ivan
@project IntelliJ IDEA
@class CarRestController
@version 1.0.0
@since 18.03.2025 - 22.10
*/

public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByModel(String model);

    List<Car> findByBrand(String brand);
}

