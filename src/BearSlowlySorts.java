import java.util.Arrays;

/**
 * Created by mohannadhassan on 11/18/15.
 */
public class BearSlowlySorts {

    public int minMoves(int[] w) {
        int [] sorted = w.clone();
        Arrays.sort(sorted);

        boolean isSorted = true;

        int [] deltas = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            deltas[i] = Math.abs(Arrays.binarySearch(sorted, w[i]) - i);
            if (deltas[i] != 0)
                isSorted = false;
        }

        if (isSorted)
            return 0;

        if (deltas[0] == 0 || deltas[w.length - 1] == 0)
            return 1;

        if (deltas[0] == w.length - 1 && deltas[w.length - 1] == w.length - 1)
            return 3;

        return 2;
    }
}
