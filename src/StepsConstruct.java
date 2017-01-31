import java.util.*;

/**
 * Created by mohannadhassan on 1/31/17.
 */
public class StepsConstruct {

    String[] board;
    int lastPoint;


    public String construct(String[] board, int k) {
        this.board = board;

        lastPoint = board.length * board[0].length() - 1;

        if (board[0].charAt(0) == '#')
            return "";

        HashMap<Integer, LinkedList<Integer> > list = new HashMap<>();
        list.put(0, new LinkedList<>());

        return findPath(list, k).get(0).answer;
    }


    public LinkedList<StepsConstructAnswer> findPath(HashMap<Integer, LinkedList<Integer> > points, int k) {
        if (k == 0) {
            LinkedList<Integer> list;
            if ((list = points.get(lastPoint)) != null) {

                LinkedList<StepsConstructAnswer> answers = new LinkedList<>();
                for(Integer temp : list) {
                    if (temp == lastPoint - 1) {
                        answers.add(new StepsConstructAnswer(temp, "R"));
                    }
                    else {
                        answers.add(new StepsConstructAnswer(temp, "D"));
                    }
                }
            }
            else {
                return null;
            }
        }
        HashMap<Integer, LinkedList<Integer> > current = new HashMap<>(points.size());

        for (Integer point : points.keySet()) {
            for (Integer neighbor: getVisitablePoints(point)) {
                LinkedList<Integer>list = current.get(neighbor);
                if (list == null) {
                    list = new LinkedList<>();
                    current.put(neighbor, list);
                }
                list.add(point);
            }
        }

        LinkedList<StepsConstructAnswer> temp = findPath(current, k - 1);
        if (temp == null)
            return null;

        LinkedList<StepsConstructAnswer> answers = new LinkedList<>();
        for (StepsConstructAnswer answer : temp) {
            LinkedList<Integer> list = points.get(answer.head);

            for(Integer blah : list) {
                if (blah == answer.head - 1) {
                    answers.add(new StepsConstructAnswer(blah, "R" + answer.answer));
                }
                else if (blah < answer.head) {
                    answers.add(new StepsConstructAnswer(blah, "D" + answer.answer));
                }
                else if (blah == answer.head + 1) {
                    answers.add(new StepsConstructAnswer(blah, "L" + answer.answer));
                }
                else {
                    answers.add(new StepsConstructAnswer(blah, "U" + answer.answer));
                }
            }
        }

        if (answers.size() == 0) {
            return temp;
        }
        return answers;
    }

    List<Integer> getVisitablePoints(int point) {
        int i = point / board.length;
        int j = point / board[0].length();

        int [] is = {0, 0 , 1, -1};
        int [] js = {1, -1, 0, 0};

        LinkedList<Integer> list = new LinkedList<>();

        for (int k = 0; k < is.length; k++) {
            int newI = i + is[k];
            int newJ = j + js[k];

            if (newI < 0 || newJ < 0 ||
                    newI == board.length ||
                    newJ == board[0].length() ||
                    board[newI].charAt(newJ) == '#')
                continue;

            int newPoint = newI * board[0].length() + newJ;
            list.add(newPoint);
        }

        return list;
    }
}

class StepsConstructAnswer {
    int head;
    String answer;

    public StepsConstructAnswer(int head, String answer) {
        this.head = head;
        this.answer = answer;
    }
}