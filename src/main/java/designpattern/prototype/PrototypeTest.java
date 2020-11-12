package designpattern.prototype;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public class PrototypeTest {
    public static void main(String[] args) {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setId(1);
        prototypeA.setName("a");

        PrototypeA prototypeA1 = null;
        try {
            prototypeA1 = (PrototypeA) prototypeA.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        prototypeA.setId(2);

        System.out.println("A1:" + prototypeA1.getId() + " A:"+prototypeA.getId());
    }
}
