/**
 * Created by mohannadhassan on 10/14/15.
 */
public class BearPaints {

    public long maxArea(int W, int H, long M) {

        long max = 0;
        for (long i = W; i > 0; i--) {
            if (i > M)
                continue;
            long startJ = M / i;
            if (startJ > H)
                startJ = H;
            for (long j = startJ; j > 0; j--) {
                long area = i * j;
                if (area < max) {
                    break;
                }
                if (area <= M) {
                    max = area;
                    break;
                }
            }
        }
        return max;
    }
}

