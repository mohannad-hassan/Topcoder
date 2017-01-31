/**
 * Created by mohannadhassan on 1/31/17.
 */
public class Cross {

    public String exist(String[] board) {
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length() - 1; j++) {
                if (check(board, i, j))
                    return "Exist";
            }
        }

        return "Does not exist";
    }

    boolean check(String[] board, int i, int j) {
        return board[i].charAt(j) == '#' &&
                board[i - 1].charAt(j) == '#' &&
                board[i + 1].charAt(j) == '#' &&
                board[i].charAt(j + 1) == '#' &&
                board[i].charAt(j - 1) == '#' ;
    }
}
