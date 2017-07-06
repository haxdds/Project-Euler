package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_38 {
    static Integer[] nums = {1,2,3,4,5,6,7,8,9};


    public static boolean isPandigital(int n){

        List<Integer> digits = new ArrayList<>();

        digits = getDigits(n);

        Integer[] arr = new Integer[digits.size()];
        arr = digits.toArray(arr);
        Arrays.sort(arr);

        if(arr.length != nums.length) return false;
        //System.out.println(Arrays.toString(arr));
        for(int k = 0; k < arr.length; k++){
            if(arr[k] != nums[k]) return false;
        }

        return true;
    }

    public static List<Integer> getDigits(int x){
        List<Integer> d = new ArrayList<>();
        int temp = x;
        while(temp != 0){
            int digit = temp % 10;
            d.add(digit);
            temp /= 10;
        }
        return d;
    }

    public static int concated(int n){
        String p = "";
        boolean go = true;
        int k = 1;

        while(go){
            int product = n * k;
            p += String.valueOf(product);
            if(p.length() <= nums.length){
                if(isPandigital(Integer.parseInt(p))){
                    return Integer.parseInt(p);
                }else{
                    k++;
                }
            }else{
                go = false;
                return -1;
            }



        }

        return -1;

    }

    public static int check(int limit){
        int max = 1;

        for(int k = 3; k < limit; k++){
            int c = concated(k);
            if(c == -1) continue;

            if(c > max) max = c;
        }

        return max;
    }



    public static void solve(){
        System.out.println(concated(192));

        int ans = check(20000000);
        System.out.println(ans);
    }
}
