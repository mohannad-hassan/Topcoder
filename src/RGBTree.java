import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by MohannadHassanPersonal on 3/19/16.
 */
public class RGBTree {

    int required;
    public String exist(String[] G) {

        ArrayList<RGBTreePair>[] lists = new ArrayList[3];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < G.length; i++) {
            for (int j = i + 1; j< G.length; j++) {
                char c = G[i].charAt(j);
                int index = 0;
                switch (c) {
                    case 'R':
                        index = 0;
                        break;
                    case 'G':
                        index = 1;
                        break;
                    case 'B':
                        index = 2;
                        break;
                }
                lists[index].add(new RGBTreePair(i, j));
            }
        }

        int x = G.length - 1;
        required = x;

        HashSet<Integer> tree = new HashSet<>();

        return check(tree, lists, required, 0) ? "Exists" : "Does not exist";
    }

    boolean check(HashSet<Integer> tree, ArrayList<RGBTreePair>[] lists, int cnt, int index) {

        if (index == 3)
            return true;

        for (int i = 0; i < lists[index].size(); i++) {
            if (tree.contains(lists[index].get(i).i) && tree.contains(lists[index].get(i).j))
                continue;

            RGBTreePair pair = lists[index].get(i);
            tree.add(pair.i);
            tree.add(pair.j);
            if (check(tree, lists, cnt == 1 ? required : cnt - 1, cnt == 1 ? index + 1 : index))
                return true;
            tree.remove(pair.i);
            tree.remove(pair.j);
        }

        return false;
    }
}

class RGBTreePair {
    int i, j;

    public RGBTreePair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}