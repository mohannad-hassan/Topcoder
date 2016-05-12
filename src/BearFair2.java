import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mohannadhassan on 1/28/16.
 */
public class BearFair2 {

    public String isFair(int n, int b, int[] upTo, int[] quantity) {

        BearFair2LongRange [] initialRanges = new BearFair2LongRange[upTo.length];
        for (int i = 0; i < upTo.length; i++) {
            initialRanges[i] = new BearFair2LongRange(upTo[i], quantity[i]);
        }
        Arrays.sort(initialRanges);

        ArrayList<BearFair2Range> ranges = new ArrayList<>();

        int last = 1;
        int totalCount = 0;
        for (int i = 0; i < upTo.length; i++) {
            BearFair2LongRange initialRange = initialRanges[i];
            int qnt = initialRange.count - totalCount;
            ranges.add(new BearFair2Range(last, initialRange.end, qnt));
            last = initialRange.end + 1;
            totalCount = initialRange.count;
        }

        if (last <= b) {
            if (totalCount <= 0)
                return "unfair";
            ranges.add(new BearFair2Range(last, b, n - totalCount));
        }

        int [][] matrix = new int[ranges.size()][3];


        for (int ranInd = 0; ranInd < ranges.size(); ranInd++) {
            BearFair2Range range  = ranges.get(ranInd);

            if (!range.isValid())
                return "unfair";

            int dev = (range.end - range.start + 1) / 3;
            int rem = (range.end - range.start + 1) % 3;
            int start = range.start % 3;

            for (int i = 0; i < 3; i ++){
                matrix[ranInd][(start + i) % 3] = dev + (rem-- > 0 ? 1 : 0);
            }
        }

        for (int i = 0; i < 3; i++) {
            int grpCnt = 0;
            for (int j = 0; j < matrix.length; j++) {
                grpCnt += matrix[j][i];
            }
            if (grpCnt < n / 3)
                return "unfair";
        }

        return "fair";
    }

    public static void main(String [] args) {
        int [] upto = {1,2,3,4};
        int []qnt = {1,1,1,2};

        System.out.println(new BearFair2().isFair(3, 6, upto, qnt));
    }
}

class BearFair2LongRange implements Comparable<BearFair2LongRange> {
    int end;
    int count;

    public BearFair2LongRange(int end, int count) {
        this.end = end;
        this.count = count;
    }

    @Override
    public int compareTo(BearFair2LongRange o) {
        return this.end - o.end;
    }
}

class BearFair2Range {
    int start;
    int end;
    int count;

    public BearFair2Range(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    boolean isValid () {
        return count >= 0 && count <= end - start + 1;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "] --> " + count;
    }
}

