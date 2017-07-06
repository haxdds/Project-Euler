package problems1_100;
import java.util.*;

public class Problem_04 {
	private int answer;
	private int integer_A = 0;
	private int integer_B = 0;
	private int integer_C;
	
	Set<Integer> palindromes = new HashSet<Integer>();
	
	public boolean isPalindrome(int n){
		integer_B = n;
		integer_A = 0;
		
		while(integer_B != 0){
		integer_A += integer_B % 10;
		integer_B /= 10;
		integer_A *= 10;
		}
		
		integer_A /= 10;
		
				
		if(integer_A == n){
			return true;
		}else{
			return false;
		}
	}
	
	private void values(){
		for(int k = 1; k < 1000; k++ ){
			for(int j = 1; j < 1000; j++){
				
				integer_C = j * k;
				
								
				if(isPalindrome(integer_C)){
					
					
					palindromes.add(integer_C);
					
				}
			}
		}
	}
	
	public void problem4(){
		values();
		
		answer = Collections.max(palindromes);
		System.out.println(answer);
	}
	
}
