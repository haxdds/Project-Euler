package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_36 {

    static List<Integer> nums = new ArrayList<>();

    static boolean palin10(int n){
        int b = n;
        int a= 0;
        while(b != 0){
            a += b % 10;
            b /= 10;
            a *= 10;
        }
        a /= 10;
        if(a == n){
            return true;
        }else{
            return false;
        }
    }

    static boolean palin2(int n){
       String A = Integer.toBinaryString(n);

       String B = "";
       for(int k = A.length() - 1; k >= 0; k--){
           B += A.charAt(k);
       }

       if(A.equals(B)) return true;
        return false;
    }

    static int getPalindromes(int limit){
        int sum = 0;
        for(int k = 1; k < limit; k++){
            if(palin10(k) && palin2(k)) {
                nums.add(k);
                sum += k;
            }
        }
        return sum;
    }




    public static void solve(){
        int ans = getPalindromes(1000000);
        System.out.print(Arrays.toString(nums.toArray()) + "\n\n sum: " + ans);
    }

}
