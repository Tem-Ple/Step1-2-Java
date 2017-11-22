public class ThreadJoin {
    public static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("I'm T1.");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        t1.start();
        Thread.sleep(1000);
        //t1.join();  //notice the difference between t1.join and no t1.join
        System.out.println("I'm main.");
    }
}
