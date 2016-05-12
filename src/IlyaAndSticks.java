import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class IlyaAndSticks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String input [] = br.readLine().split("[ ]+");
		
		long answer = 0;
		
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		int max = 0;
		
		for (int i = 0; i < input.length; i++) {
			int num = Integer.parseInt(input[i]);
			
			if(num > max)
				max = num;
			
			Integer cnt = count.get(num);
			
			if (cnt == null) 
				cnt = 0;
			cnt++;
			count.put(num, cnt);
		}
		
		HashMap<Integer, Integer> reduced = new HashMap<Integer, Integer>();
		
		Queue<Integer> leftover = new LinkedList<Integer>(); 
		
		for (int i = max; i >= 2; i --) {
			Integer cnt = count.get(i);
			if(cnt == null)
				cnt = 0;
			Integer red = reduced.get(i);
			if (red == null)
				red = 0;
			
			if (leftover.size() > 0 && cnt + red >= 2) {
				int head = leftover.poll();
				answer += (long) head * i;
				if (red <= 2){
					cnt -= (2 - red);
					red = 0;
				}else {
					cnt -= 2;
				}
			}
			
			if ((cnt + red) >= 4) {
				int tmp = (cnt + red) / 4;
				answer += tmp * (long) i * i;
				tmp *= 4;
				tmp -= red;
				red = 0;
				cnt -= tmp;
			}
			
			if (red + cnt == 3) {
				leftover.add(i);
				if (cnt == 2 || cnt == 3) {
					cnt -= 1;
				}
			}
			else if (red + cnt == 2) {
				leftover.add(i);
				cnt = 0;
			}
			
			if (cnt > 0) {
				reduced.put(i - 1, cnt);
			}
		}
		
		while(leftover.size() >= 2) {
			int i1 = leftover.poll();
			int i2 = leftover.poll();
			
			answer += (long) i1 * i2;
		}
		
		System.out.println(answer);
	}

}
