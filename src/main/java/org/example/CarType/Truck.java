package org.example.CarType;

import main.dao.Car;

//卡车
public abstract class Truck extends Car {

    protected int MaxLoad;
    public Truck() {
        super.type = "卡车";
        super.basicMaintenanceCost = 1500;
    }

}
