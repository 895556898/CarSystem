package org.example.CarType;

import main.dao.Car;

//大巴车
public abstract class Bus extends Car {

    protected int PassengerNumber;

    public Bus(){
        super.type = "大巴车";
        super.basicMaintenanceCost = 2000;
    }



}
