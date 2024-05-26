package org.example.CarType;

import org.example.Car;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

//大巴车
public abstract class Bus extends Car {

    protected int PassengerNumber;

    public Bus(){
        super.Type = "大巴车";
        super.Basic_Maintenance_Cost = 2000;
    }



}
