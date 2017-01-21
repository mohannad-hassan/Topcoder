/**
 * Created by mohannadhassan on 1/21/17.
 */
public class SellingFruits {

    public int maxDays(int x, int f, int d, int p) {
        int days = 0;

        int money1 = f * x;

        if (money1 <= d) {
            days = f;
            d -= money1;
        }
        else {
            days = d / x;
            d -= days * x;
        }

        int dayCost = x + p;

        days += d / dayCost;

        return days;
    }

    public static void main(String [] args) {
        System.out.println(new SellingFruits().maxDays(2, 17, 20, 1));
    }
}
