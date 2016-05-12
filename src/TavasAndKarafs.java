import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TavasAndKarafs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input = br.readLine().split(" ");
		
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		long n = Long.parseLong(input[2]);
		
		while(n-- > 0) {
			input = br.readLine().split(" ");
			
			long l = Long.parseLong(input[0]);
			long t = Long.parseLong(input[1]);
			long m = Long.parseLong(input[2]);
			
			long x = l * b -2 * b + 2 * a;
			long y = 2 * t * m - l * x;
			long z = x - l * b;
			
			long s = a + (l - 1) * b;
			
			if(s > t || a > t) {
				System.out.println(-1);
				continue;
			}
			long temp = (-z + (long)Math.sqrt(z * z + 4 * b * y));
			if(temp < 0)
				temp *= -1;
			
			long r1 = temp / (2 * b);
			if(r1 < l)
				r1 = Long.MAX_VALUE;
			long r2 = (t - a) / b + 1;
			long sr2 = a + (r2 - 1) * b;
			if (sr2 > t) {
				r2--;
			}
			else if (sr2 == t && r2 - l >= m && r1 != r2) {
				r2--;
			}
			
			System.out.println(r1 < r2 ? r1 : r2);
			
//			long sum = 0;
//			long r = 0;
//			while (sum + s < t * m && s <= t && r != -1) {
//				sum += s;
//				s += b;
//				r++;
//			}
//			System.out.println(r + l - 1);
		}
	}

}
