package designpattern.proxy;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/10
 */
public class Pursuit extends GiveGift{

    private SchoolGirl schoolGirl;
    public Pursuit(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }
    @Override
    public void giveGiftOne() {
        System.out.println(this.schoolGirl.name + " giveGiftOne");
    }

    @Override
    public void giveGiftTwo() {
        System.out.println(this.schoolGirl.name + " giveGiftTwo");
    }

    @Override
    public void giveGiftThree() {
        System.out.println(this.schoolGirl.name + " giveGiftThree");
    }
}
