/**
 * Created by mohannadhassan on 3/29/16.
 */
public class TreeAndVertex {

    public int get(int[] tree) {
        int edgesCnt [] = new int[tree.length + 1];


        for (int i = 0; i < tree.length; i++) {
            int src = i + 1;
            int dest = tree[i];
            edgesCnt[src]++;
            edgesCnt[dest]++;
        }

        int max = 0;
        for (int ele : edgesCnt) {
            if (ele > max)
                max = ele;
        }

        return max;
    }
}
