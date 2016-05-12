import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TavasAndSaDDas {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		int digitCount = input.length();
		
		int countBefore =  ((int)Math.pow(2, digitCount) - 1);
		
		int sum = 0;
		int power = 1;
		
		while (n > 0) {
			int d = n % 10;
			if (d == 7) {
				sum += power;
			}
			n /= 10;
			power *= 2;
		}
		
		System.out.println(sum + countBefore);
	}

}
