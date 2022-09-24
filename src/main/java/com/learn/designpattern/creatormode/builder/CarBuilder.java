package com.learn.designpattern.creatormode.builder;

import lombok.Data;

/**
 * @author lh
 * Created on 2020/12/4
 */
@Data
public class CarBuilder {
    // 车型
    private String type;
    // 动力
    private String power;
    // 舒适度
    private String comfort;

    public CarBuilder type(String type){
        this.type = type;
        return this;
    }

    public CarBuilder power(String power){
        this.power = power;
        return this;
    }

    public CarBuilder comfort(String comfort){
        this.comfort = comfort;
        return this;
    }

    public Car build(){
        return new Car(this);
    }
}
