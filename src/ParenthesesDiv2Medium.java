import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mohannadhassan on 4/15/16.
 */
public class ParenthesesDiv2Medium {

    public int[] correct(String s) {

        Stack<ParenthesesDiv2MediumStruct> stack = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ParenthesesDiv2MediumStruct item = new ParenthesesDiv2MediumStruct(c == '(', i);

            if (i % 2 == 0) {
                stack.push(item);
                continue;
            }

            ParenthesesDiv2MediumStruct peak = stack.pop();

            if(!peak.isOpen && item.isOpen) {
                list.add(peak.index);
                list.add(item.index);
            }
            else if(!peak.isOpen && !item.isOpen) {
                list.add(peak.index);
            }
            else if(peak.isOpen && item.isOpen) {
                list.add(item.index);
            }
        }

        Integer[] arr = list.toArray(new Integer[list.size()]);
        int [] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }

    public static void main(String [] args) {
        int [] arr = new ParenthesesDiv2Medium().correct(")))))(((((");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class ParenthesesDiv2MediumStruct {
    boolean isOpen;
    int index;

    public ParenthesesDiv2MediumStruct(boolean isOpen, int index) {
        this.isOpen = isOpen;
        this.index = index;
    }
}