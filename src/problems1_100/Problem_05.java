package problems1_100;


public class Problem_05 {
	private long answer;
	
	
	public long factorial(int n){
		int k = n;
		long j = 1;
		while(k > 1){
			j *= k;
			k --;
		}
		return j;
	}
	
	private void checkFactors(int m){
		long max_value = factorial(m);
		
		for(long k = 1; k <= max_value; k++){
			System.out.println(k);
			int number_factors = 0;
			for(int j = 1; j <= m; j++){
				if(k % j == 0){
					number_factors ++;
				}
			}
			if(number_factors == m){
				answer = k;
				return;
			}
		}
		
	}
	
	public void problem4(){
		checkFactors(20);
		
		System.out.println(answer);
		
	}
	
}
