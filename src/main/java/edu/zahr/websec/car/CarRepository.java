package edu.zahr.websec.car;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/*
@author ivan
@project IntelliJ IDEA
@class CarRestController
@version 1.0.0
@since 18.03.2025 - 22.10
*/

public interface CarRepository extends MongoRepository<Car, String> {
}

