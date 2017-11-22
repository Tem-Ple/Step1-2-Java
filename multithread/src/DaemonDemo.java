import sun.awt.windows.ThemeReader;

public class DaemonDemo {
    public static class DeamonThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I'm alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new DeamonThread();
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(2000);
    }
}
