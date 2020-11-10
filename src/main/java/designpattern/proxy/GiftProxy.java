package designpattern.proxy;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/10
 */
public class GiftProxy extends GiveGift{
    private Pursuit pursuit;
    public GiftProxy(SchoolGirl schoolGirl){
        this.pursuit = new Pursuit(schoolGirl);
    }


    @Override
    public void giveGiftOne() {
        this.pursuit.giveGiftOne();;
    }

    @Override
    public void giveGiftTwo() {
        this.pursuit.giveGiftTwo();
    }

    @Override
    public void giveGiftThree() {
        this.pursuit.giveGiftThree();
    }
}
