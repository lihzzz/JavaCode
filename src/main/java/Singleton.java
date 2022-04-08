import org.junit.Test;

import java.util.Stack;

public class Singleton {

    public static volatile Singleton singleton;

    public Singleton(){};


    public static Singleton getSingleton() {
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public String strAdd(String str1,String str2){
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < str1.length(); i++) {
            s1.push(str1.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            s2.push(str2.charAt(i));
        }

        int add = 0;
        int sum = 0;

        int level = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || add != 0 ){
            int tmp = 0;
            if(!s1.isEmpty()){
                tmp += s1.pop() - '0';
            }
            if(!s2.isEmpty()){
                tmp += s2.pop() - '0';
            }
            tmp += add;

            add = tmp / 10;
            tmp = tmp % 10;
            sum += tmp * Math.pow(10,level);
            level++;

            //3 10 Linked

            // id name
            // select * from table where name in (select name from table group by(name) having count(name) > 1);

            // awk $1 $2


            // www.baidu.com -> ip -> http、https -> TCP -> 返回

        }
        return String.valueOf(sum);

    }

    public static void main(String[] args) {
//        Singleton singleton1 = Singleton.getSingleton();
//        Singleton singleton2 = Singleton.getSingleton();
//        System.out.println(singleton1 == singleton2);

        Singleton singleton = new Singleton();
        System.out.println(singleton.strAdd("001","1"));
    }

}
