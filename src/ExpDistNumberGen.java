import java.util.Random;

public class ExpDistNumberGen {
    private Random random;
    private int mean;
    private int max;

    public ExpDistNumberGen(int mean, int max) {
        random = new Random();
        this.mean = mean;
        this.max = max;
    }

    public long getNext() {
        float lambda = (float) 1/mean;
        return  Math.round(Math.log(1-random.nextDouble())/(-lambda))%max;
    }
}
