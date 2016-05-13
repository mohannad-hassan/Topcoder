/**
 * Created by MohannadHassanPersonal on 3/26/16.
 */
public class EllysTimeMachine {

    public String getTime(String time) {
        String [] args = time.split(":");
        int hours = Integer.parseInt(args[0]);
        int minutes = Integer.parseInt(args[1]);

        int newHrs = minutes == 0 ? 12 : minutes / 5;
        int newMins = (hours * 5) % 60;

        String hrsStr = newHrs + "";
        if (hrsStr.length() < 2)
            hrsStr = "0" + hrsStr;

        String minsStr = newMins + "";
        if (minsStr.length() < 2)
            minsStr = "0" + minsStr;

        return hrsStr + ":" + minsStr;
    }
}
