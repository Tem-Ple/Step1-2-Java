public class SuspendBad {
    public static Object o = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name)
        {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (o){
                System.out.println("in "+this.getName());
                Thread.currentThread().suspend();
                System.out.println("suspend "+this.getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("resume t1");
        t1.resume();
        System.out.println("resume t2");
        t2.resume();
        t1.join();
        t2.join();
//        use jstack+PID to analyze the Thread t2

//        "t2" #11 prio=5 os_prio=0 tid=0x00007fdb2c208000 nid=0x7f1b runnable [0x00007fdb18e4d000]
//        java.lang.Thread.State: RUNNABLE
//        at java.lang.Thread.suspend0(Native Method)
//        at java.lang.Thread.suspend(Thread.java:1032)
//        at SuspendBad$ChangeObjectThread.run(SuspendBad.java:16)
//        - locked <0x000000078cd29d20> (a java.lang.Object)

    }
}
