import java.util.Stack;

/**
 * Created by mohannadhassan on 4/15/16.
 */
public class ParenthesesDiv2Easy {

    public int getDepth(String s) {

        Stack<ParenthesesDiv2EasyStruct> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ParenthesesDiv2EasyStruct item = new ParenthesesDiv2EasyStruct();
                item.isOpen = true;
                stack.push(item);
            }
            else  {
                int depth = 0;
                ParenthesesDiv2EasyStruct item;
                do {
                    item = stack.pop();
                    if (item.isComplete) {
                        if (item.depth > depth) {
                            depth = item.depth;
                        }
                    }
                    else {
                        break;
                    }
                }
                while (true);

                ParenthesesDiv2EasyStruct newItem = new ParenthesesDiv2EasyStruct();
                newItem.isComplete = true;
                newItem.depth = depth + 1;
                stack.push(newItem);
            }
        }

        int answer = 0;

        while (!stack.empty()) {
            ParenthesesDiv2EasyStruct item = stack.pop();
            if (item.depth > answer)
                answer = item.depth;
        }

        return answer;
    }
}

class ParenthesesDiv2EasyStruct {
    boolean isComplete;
    boolean isOpen;
    boolean isClose;

    int depth;
}
