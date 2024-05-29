package main.service;

import main.dao.Car;
import main.dao.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id).orElseThrow(RuntimeException::new);

    }
}
