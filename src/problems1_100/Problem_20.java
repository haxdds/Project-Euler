package problems1_100;

import java.math.*;

public class Problem_20 {
	BigInteger answer;
	
	
	
	public BigInteger factorial(int k){
		BigInteger product = BigInteger.valueOf(k);
		while(k != 1){
			k -= 1;
			product = product.multiply(BigInteger.valueOf(k));
			
		}
		return product;
	}
	
	
	
	
	private void sum(){
		BigInteger value = factorial(100);
		BigInteger bigInt_A;
		BigInteger sum = BigInteger.ZERO;
		while(value.compareTo(BigInteger.ZERO) > 0){
			bigInt_A = value.mod(BigInteger.TEN);
			sum = sum.add(bigInt_A);
			value = value.divide(BigInteger.TEN);
			
		}
		answer = sum;
	}
	
	
	public void problem20(){
		sum();
		System.out.println(answer);
	}
	
	
}
