package Thread;

public class Visibility {
    public static int a = 0,b = 0;
    public static int x = 0,y = 0;



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                y = b;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                x = a;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("(" + x + "," + y + ")");
    }
}
