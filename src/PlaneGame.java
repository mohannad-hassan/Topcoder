/**
 * Created by mohannadhassan on 12/1/15.
 */
public class PlaneGame {

    static final double SMALL_VAL = 1e-4;

    public int bestShot(int[] x, int[] y) {

        if (x.length <= 3)
            return x.length;

        int max = 3;

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                double dx1 = x[i] - x[j];
                int dy1 = y[i] - y[j];
                if (dx1 == 0)
                    dx1 = SMALL_VAL * SMALL_VAL;
                double tan1 = dy1 / dx1;
                double const1 = y[i] - tan1 * x[i];

                for (int k = 0; k < x.length; k++) {
                    if (k == i || k == j)
                        continue;

                    for (int l = k + 1; l < x.length; l++) {
                        if (l == i || l == j)
                            continue;

                        double dx2 = x[k] - x[l];
                        int dy2 = y[k] - y[l];
                        if (dx2 == 0)
                            dx2 = SMALL_VAL * SMALL_VAL;
                        double tan2 = dx2 == 0 ? Integer.MAX_VALUE : dy2 / dx2;
                        double const2 = y[k] - tan2 * x[k];

                        boolean test2 = Math.abs(tan1 * tan2 + 1) <= SMALL_VAL;

                        int cnt = 4;

                        for (int m = 0; m < x.length; m++) {
                            if (m == i || m == j || m == k || m == l)
                                continue;
                            if (satisies(tan1, const1, x[m], y[m]) || (test2 &&  satisies(tan2, const2, x[m], y[m]))) {
                                cnt++;
                            }
                        }

                        if (cnt > max) {
                            max = cnt;
                        }
                    }
                }
            }
        }

        return max;
    }

    boolean satisies(double tan, double cons, int x, int y) {
        double res = tan * x + cons;
        return Math.abs(res - y) <= SMALL_VAL;
    }

    public static void main(String [] args) {
        int []x = {0, 0, 0, 1, -1};
        int []y = {0, 1, -1, 0, 0};
        System.out.println(new PlaneGame().bestShot(x, y));
    }
}
