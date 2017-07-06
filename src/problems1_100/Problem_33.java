package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lagrange on 4/3/2017.
 */
public class Problem_33 {

    static Fraction removeCommonDigit(Fraction f){
        int num = f.getNumerator();
        int den  = f.getDenominator();

        List<Integer> numDigits = getDigits(num);
        List<Integer> denDigits = getDigits(den);
        List<Integer> common = new ArrayList<>();

        for(Integer i: numDigits){
            if(i != 0)
                if(denDigits.contains(i)){
                    common.add(i);
                    break;
                }

        }

        numDigits.removeAll(common);
        denDigits.removeAll(common);
        return new Fraction(numFromList(numDigits),numFromList(denDigits));
    }



    public static List<Integer> getDigits(int x){
        List<Integer> d = new ArrayList<>();
        int temp = x;
        while(temp != 0){
            int digit = temp % 10;
            d.add(digit);
            temp /= 10;
        }
        Collections.reverse(d);
        return d;
    }

    static int numFromList(List<Integer> l){
        int num = 0;
        for(Integer i: l){
            num += i;
            num *= 10;
        }

        return num/10;
    }

    public static void solve(){
        Fraction f = new Fraction(1,1);

        for(int k = 10; k < 100; k++) {
            for (int j = k; j < 100; j++) {
                if(j == k) continue;
                Fraction f1 = new Fraction(k, j);
                Fraction f2 = removeCommonDigit(f1);
                if(!f1.is(f2)){
                    if(f1.equals(f2)){
                        System.out.print("\n" + f1.toString());
                        f = f.multiply(f1);
                    }
                }
            }
        }
        f = f.simplify();
        System.out.print("\n\n\n\n\n" + f.toString());

    }



}


