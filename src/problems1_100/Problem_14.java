package problems1_100;
import static java.lang.Math.toIntExact;

public class Problem_14 {
	
	private long[] numbers = new long[1000001];
	private long answer = 1;
	
	
	private long collatz(long input){
		long value = input;
		long chainLength = 0;
		while(value != 1){
			if(value % 2 == 0){
				value /= 2;
				chainLength ++;
			}else{
				value = (3 * value) + 1;
				chainLength ++;
			}
		}
		return chainLength;
	}
	
	
	private void fill(){
		for(long k = 1; k < numbers.length; k++){
			
			numbers[toIntExact(k)] = collatz(k);
						
		}		
		
	}
	
	
	private void max(){
		long maxval = numbers[1];
		int maxnum = 1;
		for(int k = 2; k < numbers.length; k++){
			if(numbers[k] > maxval) {
				maxval = numbers[k];
				maxnum = k;
			}
		}
		answer = maxnum;
		
	}
	
	
	public void problem14(){
	    fill();
		max();
		System.out.println(answer);
		
	}
	
	
	
	
}
