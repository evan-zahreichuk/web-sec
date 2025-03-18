package edu.zahr.websec.car;
/*
@author ivan
@project IntelliJ IDEA
@class CarRestController
@version 1.0.0
@since 18.03.2025 - 22.01
*/

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Car {
    @Id
    private String id;
    private String brand;
    private String model;
    private String color;


    public Car(String brand, String model, String color, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
