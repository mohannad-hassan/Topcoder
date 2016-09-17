import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by MohannadHassanPersonal on 9/17/16.
 */
public class SubtreeSum {

    LinkedList<Integer> [] adjacencyMatrix;

    int [] values;

    int [] results;
    boolean [] visted;

    long result = 0;

    final int MOD = 1_000_000_007;

    public int getSum(int[] p, int[] x) {
        adjacencyMatrix = new LinkedList[x.length];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacencyMatrix[i] = new LinkedList<>();
        }

        for (int i = 0; i < p.length; i++) {
            adjacencyMatrix[i + 1].add(p[i]);
            adjacencyMatrix[p[i]].add(i + 1);
        }

        values = x;

        results = new int [x.length];
        visted = new boolean[x.length];
        for (int i = 0; i < x.length; i++) {
            results[i] = -1;
        }

        for (int i = 0; i < x.length; i++) {
            visit(i);
        }

        return (int)result;
    }

    void visit(int i) {
        if (results[i] != -1) {
            return;
        }
        visted[i] = true;

        int own = values[i];
        add(own);

        int aggregate = own;

        Iterator<Integer> ite = adjacencyMatrix[i].iterator();
        while (ite.hasNext()) {
            int index = ite.next();
            if (visted[index]) {
                continue;
            }
            visit(index);
            add(own | values[index]);
            if (results[index] != values[index])
                add(own | results[index]);
            aggregate |= results[index];
        }

        results[i] = aggregate;

        visted[i] = false;
    }

    void add(int val) {
        result += val;
        result = result % MOD;
    }


    public static void main(String ... args) {
        int [] p = {0,0,0,0,0,0,0,0,0,0};
        int [] x = {1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000};
        System.out.println(new SubtreeSum().getSum(p, x));
    }
}
