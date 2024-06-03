package org.example.testspringboot;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarSwingWindowTests {

    @Resource
    private CarRepository carRepository;

    @Test
    void contextLoads() {

    }

}
