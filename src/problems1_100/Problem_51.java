package problems1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lagrange on 4/11/2017.
 */
public class Problem_51 {

    static int replaceDigit(int number, int index, int replacement){
        StringBuilder sb = new StringBuilder(String.valueOf(number));
        sb.setCharAt(index,(char) replacement);
        return Integer.parseInt(sb.toString());
    }

    static List<Integer> getPrimes(int limit){
        List<Integer> l = new ArrayList<>();
        for(int k = 2; k <= limit; k++)
            if(isPrime(k)) l.add(k);
        return l;
    }

    static boolean isPrime(int x){
        if(Math.sqrt(x) * Math.sqrt(x) == x) return false;

        for(int k = 2; k < Math.ceil(Math.sqrt(x)); k++)
            if(x % k == 0) return false;

        return true;
    }

    static void find(){
        List<Integer> primes = getPrimes(100000);

        for(Integer prime: primes){
            String s = String.valueOf(prime);
            int size = s.length();







        }

    }









    public static void solve() {
    }
}
