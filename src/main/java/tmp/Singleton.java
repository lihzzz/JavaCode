package tmp;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {
    public static volatile Singleton singleton;

    public Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
