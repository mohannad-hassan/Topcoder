/**
 * Created by mohannadhassan on 1/28/16.
 */
public class BearPair {

    public int bigDistance(String s) {
        int n = s.length();
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) != s.charAt(j + i))
                    return i;
            }
        }
        return -1;
    }
}
