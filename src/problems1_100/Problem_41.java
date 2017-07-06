package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_41 {
    public static boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n) return false;

        for(int k = 2; k <= sqrt; k++){
            if(n % k == 0) return false;
        }
        return true;
    }

    static List<Integer> getPrimes(int limit){
        List<Integer> list = new ArrayList<>();
        for(int k = 6; k <= limit; k += 6){

            if(isPrime(k-1)) {
                list.add(k-1);
                System.out.println(k-1);
            }
            if(isPrime(k+1)) {
                list.add(k+1);
                System.out.println(k+1);
            }
        }
        return list;
    }
    private static int [] generatePrimes(int max) {
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
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) {
                primes [index++] = i;
                System.out.println(i);
            }
        }
        return primes;
    }


    public static boolean isPandigital(int n){

        List<Integer> digits = new ArrayList<>();

        digits = getDigits(n);

        Integer[] arr = new Integer[digits.size()];
        arr = digits.toArray(arr);
        Arrays.sort(arr);

        if(arr.length > 9) return false;
        //System.out.println(Arrays.toString(arr));
        for(int k = 0; k < arr.length; k++){
            if(arr[k] != k+1) return false;
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

    public static int getLargestPandigitalPrime(int limit){
        //List<Integer> primes = getPrimes(limit);
        int[] primes1 = generatePrimes(limit);
        int max_prime = 1;
        System.out.println("Got the primes!");
//        for(Integer i: primes){
//            System.out.println(i);
//            if(isPandigital(i) && i > max_prime)
//                max_prime = i;
//
//        }

        for(int i: primes1){

            if(isPandigital(i) && i > max_prime){
                max_prime = i;
            }

        }


        return max_prime;


    }



    public static void solve(){
        long start = System.nanoTime();
        int ans = getLargestPandigitalPrime(999999999);
        System.out.print("Answer: " + ans);
        long end = System.nanoTime();
        double time = end - start;
        time /= 1000000000;
        System.out.print("\n\n================\n\nruntime: " + time + " seconds");

    }
}
