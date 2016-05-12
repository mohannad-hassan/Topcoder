/**
 * Created by mohannadhassan on 12/1/15.
 */
public class RelationClassifier {

    public String isBijection(int[] domain, int[] range) {
        int [] xs = new int[101];
        int [] ys = new int[101];

        boolean success = true;

        for (int i = 0; i < domain.length && success; i++) {
            int x = domain[i];
            int y = range[i];

            if (xs[x] == 0) {
                xs[x] = y;
            }
            else if(xs[x] != y) {
                success = false;
            }

            if (ys[y] == 0) {
                ys[y] = x;
            }
            else if (ys[y] != x) {
                success = false;
            }
        }

        return success ? "Bijection" : "Not";
    }
}
