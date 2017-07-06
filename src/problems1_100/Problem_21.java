package problems1_100;

//import java.math.*;
import java.util.*;
//import java.lang.*;


public class Problem_21 {

	private int sum = 0;
	private int[] numFactors = new int[10000];
	private Set<Integer> amicable = new HashSet<Integer>();
	
	//Iterator iter = amicable.iterator();
	
	public int factors(int n){
		
		int sumfactors = 0;
		for(int k = 1; k < n; k++){
			if(n % k == 0){
				sumfactors += k;
				
			}
		}
		
		
		return sumfactors;
	}
	
	
	private void fill(){
		
		for(int k = 1; k < 10000; k++ ){
			numFactors[k]  = factors(k);
			
		}
	}
	
	public int[] toInt(Set<Integer> set) {
		  int[] a = new int[set.size()];
		  int i = 0;
		  for (Integer val : set) a[i++] = val;
		  return a;
		}
	
	private void check(){
		for(int k = 1; k < 10000; k++){
			if(factors(numFactors[k]) == k && numFactors[k] != k){
				amicable.add(k);
				
				
				
			}
		}
	}	
	
	
	
	private void sum(){
		
		for(Integer val : amicable){
			sum += val;
		}
				
		
	}
	
	
	public void problem21(){
		fill();
		check();
		sum();
		System.out.println(amicable);
		System.out.println(sum);
	}
	
	
}
