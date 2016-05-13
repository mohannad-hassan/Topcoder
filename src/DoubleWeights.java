/**
 * Created by MohannadHassanPersonal on 3/19/16.
 */
public class DoubleWeights {

    int min = Integer.MAX_VALUE;

    String[] weight1;
    String[] weight2;

    boolean []visited;

    public int minimalCost(String[] weight1, String[] weight2) {

        this.weight1 = weight1;
        this.weight2 = weight2;

        visited = new boolean[weight1.length];

        visit(0, 0, 0);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void visit(int node, int w1, int w2) {
        if (visited[node])
            return;

        if (node == 1) {
            int temp = w1 * w2;
            if (temp < min)
                min = temp;
            return;
        }

        visited[node] = true;

        for (int i = 0; i < weight1.length; i++) {
            if (weight1[node].charAt(i) != '.') {
                visit(i, w1 + weight1[node].charAt(i) - '0',
                        w2 + weight2[node].charAt(i) - '0');
            }
        }

        visited[node] = false;
    }

    public static void main(String [] args) {
        String [] w1 = {"..14",
                "..94",
                "19..",
                "44.."};

        String [] w2 = {"..94",
                "..14",
                "91..",
                "44.."};

        System.out.println(new DoubleWeights().minimalCost(w1, w2));
    }
}
