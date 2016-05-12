import java.util.Arrays;

/**
 * Created by mohannadhassan on 10/21/15.
 */
public class SetPartialOrder {

    public String compareSets(int[] a, int[] b) {
        boolean sub1 = true;
        boolean sub2 = true;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length && sub1 && sub2; i++) {
            if (sub1) {
                int index1 = Arrays.binarySearch(b, a[i]);
                sub1 = index1 >= 0;
            }

            if (sub2) {
                int index2 = Arrays.binarySearch(a, b[i]);
                sub2 = index2 >= 0;
            }
        }

        if (sub1 && sub2) {
            return "EQUAL";
        }
        else if (sub1) {
            return "LESS";
        }
        else if (sub2) {
            return "GREATER";
        }
        else  {
            return "INCOMPARABLE";
        }
    }
}
