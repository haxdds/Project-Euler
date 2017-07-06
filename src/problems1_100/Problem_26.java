package problems1_100;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lagrange on 3/30/2017.
 */
public class Problem_26 {

    private static final int LIMIT = 1000;

    public static int recurringNum(int num) {
        int[] arr = new int[num+1];
        int index = 1;
        int mod = 1;
        System.out.println("index: " + index);
        System.out.println("mod: " + mod + "\n\n");
        while(mod != 0 && arr[mod] == 0){

            arr[mod]=index++;
            mod = mod * 10 % num;

            System.out.println("index: " + index);
            System.out.println("mod: " + mod + "\n\n");

        }
        if (mod == 0){
            return 0;
        }

        System.out.println("\n" + (index - arr[mod]));
        return index-arr[mod];
    }

    public static void solve(){

        System.out.print(recurringNum(13));



//
//        int result = 0;
//        int longest = 0;
//        for (int i=2; i<LIMIT; i++){
//            int recurringNum = recurringNum(i);
//            if (recurringNum > longest){
//                longest = recurringNum;
//                result = i;
//            }
//        }
//
//        System.out.println(result);
    }




}
