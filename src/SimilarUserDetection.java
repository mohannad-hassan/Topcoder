/**
 * Created by mohannadhassan on 4/23/16.
 */
public class SimilarUserDetection {

    public String haveSimilar(String[] handles) {

        for (int i = 0; i < handles.length; i++) {
            for (int j = i + 1; j < handles.length; j++) {
                if (compare(handles[i], handles[j]))
                    return "Similar handles found";
            }
        }

        return "Similar handles not found";
    }

    boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return  false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);


            if (c1 != c2 && !((c1 == 'O' && c2 == '0') || (c2 == 'O' && c1 == '0')) &&
                    !((c1 == 'l' && c2 == 'I') || (c2 == 'l' && c1 == 'I'))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {
        String [] arr = {"top", "coder", "TOPCODER", "TOPC0DER"};
        System.out.println(new SimilarUserDetection().haveSimilar(arr));
    }
}
