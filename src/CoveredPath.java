import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CoveredPath {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int v1 = Integer.parseInt(input[0]), v2 = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]), d = Integer.parseInt(input[1]);
		
		int lastStep;
		
		System.out.println(solve(v1, t - 1, d, v2));
	}

	private static int solve(int v1, int t, int d, int v2) {
		if (Math.abs(v2 - v1) > t * d)
			return -1;
		
		if (t == 0)
			return v1 == v2 ? v2 : -1;
		
		int sol = 0;
		for (int i = d; i >= -d; i--) {
			sol = solve(v1 + i, t - 1, d, v2);
			if (sol != -1)
				break;
		}
		
		return v1 + sol;
	}

}
