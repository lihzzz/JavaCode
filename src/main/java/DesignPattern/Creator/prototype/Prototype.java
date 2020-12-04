package DesignPattern.Creator.prototype;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public abstract class Prototype {
    private int id;
    private String name;

    public abstract Prototype cloneObject();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
