
public class RobotOnMoonEasy {

	public String isSafeCommand(String[] board, String S) {
		
		int robotX = 0, robotY = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'S') {
					robotX = i;
					robotY = j;
				}
			}
		}
		
		boolean survive = true;
		
		for (int i = 0; survive && i < S.length(); i++) {
			int newX = robotX, newY = robotY;
			switch (S.charAt(i)) {
			case 'U':
				newX --;
				break;

			case 'R':
				newY++;
				break;

			case 'D':
				newX++;
				break;

			case 'L':
				newY--;
				break;
			default:
				break;
			}
			survive = !(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length());
			if (survive) {
				if (board[newX].charAt(newY) != '#') {
					robotX = newX;
					robotY = newY;
				}
			}
		}
		
		return survive ? "Alive" : "Dead";
	}
}
