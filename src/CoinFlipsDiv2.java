/**
 * Created by MohannadHassanPersonal on 2/6/16.
 */
public class CoinFlipsDiv2 {

    public int countCoins(String state) {
        int count = 0;

        for (int i = 0; i < state.length(); i++) {
            if ((i > 0 && state.charAt(i) != state.charAt(i - 1)) ||
                    (i < state.length() - 1 && state.charAt(i) != state.charAt(i + 1)))
                count++;
        }

        return count;
    }
}
