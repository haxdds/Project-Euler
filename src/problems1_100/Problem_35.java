package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/3/2017.
 */
public class Problem_35 {

    static List<Integer> circ = new ArrayList<>();

    public static boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n) return false;

        for(int k = 2; k <= sqrt; k++){
            if(n % k == 0) return false;
        }
        return true;
    }

    public static List<Integer> getPrimes(int limit){
        List<Integer> list = new ArrayList<>();

        for(int k = 2; k <= limit; k++){
            if(isPrime(k)) list.add(k);
        }

        return list;
    }


    public static boolean isCircular(int prime){
        int[] digits = getDigits(prime);
        int perm = digits.length;
        for(int k = 1; k <= perm; k++){
            digits = rotate(digits);
            int n = toInt(digits);
            //System.out.println(n);
            if(!isPrime(n)) return false;
        }

        return  true;
    }

    public static int[] getDigits(int x){
        List<Integer> d = new ArrayList<>();
        int temp = x;
        while(temp != 0){
            int digit = temp % 10;
            d.add(digit);
            temp /= 10;
        }

        int[] digits = new int[d.size()];
        for(int k = 0; k < d.size(); k++){
            digits[k] = d.get(k);
        }
        digits = reverse(digits);
        return digits;
    }


    public static int toInt(int[] digits){
        int i = 0;
        for(int k = 0; k < digits.length; k++){
            i += digits[k];
            i *= 10;
        }
        i /= 10;
        return i;
    }

    public static int[] rotate(int[] a){
        int[] b = new int[a.length];
        b[0] = a[a.length - 1];
        for(int k = 0; k < a.length - 1; k++){
            b[k+1] = a[k];
        }
        return b;
    }

    public static int check(int limit){
        List<Integer> primes = getPrimes(limit);

        int n = 0;
        for(Integer i: primes){
            if(isCircular(i)){
                n++;
                circ.add(i);
            }

        }
        return n;
    }




    public static void solve(){
        //System.out.print(Arrays.toString(getPrimes(100).toArray()));
//        int[] a = {1,2,3,4};
//        a =  rotate(a);
//        System.out.println(Arrays.toString(a));

//        System.out.print(isCircular(197));

        int ans = check(1000000);

        System.out.print(Arrays.toString(circ.toArray()));

        System.out.print("\n\n---" + ans);

    }

    public static void swap(int[] a, int index1,int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static int[] reverse(int[] a){
        int start = 0;
        int end = (a.length + start)/2;
        for(int k = start; k < (a.length+start)/2; k++){
            swap(a,k,a.length-k+start-1);
        }
        return a;
    }




    public static int factorial(int n){
        int product = 1;
        for(int k = n; k > 0; k--){
            product *= k;
        }
        return product;
    }

}
