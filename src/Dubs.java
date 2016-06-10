/**
 * Created by MohannadHassanPersonal on 6/10/16.
 */
public class Dubs {

    public long count(long l, long r) {

        if (l == r) {
            int temp = (int) (l % 100);
            if (temp % 11 == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        long l100Div = l / 100;
        int l100Mod = (int) (l % 100);

        long r100Div = r / 100;
        int r100Mod = (int) (r % 100);

        if (l100Div == r100Div) {
            int l11Div = l100Mod / 11;
            int l11Mod = l100Mod % 11;

            int r11Div = r100Mod / 11;
            int r11Mod = r100Mod % 11;

            int min = l11Div + (l11Mod == 0 ? 0 : 1);
            int max = r11Div;

            if (max < min) {
                return 0;
            }
            else  {
                return max - min + 1;
            }
        }
        else {
            int l11Div = l100Mod / 11;
            int l11Mod = l100Mod % 11;

            int r11Div = r100Mod / 11;

            int temp = 10 - l11Div + (l11Mod == 0 ? 1 : 0) + r11Div;

            return temp + (r100Div - l100Div - 1) * 10;
        }
    }

    public static void main(String... args) {
        System.out.println(new Dubs().count(10, 20));
    }
}
