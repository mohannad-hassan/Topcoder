import java.util.Arrays;

/**
 * Created by MohannadHassanPersonal on 3/26/16.
 */
public class EllysSocks {

    public int getDifference(int[] S, int P) {
        Arrays.sort(S);

        int dp [][] = new int[S.length + 1][P + 1];

        for (int i = 0; i < S.length; i++) {
            dp[i][0] = -1;
            if (i <= P) {
                dp[S.length][i] = -1;
            }
        }

        for (int i = 2; i <= S.length; i++) {
            int j;
            for (j = 1; j <= P && j <= i / 2 ; j++) {
                int diff = S[S.length - i + 1] - S[S.length - i];
                int temp = dp[i - 2][j - 1];
                int temp2 = temp < diff || temp != -1 ? diff : temp;
                int temp3 = i != 2 ? dp[i - 1][j] : -1;
                dp[i][j] = temp2 < temp3 || temp3 == -1 ? temp2 : temp3;
            }
            for (; j <= P; j++) {
                dp[i][j] = -1;
            }
        }


        return dp[S.length][P];
    }

    public  static void main(String [] args) {
        int [] S = {42, 37, 84, 36, 41, 42};
        System.out.println(new EllysSocks().getDifference(S, 2));
    }
}