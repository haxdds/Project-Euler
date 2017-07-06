package problems1_100;

public class Problem_07 {
	
	private long answer;
	private long primeCount = 0;
	
	public boolean isPrime(long z){
	    long factors = 0;
		for(long k = 2; k <= z / 2 ; k++){
			if (z % k == 0){
				factors ++;
				return false;
			}
		}
		if(factors >= 1){
			return false;
		}else{		
			return true;
		}
		
	}
	
	public void findPrimes(int n){
		long counter = 2;
		while(primeCount<n){
			if(isPrime(counter)){
				primeCount++;
				//System.out.println("prime count: " + primeCount);
			}
			
			counter++;
		}
		
		answer = counter - 1;
		
	}
	
	public void problem7(){
		findPrimes(10001);
		System.out.print(answer);
	}
	
}
