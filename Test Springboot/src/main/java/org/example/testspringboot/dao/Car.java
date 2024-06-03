package org.example.testspringboot.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    //车辆编号
    @Id
    private long id;

    //车牌号
    private String number;

    //制造公司
    private String company;

    //购买时间
    private Date buyTime;

    //车辆类型
    private String type;

    //车辆总公里
    private BigDecimal totalKm;

    //每公里耗油量
    private BigDecimal costOil;

    //车辆基本维护费用
    private int basicMaintenanceCost;

    //车辆养路费
    private BigDecimal roadToll;

    //车辆总费用
    private BigDecimal allCost;

    public Car(long carId, String carNumber, String carCompany, Date carBuyTime, String carType, BigDecimal carTotalKm, BigDecimal carCostOil, int basic_Maintenance_Cost, BigDecimal carRoadToll) {
        this.id = carId;
        this.number = carNumber;
        this.company = carCompany;
        this.buyTime = carBuyTime;
        this.type = carType;
        this.totalKm = carTotalKm;
        this.costOil = carCostOil;
        this.basicMaintenanceCost = basic_Maintenance_Cost;
        this.roadToll = carRoadToll;
        setAllCost();
    }

    public void setAllCost() {
        if (this.totalKm != null && this.costOil != null && this.roadToll != null) {
            this.allCost = this.totalKm.multiply(this.costOil)
                    .multiply(new BigDecimal("8.0"))
                    .add(new BigDecimal(this.basicMaintenanceCost))
                    .add(this.roadToll);
        } else {
            this.allCost = BigDecimal.ZERO;
        }
    }

    public Car(){

    }

    public String toString(){
        return "{车辆编号：" + this.id + ";车牌号：" + this.number + ";制造公司：" + this.company + ";购买时间：" + this.buyTime + ";车辆类型：" + this.type + ";总公里：" + this.totalKm + ";耗油量/公里：" + this.costOil + ";基础维护费用：" + this.basicMaintenanceCost + ";养路费：" + this.roadToll + ";总费用：" + this.allCost + "}";
    }

}