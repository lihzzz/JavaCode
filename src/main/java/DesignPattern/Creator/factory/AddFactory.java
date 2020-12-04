package DesignPattern.Creator.factory;

import DesignPattern.Creator.factory.simple.cal.Operation;
import DesignPattern.Creator.factory.simple.cal.OperationAdd;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public class AddFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}