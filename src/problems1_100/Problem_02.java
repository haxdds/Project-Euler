package problems1_100;

public class Problem_02 {

//	Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
//
//			1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//
//	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.



	private int sum = 0;
	
	private int a = 1;
	private int b = 2;
	private int c = 0;
	
	
	public boolean isEven(int n){
		if(n % 2 == 0){
			return true;
		}else{
			return false;
		}
	}
	
	private void fibonacci(){
		while(c <= 400){
		if(isEven(b)){
			sum += b;
		}		
		c = a + b;
		a = b;
		b = c;
		
		}
	}
	
	public void problem2(){
		fibonacci();
		System.out.println(sum);
	}
		
	
}
