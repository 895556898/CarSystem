package main.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;


@Setter
@Getter
@TableName("car")
public class Car {

    //车辆编号
    protected int id;

    //车牌号
    protected String number;

    //制造公司
    protected String company;

    //购买时间
    protected Date buyTime;

    //车辆类型
    protected String type;

    //车辆总公里
    protected BigDecimal totalKm;

    //每公里耗油量
    protected BigDecimal costOil;

    //车辆基本维护费用
    protected int basicMaintenanceCost;

    //车辆养路费
    protected BigDecimal roadToll;

    //车辆总费用
    protected BigDecimal allCost;

    //构造器
    public Car(){ }

    public Car(int carId, String carNumber, String carCompany, Date carBuyTime, String carType, BigDecimal carTotalKm, BigDecimal carCostOil, int basic_Maintenance_Cost, BigDecimal carRoadToll) {
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

    public void showCarInformation(){
        System.out.println("车辆编号："+ this.getId());
        System.out.println("车牌号："+ this.getNumber());
        System.out.println("制造公司："+ this.getCompany());
        System.out.println("购买时间："+ this.getBuyTime());
        System.out.println("车辆类型："+ this.getType());
        System.out.println("总公里："+ this.getTotalKm());
        System.out.println("耗油量："+ this.getCostOil());
        System.out.println("基础费用："+ this.getBasicMaintenanceCost());
        System.out.println("养路费："+this.getRoadToll());
        System.out.println("总费用："+this.getAllCost());
    }


}
