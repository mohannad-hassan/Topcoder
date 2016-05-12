
/**
 * Created by mohannadhassan on 10/21/15.
 */
public class Tdetectived2 {

    int [] max;
    int [] steps;

    boolean [][] visited;

    boolean [] seen;

    String [] mat;

    public int reveal(String[] s) {
        this.mat = s;
        max = new int[s.length];
        steps = new int[s.length];
        seen = new boolean[s.length];
        for (int i = 1; i < s.length; i++) {
            steps[i] = -1;
            max[i] = -1;
        }
        visited = new boolean[s.length][s.length];
        dfs(0, 0, 0);

        int res = 0;

        for (int i = 1; i < s.length; i++) {
            res += i * steps[i];
        }

        return res;
    }

    public void dfs(int person, int stepsCnt, int value) {
        seen[person] = true;
        if (value > max[person] && stepsCnt > steps[person]) {
            max[person] = value;
            steps[person] = stepsCnt;
        }
        else if (value == max[person] && stepsCnt < steps[person]) {
            steps[person] = stepsCnt;
        }

        for (int i = 1; i < max.length; i++) {
            if (!seen[i]) {
                visited[i][person] = visited[person][i] = true;
                int newValue = mat[i].charAt(person) - '0';
                if (max[person] <= max[i])
                    newValue = -2;
                System.out.println("Visit " + i + " from " + person);
                dfs(i, stepsCnt + 1, newValue);
            }
        }
        seen[person] = false;
    }

    public static void main (String [] args) {
        String [] s = {"0224","2011","2104","4140"};
        System.out.print(new Tdetectived2().reveal(s));
    }
}
