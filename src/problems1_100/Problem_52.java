package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/11/2017.
 */
public class Problem_52 {

    static boolean checkDigits(int x, int y){
        int[] xDigits = getDigits(x);
        int[] yDigits = getDigits(y);

        if(xDigits.length != yDigits.length) return false;

        Arrays.sort(xDigits);
        Arrays.sort(yDigits);

        for(int k = 0; k < xDigits.length; k++)
            if(xDigits[k] != yDigits[k]) return false;

        return true;
    }

    public static int[] getDigits(int x){
        int[] digits = new int[Integer.toString(x).length()];
        int temp = x;
        int index = 0;
        while(temp != 0){
            int digit = temp % 10;
            digits[index++] = digit;
            temp /= 10;
        }
        return digits;
    }

    public static int find(int limit){

        for(int k = 2; k <= limit; k++){
            if(checkDigits(k,2*k) &&
                    checkDigits(k,3*k) &&
                    checkDigits(k,4*k) &&
                    checkDigits(k,5*k) &&
                    checkDigits(k,6*k) )
                return k;
        }

        return -1;
    }




    public static void solve() {
        int answer = find(1000000);

        System.out.print(answer);

    }
}


