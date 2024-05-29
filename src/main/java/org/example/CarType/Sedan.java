package org.example.CarType;

import main.dao.Car;

//小轿车
public abstract class Sedan extends Car {
    public Sedan() {
        super.type = "小轿车";
        super.basicMaintenanceCost = 1000;

    }


}
