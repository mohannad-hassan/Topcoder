import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PolycarpusDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		String temp = br.readLine();
		int n = Integer.parseInt(input[0]);
		long a = Long.parseLong(input[1]);
		
		if (a > n) {
			boolean first = true;
			for (int i = 0; i < n; i++) {
				if (first) {
					first = false;
				}
				else {
					System.out.print(" ");
				}
				System.out.print(1);
			}
			System.out.println();
		}
		else {
			System.out.print("0");
			for (int i = 1; i < n; i++) {
				System.out.print(" " + 1);
			}
			System.out.println();
		}
	}

}
