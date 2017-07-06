package problems1_100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_46 {

    static Set<Integer> oddComp = new HashSet<>();
    static Set<Integer> primes = new HashSet<>();
    static Set<Integer> sqre = new HashSet<>();

    static void fill(int limit){
        for(int k = 1; k <= limit; k += 2){
            if(isPrime(k)){
                primes.add(k);
            }else{
                oddComp.add(k);
            }
        }

        for(int k = 1; k <= limit; k++){
            sqre.add(2*k*k);
        }
    }

    static boolean isPrime(int n){
        if((int)Math.sqrt(n) == Math.sqrt(n)) return false;
        for(int k = 2; k < Math.sqrt(n); k++)
            if(n % k == 0) return false;
        return true;
    }

    static boolean isSum(int n){
        for(Integer prime: primes){
            int diff = n - prime;
            if(sqre.contains(diff)) return true;
        }
        return false;
    }

    static int find(){
        for(Integer i: oddComp){
            if(!isSum(i) && i != 1) return i;
        }
        return -1;
    }



    public static void solve() {
        fill(10000);
        //System.out.print("primes: " + Arrays.toString(primes.toArray()) + "\ncomp: " +
        // Arrays.toString(oddComp.toArray()) + "\nsquare: " + Arrays.toString(sqre.toArray()));

        int ans = find();
        System.out.print(ans);
    }
}
