/**
 * Created by mohannadhassan on 1/21/17.
 */
public class ThreeIncreasing {

    public int minEaten(int a, int b, int c) {
        int answer = 0;
        if (c <= b) {
            answer = b - c + 1;
            b = c - 1;
        }

        if (b <= a) {
            answer += a - b + 1;
            a = b - 1;
        }
        if (b < 1 || a < 1)
            answer = -1;
        return answer;
    }
}
