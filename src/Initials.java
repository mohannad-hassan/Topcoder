/**
 * Created by MohannadHassanPersonal on 9/17/16.
 */
public class Initials {

    public String getInitials(String name) {
        String [] words = name.split(" ");
        String answer = "";

        for (String word :
                words) {
            answer += word.charAt(0);
        }
        return answer;
    }
}
