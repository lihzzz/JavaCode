package com.learn.designpattern.creatormode.builder;

import lombok.Data;

/**
 * @author lh
 * Created on 2020/12/4
 */
@Data
public class Car {
    private String size;
    private String steeringWheel;
    private String pedestal;
    private String wheel;
    private String displacement;
    private String maxSpeed;


    // 封装建造的具体细节
    public Car(CarBuilder carBuilder) {
        if (carBuilder.getType().equals("小")) {
            this.size = "xiao";
        } else if (carBuilder.getType().equals("中")) {
            this.size = "zhong";
        } else {
            this.size = "da";
        }

        if ("很舒适".equals(carBuilder.getComfort())) {
            this.steeringWheel = "方向盘--很舒适";
            this.pedestal = "底座--很舒适";
        } else if ("一般舒适".equals(carBuilder.getComfort())) {
            this.steeringWheel = "方向盘--一般舒适";
            this.pedestal = "底座--一般舒适";
        } else {
            this.steeringWheel = "方向盘--其他";
            this.pedestal = "底座--其他";
        }

        if ("动力强劲".equals(carBuilder.getPower())) {
            this.displacement = "排量--动力强劲";
            this.maxSpeed = "最大速度--动力强劲";
            this.steeringWheel = "轮胎--动力强劲";
        } else if ("动力一般".equals(carBuilder.getPower())) {
            this.displacement = "排量--动力一般";
            this.maxSpeed = "最大速度--动力一般";
            this.steeringWheel = "轮胎--动力一般";
        } else {
            this.displacement = "排量--其他";
            this.maxSpeed = "最大速度--其他";
            this.steeringWheel = "轮胎--其他";
        }

    }
}
