package problems1_100;

public class Problem_10 {

	private long answer = 0;
	
	
	public boolean isPrime(int z){
	    int factors = 0;
	    if(z == 1){
	    	return false;
	    }
	    if(z == 2){
	    	return true;
	    }
	    if(z % 2 == 0){
	    	return false;
	    }
		for(int k = 3; k <= Math.sqrt(z)  ; k += 2){
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
	
	public void sum(){
		for(int k = 0; k < 2000000; k++){
			if(isPrime(k)){
				answer += k;
				
			}
		}
	}
	
	public void problem10(){
		sum();
		System.out.println(answer);
	}
	
}
