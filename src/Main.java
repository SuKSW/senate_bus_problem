import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Thread busThreadCreator = new Thread(() -> {
            ExpDistNumberGen gen = new ExpDistNumberGen(Properties.BUS_INTERVAL_MEAN);
            while (true) {
                try {
                    Thread.sleep(gen.getNext());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Bus().start();
            }
        });

        Thread riderThreadCreator = new Thread(() -> {
            ExpDistNumberGen gen = new ExpDistNumberGen(Properties.RIDER_INTERVAL_MEAN);
            while (true) {
                try {
                    Thread.sleep(gen.getNext());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Rider().start();
            }
        });
    }
}
