/**
 * Created by mohannadhassan on 1/28/16.
 */
public class BearChairs {
    public int[] findPositions(int[] atLeast, int d) {
        int [] seats = new int[atLeast.length];

        int [] start = new int[atLeast.length];
        int [] end = new int[atLeast.length];

        for (int i = 0; i < atLeast.length; i++) {
            int min = atLeast[i];

            for (int j = i - 1; j >= 0; j--) {
                if (min >= start[j] && min <= end[j]) {
                    min = end[j] + 1;
                    j = i;
                }
            }

            seats[i] = min;
            start[i] = min > d ? min - d + 1 : 0;
            end[i] = min + d - 1;
        }

        return seats;
    }

    public static void main(String [] args) {
        int [] array = {1,21,11,7};
        int d = 10;
        int [] result = new BearChairs().findPositions(array, d);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
