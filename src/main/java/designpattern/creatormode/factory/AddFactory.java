package designpattern.creatormode.factory;

import designpattern.creatormode.factory.simple.cal.Operation;
import designpattern.creatormode.factory.simple.cal.OperationAdd;

/**
 * @author lh
 * Created on 2020/11/12
 */
public class AddFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
