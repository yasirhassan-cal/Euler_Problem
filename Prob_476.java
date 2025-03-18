import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
 
public class Prob_476 {
    private static final double PI = Math.acos(-1);
    private static final int N = 1803;
 
    private static void update(double[] max, double x) {
        if (x > max[0]) {
            max[1] = max[0];
            max[0] = x;
        } else if (x > max[1]) {
            max[1] = x;
        }
    }
 
    private static double calc(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double R = Math.sqrt(p * (p - a) * (p - b) * (p - c)) / p;
        double[] max = {0, 0};
 
        for (int i = 0; i < 3; i++) {
            double t = p - c;
            double sinTheta = R / Math.hypot(t, R);
            double r = R * (1 - sinTheta) / (1 + sinTheta);
            double w = R * r / (R + r + 2 * Math.sqrt(R * r));
 
            update(max, r);
            update(max, w);
            update(max, r * (1 - sinTheta) / (1 + sinTheta));
 
            double temp = a;
            a = b;
            b = c;
            c = temp;
        }
 
        return PI * (R * R + max[0] * max[0] + max[1] * max[1]);
    }
 
    public static void main(String[] args) {
        AtomicReference<BigDecimal> sum = new AtomicReference<>(BigDecimal.ZERO);
        AtomicInteger count = new AtomicInteger();
 
        IntStream.rangeClosed(1, N).parallel().forEach(a -> {
            for (int b = a; a + b <= N; b++) {
                for (int c = b; c < a + b && c <= N; c++) {
                    double result = calc(a, b, c);
                    sum.updateAndGet(current -> current.add(BigDecimal.valueOf(result)));
                    count.incrementAndGet();
                }
            }
        });
 
        BigDecimal average = sum.get().divide(BigDecimal.valueOf(count.get()), 5, RoundingMode.HALF_UP);
        System.out.println("S(1803) = " + average);
    }
}

