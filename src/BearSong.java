import java.util.HashMap;

/**
 * Created by mohannadhassan on 11/18/15.
 */
public class BearSong {

    public int countRareNotes(int[] notes) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < notes.length; i++) {
            int temp = notes[i];

            Integer cnt = count.get(temp);

            if (cnt == null) {
                cnt = 0;
            }

            cnt++;

            count.put(temp, cnt);
        }

        int answer = 0;

        for (int temp : count.values()) {
            if (temp == 1)
                answer++;
        }
        return answer;
    }
}
