/**
 * Created by mohannadhassan on 5/12/16.
 */
public class LCMGCD {

    public String isPossible(int[] x, int t) {
        int [] center = factors(t);

        int [][] points = new int[x.length][2];

        double distance = 0;
        int posInf = 0;
        int negIng = 0;
        int same = 0;

        for (int i = 0; i < x.length; i++) {
            points[i] = factors(x[i]);

            int dx = points[i][0] - center[0];
            int dy = points[i][1] - center[1];

            if (dx == 0) {
                distance += dy;
            }
            else  {
                distance += (double)dy / dx;
            }
        }

        if (distance < 1e-4) {
            return "Possible";
        }

        return "Impossible";
    }

    int [] factors(int n) {
        int [] arr = new int[2];
        while (n % 2 == 0) {
            arr[0]++;
            n /= 2;
        }
        while (n % 3 == 0) {
            arr[1]++;
            n /= 3;
        }
        return arr;
    }

    public static void main (String [] args) {
        int [] x = {4, 9};
        System.out.println(new LCMGCD().isPossible(x, 6));
    }
}
