import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by mohannadhassan on 4/7/16.
 */
public class Quacking {

    public  int quack(String s) {

        int max = 0;

        HashMap<Character, Integer> cntMap = new HashMap<>();
        cntMap.put('q', 0);
        cntMap.put('u', 0);
        cntMap.put('a', 0);
        cntMap.put('c', 0);
        cntMap.put('k', 0);

        HashMap<Character, Character> preMap = new HashMap<>();
        preMap.put('q', '\0');
        preMap.put('u', 'q');
        preMap.put('a', 'u');
        preMap.put('c', 'a');
        preMap.put('k', 'c');

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char pre = preMap.get(c);
            if(c == 'q') {
                count++;
                updateCount(cntMap, c, true);

                if(count > max) {
                    max = count;
                }
            }
            else {
                if (cntMap.get(pre) == 0) {
                    return -1;
                }
                updateCount(cntMap, pre, false);
                if (c != 'k') {
                    updateCount(cntMap, c, true);
                }
                else {
                    count--;
                }
            }
        }

        return max;
    }

    void updateCount(HashMap<Character, Integer> cntMap, char c, boolean increment) {
        int cnt = cntMap.get(c);
        cnt += increment ? 1 : -1;
        cntMap.put(c, cnt);
    }

    public static void main(String [] args) {
        System.out.println(new Quacking().quack("quqacukqauackck"));
    }
}
