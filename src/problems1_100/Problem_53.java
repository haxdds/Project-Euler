package problems1_100;

import java.math.BigInteger;

/**
 * Created by Lagrange on 4/11/2017.
 */
public class Problem_53 {

    static BigInteger factorial(BigInteger bi){
        BigInteger temp = bi;
        BigInteger product = BigInteger.ONE;
        while(temp.compareTo(BigInteger.ONE) == 1){
            product = product.multiply(temp);
            temp = temp.subtract(BigInteger.ONE);
        }
        return product;
    }

    static BigInteger combination(int n, int r){
        //nCr

        BigInteger nf = factorial(BigInteger.valueOf(n));
        BigInteger rf = factorial(BigInteger.valueOf(r));
        BigInteger nrf = factorial(BigInteger.valueOf(n-r));

        return (nf.divide(rf.multiply(nrf)));
    }

    static int find(){
        int ways = 0;

        for(int n = 1; n <= 100; n++)
            for(int r = 1; r <= n; r++)
                if(combination(n,r).compareTo(BigInteger.valueOf(1000000)) == 1) ways++;

        return ways;
    }





    public static void solve() {

        int answer = find();
        System.out.print(answer);
    }
}
