import java.util.HashSet;

/**
 * Created by MohannadHassanPersonal on 2/6/16.
 */
public class ExplodingRobots {

    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {

        ExplodingRobotsPair pair1 = new ExplodingRobotsPair(x1, y1);
        ExplodingRobotsPair pair2 = new ExplodingRobotsPair(x2, y2);



        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            pair1.move(c);
            pair2.move(c);
        }

        if (pair1.inter(pair2))
            return "Explosion";

        return "Safe";
    }

    public String getRep(int x, int y) {
        return x + "," + y;
    }

    public static void main(String [] args) {
        System.out.println(new ExplodingRobots().canExplode(10, 5, -9, -10, "LULULULLLUULRULULULULULULLULULLULD"));
    }
}

class ExplodingRobotsPair {
    int minx, miny, maxx, maxy;

    ExplodingRobotsPair(int x, int y) {
        minx = maxx = x;
        miny = maxy = y;
    }

    void move(char c) {
        switch (c) {
            case 'U':
                maxy++;
                break;

            case 'D':
                miny--;
                break;

            case 'L':
                minx--;
                break;

            case 'R':
                maxx++;
                break;
        }
    }

    boolean inter(ExplodingRobotsPair oth) {
        return ((minx >= oth.minx && minx <= oth.maxx) || (maxx >= oth.minx && maxx <= oth.maxx))
                && ((miny >= oth.miny && miny <= oth.maxy) || (maxy >= oth.miny && maxy <= oth.maxy));
    }
}
