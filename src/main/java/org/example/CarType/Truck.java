package org.example.CarType;

import org.example.Car;

//卡车
public abstract class Truck extends Car {

    protected int MaxLoad;
    public Truck() {
        super.Type = "卡车";
        super.Basic_Maintenance_Cost = 1500;
    }

}
