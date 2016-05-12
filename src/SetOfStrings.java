import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SetOfStrings {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		if (k == 1) {
			System.out.println("YES");
			System.out.println(str);
			return;
		}
		if (k > str.length()) {
			System.out.println("NO");
			return;
		}
		
		ArrayList<String> segments = new ArrayList<String>();
		
		boolean [] taken = new boolean['z' - 'a' + 1];
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!taken[c - 'a']) {
				taken[c - 'a'] = true;
				int j = i + 1;
				for (; j < str.length() && taken[str.charAt(j) - 'a']; j++);
				segments.add(str.substring(i, j));
				i = j - 1;
			}
		}
		
		if (segments.size() < k) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			int i;
			for (i = 0; i < k - 1; i++)
				System.out.println(segments.get(i));
			String temp = "";
			for (; i < segments.size(); i++) {
				temp += segments.get(i);
			}
			System.out.println(temp);
		}

	}

}
