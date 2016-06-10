
/**
 * Created by MohannadHassanPersonal on 6/10/16.
 */
public class PriorityQueue {

    public int findAnnoyance(String S, int[] a) {

        int sum = 0;
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            if (S.charAt(i) == 'b') {
                sum += temp;
            }
            temp += a[i];
        }

        return sum;
    }
}
