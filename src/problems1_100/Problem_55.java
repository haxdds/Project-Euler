package problems1_100;

import java.math.BigInteger;

/**
 * Created by Lagrange on 4/14/2017.
 */
public class Problem_55 {

    static BigInteger getReversed(BigInteger n){
        BigInteger temp = n;
        BigInteger reversed = BigInteger.ZERO;
        while(temp.compareTo(BigInteger.ZERO) != 0){
            BigInteger digit = temp.mod(BigInteger.TEN);
            reversed = reversed.add(digit);
            reversed = reversed.multiply(BigInteger.TEN);
            temp = temp.divide(BigInteger.TEN);
        }
        reversed = reversed.divide(BigInteger.TEN);
        return reversed;
    }

    static boolean isPalindrome(BigInteger n){
        return n.compareTo(getReversed(n)) == 0;
    }

    static BigInteger sumWithReverse(BigInteger n){
        return n.add(getReversed(n));
    }

    static boolean isLychrel(BigInteger n, int iterations){
        BigInteger curr = sumWithReverse(n);
        for(int k = 1; k <= iterations; k++){
            //System.out.println(curr);
            if(isPalindrome(curr)) return false;
            curr = sumWithReverse(curr);
        }
        return true;
    }







    public static void solve() {
        int answer = 0;
        for (int k = 1; k < 10000; k++){
            if (isLychrel(BigInteger.valueOf(k), 50)) {
                System.out.println(k);
                answer++;
            }
        }
        //System.out.print(getReversed(BigInteger.valueOf(12345)));
        System.out.print("\n" + answer);
    }

}
