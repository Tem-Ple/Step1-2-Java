public class StopThreadSafe {
    public static class User {
        private int id;
        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static User u = new User();

    // implement with runnable  instead of Thread
    public static class ChangeObjectThread implements Runnable  {
        volatile boolean stopme = false;

        public void stopMe()
        {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme){
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            ChangeObjectThread cot = new ChangeObjectThread();
            Thread t = new Thread(cot);
            t.start();
            Thread.sleep(150);
            cot.stopMe();
        }
    }
}
