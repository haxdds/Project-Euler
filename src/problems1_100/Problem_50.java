package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_50 {

    private static List<Integer> generatePrimes(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        Integer [] primes = new Integer [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) {
                primes [index++] = i;
                //System.out.println(i);
            }
        }
        List<Integer> list = Arrays.asList(primes);
        return list;
    }

    static int sumOfPrimes(List<Integer> primes,int p, int minTermsLimit){
        int maxN = 1;
        for(int k = 0; k < primes.size(); k++){
            int n = 0;
            int sum = 0;

            if(primes.get(k) > p / minTermsLimit) return maxN;

            while(sum <= p){
                sum += primes.get(k + n);
                //System.out.println("prime: " + primes.get(k + n) +"\tsum: " + sum);
                n++;
                if(sum == p){
                        return maxN = n;
                }
            }
            //System.out.print("\n\n\n");
        }
        return maxN;
    }


    static int findPrime(List<Integer> primes, int limit){
        int maxPrime = 2;

        for(Integer i: primes)
            if(sumOfPrimes(primes,i,limit) > sumOfPrimes(primes,maxPrime,limit))
                maxPrime = i;

        return maxPrime;

    }







    public static void solve() {
        List<Integer> primes = generatePrimes(1000000);
       int ans = findPrime(primes,21);
       System.out.print("prime: " + ans + "\tlength: " + sumOfPrimes(primes,ans,21));


    }
}
