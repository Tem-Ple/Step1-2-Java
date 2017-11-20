public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run()
            {
                while (true) {
                    if(Thread.currentThread().isInterrupted())
                    {
                        System.out.println("exit");
                        break;
                    }
                    System.out.println("haha");
                }
            }
        };
        t1.start();
        t1.sleep(100);
        t1.interrupt();
    }
}
