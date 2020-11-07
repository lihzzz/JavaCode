package designpattern.factory.simple;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class OperationAdd extends Operation{



    @Override
    public double GetResult() {
        return this._numberA + this._numberB;
    }
}
