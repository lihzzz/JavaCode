package com.learn.designpattern.behaviourmode.oberserve;

/**
 * @author lh
 * Created on 2020/12/4
 */
public class MinibusTargetService {

    public String lottery(String uid){
        return Math.abs(uid.hashCode()) % 2 == 0?"恭喜你，编 码".concat(uid).concat("在本次摇号中签") : "很遗憾，编 码".concat(uid).concat("在本次摇号未中签或摇号资格已过期");
    }
}
