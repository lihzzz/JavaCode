package designpattern.factory.simple.cal;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class OperationDiv extends Operation{


    @Override
    public double GetResult() {
        try {
            if(this._numberB == 0){
                throw new Exception("除数不能为0");
            } else{
                return this._numberA / this._numberB;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
