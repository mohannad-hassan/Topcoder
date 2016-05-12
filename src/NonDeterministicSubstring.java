import java.util.HashSet;

/**
 * Created by mohannadhassan on 4/23/16.
 */
public class NonDeterministicSubstring {
    public long ways(String A, String B) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < A.length() && A.length() - i >= B.length(); i++) {
            boolean flag = true;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < B.length() && flag; j++) {
                char cA = A.charAt(i + j);
                char cB = B.charAt(j);
                if (cA != cB && cB != '?') {
                    flag = false;
                }
                else  {
                    builder.append(cA);
                }
            }
            if (flag) {
                set.add(builder.toString());
            }
        }

        return set.size();
    }
}