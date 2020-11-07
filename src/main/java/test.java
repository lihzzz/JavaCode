import designpattern.factory.simple.Operation;
import designpattern.factory.simple.OperationAdd;
import designpattern.factory.simple.OperationFactory;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class test {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperate("/");
        operation.set_numberA(4);
        operation.set_numberB(2);
        System.out.println(operation.GetResult());
    }
}
