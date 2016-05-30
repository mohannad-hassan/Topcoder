import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mohannadhassan on 5/30/16.
 */
public class Plusonegame {

    public String getorder(String s) {
        int plusses = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+') {
                plusses++;
            }
            else {
                list.add(c - '0');
            }
        }

        Collections.sort(list);

        int score = 0;

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < list.size() && score < plusses) {
            if (list.get(i) <= score) {
                ans.append(list.get(i).intValue());
                i++;
            }
            else  {
                score++;
                ans.append('+');
            }
        }

        if (i < list.size()) {
            for (; i < list.size(); i++) {
                ans.append(list.get(i).intValue());
            }
        }

        if (score < plusses) {
            for (int j = score; j < plusses; j++) {
                ans.append('+');
            }
        }

        return ans.toString();
    }
}
