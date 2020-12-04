package DesignPattern.Creator.prototype;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public class PrototypeA extends Prototype implements Cloneable{
    @Override
    public Prototype cloneObject() {
        try {
            return (Prototype) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
