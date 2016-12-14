import java.util.*;

/**
 * Created by MohannadHassanPersonal on 12/14/16.
 */
public class GCDGraph {

    boolean isComposite[];
    LinkedList<Integer> primes;

    boolean isVisited[];

    public String possible(int n, int k, int x, int y) {

        if (x == y || k == 0)
            return "Possible";

        generatePrimes(n);
        isVisited = new boolean[n + 1];

        Queue<Integer> currentLevel = new LinkedList<>();
        currentLevel.add(x);

        while (!currentLevel.isEmpty()) {
            HashSet<Integer> nextLevel = new HashSet<>();
            while (!currentLevel.isEmpty()) {
                int node = currentLevel.poll();
                isVisited[node] = true;

                List<Integer> factors = factorize(node);

                if (growList(node, factors, n, k, nextLevel, y)) {
                    return "Possible";
                }

            }
            currentLevel = new LinkedList<>(nextLevel);
        }

        return "Impossible";
    }

    boolean growList(int src, List<Integer> factors, int n, int k, HashSet<Integer> nextLevel, int target) {
        HashSet<Integer> seeds = seeds(factors, 0, n);

        for (Integer num : seeds) {
            int start = num;
            for (int multiple = start; multiple < n; multiple += num) {
                if (multiple == target)
                    return true;
                if (isVisited[multiple] || gcd(multiple, src) <= k)
                    continue;
                if (!nextLevel.add(multiple))
                    break;
            }
        }

        return false;
    }

    static int gcd(int a, int b) {
        if (a < b) {
            a += b;
            b = a - b;
            a = a - b;
        }
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    HashSet<Integer> seeds(List<Integer> factors, int index, int max) {
        HashSet<Integer> result = new HashSet<>();
        for (int i = index; i < factors.size(); i++) {
            int curr = factors.get(i);
            result.add(curr);
            HashSet<Integer> nextSeeds = seeds(factors, index + 1, max);
            for (Integer num : nextSeeds) {
                if (num * curr <= max) {
                    result.add(num * curr);
                }
            }
            result.addAll(nextSeeds);
        }
        return result;
    }

    void generatePrimes(int n) {
        isComposite = new boolean[n + 1];
        primes = new LinkedList<>();

        isComposite[2] = false;

        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                for (int j = i * 2; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
    }

    List<Integer> factorize(int x) {
        ArrayList<Integer> list = new ArrayList<>();

        Iterator<Integer> ite = primes.iterator();

        while (isComposite[x] && ite.hasNext()) {
            int prime = ite.next();
            if (x % prime == 0) {
                list.add(prime);
                while (x % prime == 0) {
                    x /= prime;
                }
            }
        }

        if (x != 1) {
            list.add(x);
        }
        return list;
    }

    public static void main(String [] args) {
        System.out.println(gcd(12, 8));
        System.out.println(new GCDGraph().possible(1000000, 2000, 12345, 54321));
    }
}
