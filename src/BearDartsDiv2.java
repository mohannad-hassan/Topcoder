import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by mohannadhassan on 10/14/15.
 */
public class BearDartsDiv2 {

    public long count(int[] w) {
        HashMap<Long, ArrayList<Integer>> map = new HashMap<Long, ArrayList<Integer>>();

        int max = 0;
        for (int i = 0; i < w.length; i++) {
            long sc = w[i];
            if (sc > max) {
                max = (int) sc;
            }
            ArrayList<Integer> list = map.get(sc);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(sc, list);
            }
            list.add(i);
        }

        long answer = 0;

        Long [] keys = map.keySet().toArray(new Long [0]);

        for (int i = 0; i < keys.length; i++) {
            ArrayList<Integer> list1 = map.get(keys[i]);
            for (int j = i; j < keys.length; j++) {
                if (keys[i] * keys[j] > max) {
                    continue;
                }
                ArrayList<Integer> list2 = map.get(keys[j]);

                if (i == j && list1.size() < 2)
                    continue;

                for (int k = j; k < keys.length; k++) {
                    long temp = keys[i] * keys[j] * keys[k];
                    if (temp > max) {
                        continue;
                    }
                    ArrayList<Integer> list3 = map.get(keys[k]);

                    if (i == j && j == k && list1.size() < 3)
                        continue;
                    if (k == j && list2.size() < 2)
                        continue;

                    if (map.containsKey(temp)) {
//                        System.out.println(keys[i] + " " + keys[j] + " " + keys[k] + " " + temp);
                        ArrayList<Integer> list4 = map.get(temp);

                        for (int l = 0; l < list4.size(); l++) {
                            long tempAns = 1;

                            ArrayList<Integer> [] lists;
                            int [] combs;
                            if (i == j && j == k) {
                                lists =  new ArrayList[1];
                                lists[0] = list1;
                                combs = new int[1];
                                combs[0] = 3;
                            }
                            else if (i == j) {
                                lists =  new ArrayList[2];
                                lists[0] = list1;
                                lists[1] = list3;
                                combs = new int[2];
                                combs[0] = 2;
                                combs[1] = 1;
                            }
                            else if (j == k) {
                                lists =  new ArrayList[2];
                                lists[0] = list1;
                                lists[1] = list2;
                                combs = new int[2];
                                combs[0] = 1;
                                combs[1] = 2;
                            }
                            else {

                                lists =  new ArrayList[3];
                                lists[0] = list1;
                                lists[1] = list2;
                                lists[2] = list3;
                                combs = new int[3];
                                combs[0] = 1;
                                combs[1] = 1;
                                combs[2] = 1;
                            }

                            for (int fg = 0; fg < lists.length; fg++) {
                                ArrayList<Integer> lis = lists[fg];
                                int cnt = 0;
                                for (int iteInt : lis) {
                                    if (iteInt < list4.get(l))
                                        cnt++;
                                }
                                tempAns *= combs(cnt, combs[fg]);
                            }
                            answer += tempAns;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public  static  long combs(int n, int r) {
        long answer = 1;
        int cr = n - r;

        if (n == 0)
            return 0;

        while (n > 1) {
            answer *= n--;
            if (r > 1 && answer % r == 0) {
                answer /= r--;
            }
            if (cr > 1 && answer % cr == 0) {
                answer /= cr--;
            }
        }

        while (r > 1) {
            answer /= r--;
        }
        while (cr > 1) {
            answer /= cr--;
        }

        return answer;
    }

    public static  void main(String [] args) {
        int [] w = {128,64,32,16,8,4,2,1};
        System.out.println(new BearDartsDiv2().count(w));
    }
}
