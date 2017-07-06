package problems1_100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_48 {

    static List<BigInteger> lastTenDigits(BigInteger bi){
        BigInteger n = BigInteger.ZERO;
        List<BigInteger> digits = new ArrayList<>();
        for(int k = 0; k < 10; k++){
            BigInteger digit = bi.mod(BigInteger.TEN);
            digits.add(digit);

            bi = bi.divide(BigInteger.TEN);
        }

        return digits;
    }

    static BigInteger getNum(int limit){
        BigInteger b = BigInteger.ZERO;
        for(int k = 1; k <= limit; k++){
            BigInteger a = BigInteger.valueOf(k);

           b = b.add(a.pow(k));
        }
        return b;
    }

    public static void solve() {
        BigInteger b = BigInteger.valueOf(1234567891);
        System.out.println(getNum(1000));
        System.out.print(Arrays.toString(lastTenDigits(getNum(1000)).toArray()));
    }
}
