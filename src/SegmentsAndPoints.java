import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mohannadhassan on 3/29/16.
 */
public class SegmentsAndPoints {

    public String isPossible(int[] p, int[] l, int[] r) {
        ArrayList<SegmentsAndPointsPair> edges = new ArrayList<>();

        ArrayList<SegmentsAndPointsPair> [] leftEdges = new ArrayList[p.length];
        ArrayList<SegmentsAndPointsPair> [] rightEdges = new ArrayList[p.length];

        for (int i  = 0; i < p.length; i++) {
            leftEdges[i] = new ArrayList<>();
            rightEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i] >= l[i] && p[j] <= r[j]) {
                    SegmentsAndPointsPair edge = new SegmentsAndPointsPair(i, j);
                    leftEdges[i].add(edge);
                    rightEdges[j].add(edge);
                    edges.add(edge);
                }
            }
        }

        ArrayList<SegmentsAndPointsPair> list;
//        while (list = findAug()) {
//
//        }

        return "";
    }
}

class SegmentsAndPointsPair implements Comparable<SegmentsAndPointsPair> {
    int point;
    int segment;

    public SegmentsAndPointsPair(int point, int segment) {
        this.point = point;
        this.segment = segment;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(SegmentsAndPointsPair o) {
        return point == o.point ? segment - o.segment : point - o.point;
    }
}