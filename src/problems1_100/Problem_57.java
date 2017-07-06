package problems1_100;

import java.math.BigInteger;

/**
 * Created by Lagrange on 4/14/2017.
 */
public class Problem_57 {

    public static BigFraction continunedFraction(int r, int iterations){
        BigFraction sum = new BigFraction(r);
        BigFraction one = new BigFraction(1);
        BigFraction c = new BigFraction(r);
        for(int k = 1; k <= iterations; k++){
            sum = one.divide(sum).add(c);
        }
        return sum.add(one).subtract(c);
    }

    static int getDigits(BigInteger n){
        BigInteger temp = n;
        int count = 0;
        while(temp.compareTo(BigInteger.ZERO) != 0){
           temp = temp.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }





    public static void solve() {

        long startTime = System.nanoTime();

        int answer = 0;



        for(int k = 1; k <= 1000; k++){
            //System.out.println(k);
            if(getDigits(continunedFraction(2,k).getNumerator()) > getDigits(continunedFraction(2,k).getDenominator()))
                answer++;
        }

        System.out.print("\nANSWER: " + answer);


        long endTime = System.nanoTime();

        double runTime = endTime - startTime;
        runTime /= 1000000000;
        System.out.print("\n\nRUNTIME: \n" + runTime);


    }
}
