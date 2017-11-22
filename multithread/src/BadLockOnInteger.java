public class BadLockOnInteger implements Runnable{
    public static Integer i = 0;
    static public BadLockOnInteger bloi = new BadLockOnInteger();

    @Override
    public void run() {
        synchronized (bloi) {
            for (int j = 1; j < 1000000; j++) {

                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BadLockOnInteger());
        Thread t2 = new Thread(new BadLockOnInteger());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
