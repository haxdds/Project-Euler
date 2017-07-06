package problems1_100;

public class Problem_12 {
	private int answer;
	
	private int counter = 2;
	private int number_factors = 0;
	private int triangleNumbers = 1;
	private int num;
	public int factors(int n){
		int factors = 0;
		for(int k = 1; k < Math.sqrt(n); k++){
			if(n % k == 0){
				factors ++;
			}
		}
		factors *= 2;
		if(Math.sqrt(n) == Math.floor(Math.sqrt(n))){
			factors ++;
		}
		
		return factors;
	}
	public void findFactor(){
	 
		while(number_factors <= 500){
		triangleNumbers += counter;
		
		num = factors(triangleNumbers);
		if(num> number_factors){
			number_factors = num;
		}
		counter ++;
	  }
		
		answer = triangleNumbers;
	
   }
	
	public void problem12(){
		findFactor();
		System.out.println(answer);
	}
}
