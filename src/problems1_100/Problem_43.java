package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_43 {

    static int[] nums = {1,0,2,3,4,5,6,7,8,9};

    static void swap(int[] arr,int m, int n){
        int temp  = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    static void reverse(int[] arr, int start){
        int mid = (arr.length + start) / 2;
        for(int k = start; k < mid; k++){
            swap(arr,k,arr.length - k + start - 1);
        }
    }

    static void getNextPerm(int arr[]){

        int maxIndex = 1;
        boolean hasNextPerm = false;
        for(int k = 1; k < arr.length; k++){
            if(arr[k-1] < arr[k]){
                maxIndex = k;
                hasNextPerm = true;
            }
        }

        if(!hasNextPerm){
            System.out.println("Final Permutation.");
            return;
        }

        int pivot = maxIndex - 1;
        int maxIndex2 = maxIndex;
        for(int k = pivot + 1; k < arr.length; k++){
            if(arr[k] > arr[pivot]){
                maxIndex2 = k;
            }
        }

        swap(arr,pivot,maxIndex2);
        reverse(arr,pivot+1);

    }

    static boolean hasNextPerm(int[] arr){
        for(int k = 1; k < arr.length; k++){
            if(arr[k-1] < arr[k]) return true;
         }
        return false;
    }




    static char getDigit(long n,int index){
        return String.valueOf(n).charAt(index - 1);
    }

    static int getSub(long num, int i1){
        String n = "";

        n += getDigit(num,i1);
        n += getDigit(num,i1 + 1);
        n += getDigit(num,i1 + 2);
        return Integer.parseInt(n);
    }


    static long toInt(int[] arr){
        String s = "";
        for(int i: arr){
            s += String.valueOf(i);
        }
        return Long.parseLong(s);
    }


    static boolean fits(int[] arr){
        long num = toInt(arr);

        if(getSub(num,2) % 2 != 0 ||
                getSub(num,3) % 3 != 0 ||
                getSub(num,4) % 5 != 0 ||
                getSub(num,5) % 7 != 0 ||
                getSub(num,6) % 11 != 0 ||
                getSub(num,7) % 13 != 0 ||
                getSub(num,8) % 17 != 0
        ) return false;

        return true;
    }

    static long find(){
        long sum = 0;
        while(hasNextPerm(nums)){
            if(fits(nums)){
                sum+= toInt(nums);
                //System.out.print(sum);
                System.out.print("\n\n\n\n\n\n\n\n\n\nhit");

            }
            System.out.println(Arrays.toString(nums));
            getNextPerm(nums);
        }
        return sum;

    }





    public static void solve() {
        long ans = find();
        System.out.print(ans);



    }
}

