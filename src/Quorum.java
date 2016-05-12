import java.util.Arrays;

/**
 * Created by mohannadhassan on 4/7/16.
 */
public class Quorum {

    public int count(int[] arr, int k) {
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += arr[i];
        }

        return  cnt;
    }
}
