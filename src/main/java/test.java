import designpattern.creatormode.builder.Car;
import designpattern.creatormode.builder.CarBuilder;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * Created on 2020/11/7
 */
public class test {
    public static void main(String[] args) {
//        Operation operation = OperationFactory.createOperate("/");
//        operation.set_numberA(4);
//        operation.set_numberB(2);
//        System.out.println(operation.GetResult());
//        CashSuper cashSuper = FactoryCash.cashFactory("满300返100");
//        System.out.println(cashSuper.takeMoney(700));

//        DecoratorA decoratorA = new DecoratorA();
//        DecoratorB decoratorB = new DecoratorB();
//        DecoratorC decoratorC = new DecoratorC();
//
//        decoratorB.SetComponent(decoratorA);
//        decoratorC.SetComponent(decoratorB);
//        decoratorC.Operation();

//        GiftProxy giftProxy = new GiftProxy(new SchoolGirl("lalala"));
//        giftProxy.giveGiftOne();
//        giftProxy.giveGiftTwo();
//        giftProxy.giveGiftThree();

        // 建造者模式
//        Car car = new CarBuilder().type("小").comfort("一般舒适").power("动力强劲").build();
//        System.out.println(car.toString());
//        System.setProperty("file.encoding", "GB2312");
//        System.out.printf(Charset.defaultCharset().name());
//        System.out.printf(System.getProperty("file.encoding"));
//        Integer a = new Integer(1);
//        Integer b = new Integer(1);
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(a == 1);

    }

    @Test
    public void listRemove(){

    }

    public int[] sortArray(int[] number) {
        if(number.length == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<number.length;i++){
            if(!list.contains(number[i])){
                list.add(number[i]);
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        for(int i = 0;i<nums.length;i++){
            heapInsert(nums,i);
        }
        int size = nums.length;
        swap(nums,0,--size);
        while(size > 0){
            heapify(nums,0,size);
            swap(nums,0,--size);
        }
        return nums;


    }

    public void heapInsert(int[] nums,int index){
        while(nums[index] > nums[(index - 1) / 2]){
            swap(nums,index,(index-1)/2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums,int index,int size){
        int left = 2 * index + 1;
        while(left < size){
            int largest = left + 1 < size && nums[left] < nums[left + 1] ? left + 1 : left;
            largest = nums[index] > nums[largest] ? index : largest;
            if(largest == index){
                break;
            }
            swap(nums,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void threadPoolTest() throws InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextLong());
        }
    }


}
