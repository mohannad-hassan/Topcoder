import java.util.Arrays;

/**
 * Created by MohannadHassanPersonal on 3/19/16.
 */
public class MultiplicationTable2Easy {

    public String isGoodSet(int[] table, int[] t) {

        int n = (int) Math.sqrt(table.length);

        Arrays.sort(t);

        for (int i : t) {
            for (int j : t) {
                int x = table[i * n + j];
                if (Arrays.binarySearch(t, x) < 0) {
                    return "Not Good";
                }
            }
        }

        return "Good";
    }
}
