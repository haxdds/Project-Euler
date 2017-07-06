package problems1_100;

import java.util.*;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_37 {

    static List<Integer> truncatablePrimes = new ArrayList<>();


    static int truncateL(int x){
        int t = x;
        int length = String.valueOf(t).length();
        int modVal =(int) Math.pow(10,length-1);
        return t % modVal;
    }

    static int truncateR(int x){
        int t = x;
        return t / 10;
    }

    public static boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n) return false;

        for(int k = 2; k <= sqrt; k++){
            if(n % k == 0) return false;
        }
        return true;
    }

    static boolean isTruncatable(int prime){
        int length = String.valueOf(prime).length();
        length -= 1;
        int L = prime;
        int R = prime;

        for(int k = 0; k < length; k++){
            L = truncateL(L);
            R = truncateR(R);
            if(!(isPrime(L) && isPrime(R))) return false;
        }

        return true;
    }

    static List<Integer> getPrimes(int limit){
        List<Integer> list = new ArrayList<>();
        for(int k = 10; k <= limit; k++){
            if(isPrime(k)) list.add(k);
        }
        return list;
    }

    static int check(int limit){
        List<Integer> primes = getPrimes(limit);
        int sum = 0;

        for(Integer p: primes){
            if(isTruncatable(p)){
                sum += p;
                truncatablePrimes.add(p);
            }
        }
        return sum;
    }



    public static void solve(){
//            System.out.println(truncateL(123));
//             System.out.println(truncateR(123));
//             System.out.println(isTruncatable(3797));
        int ans = check(1000000);
        System.out.println(Arrays.toString(truncatablePrimes.toArray()));
        System.out.print("Sum: " + ans + "\n\n size: " + truncatablePrimes.size());

    }
}
