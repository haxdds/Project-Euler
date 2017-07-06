package problems1_100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_49 {

    static HashSet<Integer> primes = new HashSet<>();

    static boolean isPrime(int n){

        if((int)Math.sqrt(n) == Math.sqrt(n)) return false;

        for(int k = 2; k < Math.sqrt(n); k++)
            if(n % k == 0) return false;
        return true;
    }

    static void findprimes(){
        for(int k = 1000; k < 9999; k++){
            if(isPrime(k)) primes.add(k);
        }
    }


    static int[] toArr(int n){
        int t = n;
        List<Integer> l = new ArrayList<>();
        while(t != 0){
            l.add(t % 10);
            t /= 10;
        }
        int[] a = new int[l.size()];
        int k = 0;
        for(Integer i: l)
            a[k++] = i;
        Arrays.sort(a);
        return a;
    }

    static List find(){
        List<Integer[]> l = new ArrayList<>();

        for(Integer m: primes){
            for(Integer n: primes){

                if(arePerm(m,n) && m != n && areSeq(m,n)){
                    if(arePerm(n,getSeq(m,n))) {
                        Integer[] a = {m, n, getSeq(m, n)};
                        l.add(a);
                    }
                }


            }
        }

        return l;
    }

    static boolean arePerm(int m, int n){
        if(toInt(toArr(m)) == toInt(toArr(n))) return true;

        return false;
    }

    static long toInt(int[] arr){
        String s = "";
        for(int i: arr){
            s += String.valueOf(i);
        }
        return Long.parseLong(s);
    }

    static boolean areSeq(int m, int n){
        int diff = Math.abs(m - n);

        if(m > n)
            if(primes.contains(n - diff) || primes.contains(m + diff))return true;

        if(m < n)
            if(primes.contains(m - diff) || primes.contains(n + diff)) return true;

        return false;
    }

    static int getSeq(int m, int n){
        int diff = Math.abs(m - n);

        if(m > n){
            if(primes.contains(n - diff)) return n - diff;
            if(primes.contains(m + diff)) return m + diff;
        }

        if(m < n){
            if(primes.contains(m - diff)) return m - diff;
            if(primes.contains(n + diff)) return n + diff;
        }

        return -1;
    }









    public static void solve() {
        findprimes();

        List<Integer[]> ans = find();

        for(Integer[] i: ans){
            System.out.println(Arrays.toString(i));
        }

    }
}

