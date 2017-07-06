package problems1_100;

import java.math.BigInteger;

/**
 * Created by Lagrange on 4/14/2017.
 */

public class Problem_56 {

    static int digitSum(BigInteger bi){
        BigInteger temp = bi;
        int sum = 0;
        while(temp.compareTo(BigInteger.ZERO) != 0){
            int digit = temp.mod(BigInteger.TEN).intValue();
            sum += digit;
            temp = temp.divide(BigInteger.TEN);
        }
        return sum;
    }

    static BigInteger power(int a, int b){
        BigInteger bi = BigInteger.valueOf(a);
        return bi.pow(b);
    }







    public static void solve() {
        int maxSum = 0;
        for(int a = 1; a < 100; a++){
            for(int b = 1; b < 100; b++){
                int digitSum = digitSum(power(a,b));
                if(digitSum > maxSum) maxSum = digitSum;
            }
        }
        System.out.print(maxSum);
    }
}



