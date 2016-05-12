/**
 * Created by mohannadhassan on 10/21/15.
 */
public class SubstitutionCipher {

    public String decode(String a, String b, String y) {

        char []source = new char['z' - 'a' + 1];
        boolean []used = new boolean['z' - 'a' + 1];
        int cnt = 0;

        for (int i = 0; i < a.length(); i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);

            if (source[bc - 'A'] == '\0') {
                source[bc - 'A'] = ac;
                cnt++;
            }
            used[ac - 'A'] = true;
        }

        char [] result = new char[y.length()];
        for (int i = 0; i < result.length; i++) {
            char yc = y.charAt(i);
            if (source[yc - 'A'] != '\0') {
                result[i] = source[yc - 'A'];
            }
            else if(cnt == 'z' - 'a'){
                char temp = '\0';
                for (int j = 0; j < used.length; j++) {
                    if (!used[j]) {
                        temp = (char) (j + 'A');
                        break;
                    }
                }
                if (temp != '\0') {
                    source[yc - 'A'] = temp;
                    result[i] = temp;
                }
            }
            else  {
                result = null;
                break;
            }
        }

        return result == null ? "" : new String(result);
    }
}
