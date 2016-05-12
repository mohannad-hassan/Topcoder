
public class ThePermutationGameDiv2 {

	public long findMin(int N) {
		long answer = N;
		
		int cur = N - 1;
		
		while(cur > 1) {
			long gcd = gcd(answer, (long)cur);
			answer = (answer * cur) / gcd;
			cur--;
		}
		
		
		return answer;
	}
	
	public long gcd (long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		System.out.println(new ThePermutationGameDiv2().findMin(11));
	}
}
