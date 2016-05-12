import java.util.Arrays;

/**
 * Created by mohannadhassan on 3/7/16.
 */
public class Istr {

    public int count(String s, int k) {
        int [] cntArr = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            cntArr[s.charAt(i) - 'a']++;
        }

        Arrays.sort(cntArr);

        while (k > 0) {
            int i = cntArr.length - 1;
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (cntArr[j] != cntArr[i])
                    break;
            }
            int diff = cntArr[i] - (j >= 0 ? cntArr[j] : 0);
            int range = i - j;
            int total = diff * range;

            if (total > k) {
                total = k;
            }

            k -= total;
            int mod = total % range;
            for (int l = i; l > j; l--) {
                cntArr[l] -= total / range;
                if (mod > 0) {
                    mod--;
                    cntArr[l]--;
                }
            }
            Arrays.sort(cntArr);
        }

        int sol = 0;
        for (int i = 0; i < cntArr.length; i++) {
            sol += cntArr[i] * cntArr[i];
        }
        return sol;
    }

    public static void main(String [] args) {
        System.out.println(new Istr().count("aba", 1));
    }
}
