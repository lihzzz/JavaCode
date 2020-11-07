package designpattern.factory.simple;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class OperationFactory {
    public static Operation createOperate(String operate){
        Operation operation = null;
        if ("+".equals(operate)) {
            return new OperationAdd();
        } else if ("-".equals(operate)) {
            return new OperationSub();
        } else if ("*".equals(operate)) {
            return new OperationMul();
        } else if ("/".equals(operate)) {
            return new OperationDiv();
        }
        return null;
    }
}
