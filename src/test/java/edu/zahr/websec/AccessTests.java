package edu.zahr.websec;

/*
@author ivan
@project IntelliJ IDEA 
@class AccessTests
@version 1.0.0 
@since 14.05.2025 - 21.45
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zahr.websec.car.Car;
import edu.zahr.websec.car.CarRestController;
import edu.zahr.websec.car.CarService;
import edu.zahr.websec.security.JwtService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarRestController.class)
class AccessTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService service;

    @MockBean
    private JwtService jwtService;


    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("1. Anonymous cannot access GET /cars")
    @WithAnonymousUser
    void anonymousCannotGetCars() throws Exception {
        mockMvc.perform(get("/api/v1/cars"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("2. USER can GET all cars")
    @WithMockUser(authorities = "USER")
    void userCanGetCars() throws Exception {
        mockMvc.perform(get("/api/v1/cars"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("3. USER can GET one car by ID")
    @WithMockUser(authorities = "USER")
    void userCanGetOneCar() throws Exception {
        mockMvc.perform(get("/api/v1/cars/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("4. USER can GET cars by brand")
    @WithMockUser(authorities = "USER")
    void userCanGetCarsByBrand() throws Exception {
        mockMvc.perform(get("/api/v1/cars/brand/Toyota"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("5. USER forbidden to DELETE a car")
    @WithMockUser(authorities = "USER")
    void userForbiddenDelete() throws Exception {
        mockMvc.perform(delete("/api/v1/cars/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("6. USER forbidden to CREATE a car")
    @WithMockUser(authorities = "USER")
    void userForbiddenCreate() throws Exception {
        Car dummy = new Car("1","Toyota","Corolla", "Black");
        mockMvc.perform(post("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dummy)))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("7. ADMIN can DELETE a car")
    @WithMockUser(authorities = "ADMIN")
    void adminCanDelete() throws Exception {
        mockMvc.perform(delete("/api/v1/cars/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("8. ADMIN can CREATE a car")
    @WithMockUser(authorities = "ADMIN")
    void adminCanCreate() throws Exception {
        Car dummy = new Car("2","Honda","Civic", "White");
        mockMvc.perform(post("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dummy)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("9. SUPERADMIN can UPDATE a car")
    @WithMockUser(authorities = "SUPERADMIN")
    void superadminCanUpdate() throws Exception {
        Car dummy = new Car("3","Ford","Focus", "Blue");
        mockMvc.perform(put("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dummy)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("10. ADMIN can GET car count")
    @WithMockUser(authorities = "ADMIN")
    void adminCanGetCount() throws Exception {
        mockMvc.perform(get("/api/v1/cars/count"))
                .andExpect(status().isOk());
    }
}

