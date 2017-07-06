package problems1_100;

import java.util.*;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_47{

    static Set<Integer> factor(int n){
        Set<Integer> facts = new HashSet<>();
        for(int k = 2; k < n; k++)
            if(n % k == 0) facts.add(k);

        if(facts.size() == 0) facts.add(n);
        return facts;
    }

    static int primeFactors(Set<Integer> factors){
        Set<Integer> m = new HashSet<>();
        int size1 = factors.size();
        for(Integer i: factors)
            m.addAll(factor(i));

        factors.clear();
        factors.addAll(m);
        int size2 = factors.size();
        if(size1 != size2) primeFactors(factors);

        return factors.size();
    }


    static int find(int limit){


        for(int k = 1; k < limit; k++){
            System.out.println(k);
            if(primeFactors(factor(k+3)) != 4) {
                k += 3;
                continue;
            }
            if(primeFactors(factor(k)) == 4 &&
                    primeFactors(factor(k+1)) == 4 &&
                    primeFactors(factor(k+2)) == 4 &&
                    primeFactors(factor(k+3)) == 4){
                return k;
            }
        }
        return -1;
    }



    public static void solve() {
        int ans = find(1000000);

        System.out.print(ans);

    }
}

