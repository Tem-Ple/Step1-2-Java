import java.util.ArrayList;

public class ArrayListMultiThread {
    static ArrayList<Integer> al = new ArrayList<Integer>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 1000000; i++) {
                al.add(i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("size:" + al.size());

//        use vector instead of array list

//        Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 360145
//        at java.util.ArrayList.add(ArrayList.java:463)
//        at SuspendGood$AddThread.run(SuspendGood.java:12)
//        at java.lang.Thread.run(Thread.java:748)
//        size:1125814
    }
}
