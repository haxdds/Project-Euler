package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/27/2017.
 */
public class Problem_60 {
    static List<int[]> subsets = new ArrayList<>();

    static boolean isPrime(int n){

        if((int)Math.sqrt(n) == Math.sqrt(n)) return false;

        for(int k = 2; k < Math.sqrt(n); k++)
            if(n % k == 0) return false;
        return true;
    }

    static List findprimes(int limit){
        List<Integer> primes = new ArrayList<>();
        for(int k = 2; k < limit; k++){
            if(isPrime(k)) primes.add(k);
        }
        return primes;
    }

    static boolean isConPrimes(int[] primes){
        for(int k = 0; k < primes.length; k++){
            for(int j = k + 1; j < primes.length; j++){
                if(!isPrime(concate(primes[k],primes[j]))) return false;
            }
        }
        for(int k = primes.length - 1; k >= 0; k--){
            for(int j = k - 1; j >= 0; j--){
                if(!isPrime(concate(primes[k],primes[j]))) return false;
            }
        }
        return true;
    }

    static int concate(int a, int b){
        return Integer.parseInt(Integer.toString(a)+Integer.toString(b));
    }

    static void generateSubsets(int[] input, int k){
        // input array
        // sequence length



        int[] s = new int[k];                  // here we'll keep indices
        // pointing to elements in input array

        if (k <= input.length) {

            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++);
            subsets.add(getSubset(input, s));

            for(;;) {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--);
                if (i < 0) {
                    break;
                }
                s[i]++;                    // increment this item
                for (++i; i < k; i++) {    // fill up remaining items
                    s[i] = s[i - 1] + 1;
                }
                subsets.add(getSubset(input, s));
            }
        }
    }
    // generate actual subset by index sequence
    static int[] getSubset(int[] input, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = input[subset[i]];
        return result;
    }


    public static void solve() {
        long start = System.nanoTime();
        List<Integer> p = findprimes(1000);
        int[] primes = new int[p.size()];
        for(int k = 0; k < p.size(); k++){
            primes[k] = p.get(k);
        }

        generateSubsets(primes,4);

//        for(int[] a: subsets){
//            System.out.println(Arrays.toString(a));
//        }

        long end = System.nanoTime();

        long runtime = (end-start) / 1000000000;

        System.out.print(primes.length + "\t"+ subsets.size());
        System.out.print("\n\n" + runtime + " seconds.");
        //int[] test =  {3, 7, 109, 673};
        //System.out.println(isConPrimes(test));

    }
}
