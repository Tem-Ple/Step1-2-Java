public class SimpleWN {
    final static Object o = new Object();

    public static class T1 extends Thread
    {
        @Override
        public void run() {
            synchronized (o){
                System.out.println(System.currentTimeMillis()+":T1 start!");
                try{
                    System.out.println(System.currentTimeMillis()+"T1 wait for objects");
                    o.wait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+"T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        public void run()
        {
            synchronized (o)
            {
                System.out.println(System.currentTimeMillis()+"T2 start, notify one thread");
                o.notify();
                System.out.println(System.currentTimeMillis()+"T2 end!");
                try {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();

        t1.start();
        t2.start();
    }
}
