package problems1_100;

public class Problem_06 {
	private int answer;
	
	public int square(int n){
		int squared = n * n;
		return squared;
	}
	
	public int sumOfSquares(int n){
		int sum = 0;
		for(int k = 1; k <= n; k++){
			sum += square(k);
		}
		return sum;
	}
	
	public int squareOfSum(int n){
		int sum = 0;
		for(int k = 1; k <= n; k++){
			sum += k;
		}
		return square(sum);
	}
	
	public int difference(int m, int n){
		return n- m;
	}
	
	public void problem6(){
		answer = difference(sumOfSquares(100),squareOfSum(100));
		System.out.println(answer);
	}
	
}
