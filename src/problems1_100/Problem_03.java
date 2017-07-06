package problems1_100;
import java.util.*;


public class Problem_03 {
	private long answer;
	private long long_A;
	private long long_B = 2;
	
	Set<Long> primeFactors = new HashSet<Long>();
	
	public boolean isPrime(long z){
	    long factors = 0;
		for(long k = long_B; k <= z / 2 ; k++){
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
	
	public void factor(long n){
		long k = long_B;
		if(k == 0){
			return;
		}
		while(n % k != 0){
			k++;
		}
		if(isPrime(k)){
			primeFactors.add(k);
		}
		
		long_B = k;
		
		long_A = n / k; 
		
		if(isPrime(long_A)== true){
			primeFactors.add(long_A);
		}else{
			factor(long_A);
		}
		
				
	}
	
	public void problem3(long input){
		factor(input);
		answer = Collections.max(primeFactors);
		System.out.println(primeFactors);
		System.out.println(answer);
	}
	
}
