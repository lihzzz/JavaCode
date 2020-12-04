package DesignPattern.Creator.factory.simple.cal;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class OperationSub extends Operation{

    @Override
    public double GetResult() {
        return this._numberA - this._numberB;
    }
}
