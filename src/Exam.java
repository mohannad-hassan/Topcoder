import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Exam {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		switch (n) {
		case 1:
		case 2:
			System.out.println("1");
			System.out.println("1");
			break;
		case 3:
			System.out.println("2");
			System.out.println("1 3");
			break;
		case 4:
			System.out.println("4");
			System.out.println("2 4 1 3");
			break;
		default:
			System.out.println(n);
			System.out.print("1");
			for (int i = 3; i <= n; i+=2)
				System.out.print(" " + i);
			for (int i = 2; i <= n; i+=2)
				System.out.print(" " + i);
			System.out.println();
			break;
		}
	}

}
