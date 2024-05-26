package org.example;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
    @TableField("Car_Id")
    protected int Id;

    //车牌号
    @TableField("Car_Number")
    protected String Number;

    //制造公司
    @TableField("Car_Company")
    protected String Company;

    //购买时间
    @TableField("Car_BuyTime")
    protected Date BuyTime;

    //车辆类型
    @TableField("Car_Type")
    protected String Type;

    //车辆总公里
    @TableField("Car_Total_km")
    protected BigDecimal Total_km;

    //每公里耗油量
    @TableField("Car_CostOil")
    protected BigDecimal CostOil;

    //车辆基本维护费用
    @TableField("Car-basic_maintenance_Cost")
    protected int Basic_Maintenance_Cost;

    //车辆养路费
    @TableField("Car_RoadToll")
    protected BigDecimal RoadToll;

    //车辆总费用
    @TableField("Car_AllCost")
    protected BigDecimal AllCost;

    //构造器
    public Car(){ }

    public Car(int carId, String carNumber, String carCompany, Date carBuyTime, String carType, BigDecimal carTotalKm, BigDecimal carCostOil, int basic_Maintenance_Cost, BigDecimal carRoadToll) {
        this.Id = carId;
        this.Number = carNumber;
        this.Company = carCompany;
        this.BuyTime = carBuyTime;
        this.Type = carType;
        this.Total_km = carTotalKm;
        this.CostOil = carCostOil;
        this.Basic_Maintenance_Cost = basic_Maintenance_Cost;
        this.RoadToll = carRoadToll;
    }
}
