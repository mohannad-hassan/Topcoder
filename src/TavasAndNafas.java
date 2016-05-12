import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TavasAndNafas {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String [] lessThan10 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String [] tens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String [] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		
		if (n >= 0 && n <= 9) {
			System.out.println(lessThan10[n]);
		}
		else if (n % 10 == 0) {
			System.out.println(tens[n / 10]);
		}
		else if (n >= 11 && n <= 19) {
			System.out.println(teens[n - 11]);
		}
		else {
			int d1 = n % 10;
			int d2 = n / 10;
			System.out.println(tens[d2] + "-" + lessThan10[d1]);
		}
	}

}
