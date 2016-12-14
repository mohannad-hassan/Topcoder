/**
 * Created by MohannadHassanPersonal on 12/14/16.
 */
public class AlternatingString {

    public int maxLength(String s) {

        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            int j;
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1))
                    break;
            }
            int len = j - i;
            if (len > max) {
                max = len;
            }
        }


        return max;
    }
}
