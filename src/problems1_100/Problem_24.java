package problems1_100;


//A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
// If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
//
//		012   021   102   120   201   210
//
//		What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


import java.util.Arrays;

public class Problem_24 {

	public static int[] nums = {0,1,2,3,4,5,6,7,8,9};

	public static void swap(int[] a, int index1,int index2){
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public static void reverse(int[] a, int start){

		int end = (a.length + start)/2;
		for(int k = start; k < (a.length+start)/2; k++){
			swap(a,k,a.length-k+start-1);
		}
	}


	public static void getNextPerm(int[] a){
		int pivot;
		int maxIndex = 1;
		boolean hasNextPerm = false;
		for(int k = 1; k < a.length; k++){
			if(a[k-1] < a[k]){
				maxIndex = k;
				hasNextPerm = true;
			}
		}
		if(!hasNextPerm){
			System.out.println("\t Final Permutation");
			return;
		}


		pivot = maxIndex - 1;

		int maxIndex2 = maxIndex;

		for(int k = maxIndex; k < a.length; k++){
			if(a[k] > a[pivot]){
				maxIndex2 = k;
			}
		}

		swap(a,pivot,maxIndex2);
		reverse(a,maxIndex);

	}


	public static void findPermutation(int[] a, int permNum){
		int count = 1;
		while(count < permNum){
			getNextPerm(a);
			count++;
		}
	}


	public static void solve(){
		int[] e = {0,1,2,3};
		Arrays.sort(nums);
		System.out.print(" --");

		findPermutation(nums,1000000);

		for (int i : nums) {
			System.out.print(i);
		}


	}

	
	
	
	
}
