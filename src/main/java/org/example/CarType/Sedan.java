package org.example.CarType;

import org.example.Car;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

//小轿车
public abstract class Sedan extends Car {
    public Sedan() {
        super.Type = "小轿车";
        super.Basic_Maintenance_Cost = 1000;

    }


}
