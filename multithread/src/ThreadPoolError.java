import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolError implements Runnable {
    private double a, b;

    public ThreadPoolError(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            pools.submit(new ThreadPoolError(100, i));
        }

    }

    @Override
    public void run() {
        System.out.println(a / b);
    }
}
