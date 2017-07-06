package problems1_100;

import java.math.*;

public class Problem_16 {
	private BigInteger answer;
	private BigInteger two = new BigInteger("2");
	private BigInteger sum = BigInteger.ZERO;
	private BigInteger value;
	
	private void calc(){
		BigInteger product = BigInteger.ONE;
		for(int k = 1; k <= 1000; k++)			product = product.multiply(two);
		value = product;
	}
	
	private void sum(){
		BigInteger bigInt_A;
		while(value.compareTo(BigInteger.ZERO) > 0){
			bigInt_A = value.mod(BigInteger.TEN);
			sum = sum.add(bigInt_A);
			value = value.divide(BigInteger.TEN);
		}
		answer = sum;
	}
	
	public void problem16(){
		calc();
		sum();
		System.out.println(answer);
	}
}
