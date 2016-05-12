
public class ValueOfString {

	public int findValue(String s)
	{
		int [] occurance = new int[27];
		int [] sum = new int[27];
		
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a' + 1;
			occurance[c] ++;
		}
		
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + occurance[i];
		}
		
		int answer = 0;
		
		for (int i = 1; i < sum.length; i++) {
			answer += i * sum[i] * occurance[i];
		}
		
		return answer;
	}
}
