package problems1_100;

public class Problem_09 {
	private int answer; 
	private int finalA;
	private int finalB;
	private int finalC;
	
	private int[] a = new int[1001];
	private int[] b = new int[1001];
	private int[] c = new int[1001];
	
	private int[] a2 = new int[1001];
	private int[] b2 = new int[1001];
	private int[] c2 = new int[1001];
	
	public void populate(int [] array){
		for(int k = 0; k < array.length; k++){
			array[k] = k;
		}
	}
	
	public void fill(){
		populate(a);
		populate(b);
		populate(c);
	}
	
	public void perfectSquares(int [] array, int[] array2){
		for(int k = 0; k < array.length; k++){
			array2[k] = array[k] * array[k];
		}
	}
	
	public void fill2(){
		perfectSquares(a,a2);
		perfectSquares(b,b2);
		perfectSquares(c,c2);
	}
	
	public void checkTriplet(){
		for(int k = 0; k < a2.length; k++){
			for(int j = k; j < a2.length; j++){
				for(int z = j; z < a2.length; z++){
					
					if(a2[k] + b2[j] == c2[z] && a[k] + b[j] + c[z] == 1000){
						finalA = a[k];
						finalB = b[j];
						finalC = c[z];
					}
				}
			}
		}
	}
	
	public void problem9(){
		fill();
		fill2();
		checkTriplet();
		System.out.println(finalA);
		System.out.println(finalB);		
		System.out.println(finalC);
		answer = finalA * finalB * finalC;
		System.out.println(answer);
		
	}
	
}
