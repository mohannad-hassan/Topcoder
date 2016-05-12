import java.util.Arrays;


public class FoxAndSouvenirTheNext {
	
	int sum;
	
	int [] sumArray;
	
	int [] array;

	public String ableToSplit(int[] value) {
		
		if (value.length % 2 == 1) {
			return "Impossible";
		}
		
		sum = 0;
		
		for (int i : value) {
			sum += i;
		}
		
		if (sum % 2 == 1) {
			return "Impossible";
		}
		
		Arrays.sort(value);
		array = value;
		
		sumArray = new int[2];
		
		sumArray[0] = value[value.length - 1];
		
		sumArray[1] = 0;
		
		if (solve(value.length - 2)) {
			return "Possible";
		}
		else  {
			return "Impossible";
		}
	}

	private boolean solve(int i) {
		boolean res = false;
		int num = array[i];

		boolean flag = sumArray[0] > sumArray[1];
		
		for (int j = 0; !res && j < 2; j++) {
			int index = flag ? 1 : 0;
			
			if(sumArray[index] + num <= sum) {
				sumArray[index] += num;
				
				if(i != 0) {
					res = solve(i - 1);
				}
				else {
					res = sumArray[0] == sumArray[1];
				}
				
				sumArray[index] -= num;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int [] value = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48};
		System.out.println(new FoxAndSouvenirTheNext().ableToSplit(value));
	}
}
