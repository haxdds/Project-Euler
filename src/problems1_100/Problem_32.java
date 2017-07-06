package problems1_100;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Lagrange on 4/1/2017.
 */
public class Problem_32 {
    static Integer[] da = {1,2,3,4,5,6,7,8,9};
    static HashSet<Integer> products = new HashSet<>();

    public static boolean isPandigital(int multiplicand, int multiplier){
            int product = multiplicand * multiplier;
            List<Integer> digits = new ArrayList<>();

            digits.addAll(getDigits(multiplicand));
            digits.addAll(getDigits(multiplier));
            digits.addAll(getDigits(product));
            Integer[] arr = new Integer[digits.size()];
            arr = digits.toArray(arr);
            Arrays.sort(arr);
            if(arr.length != da.length) return false;
            //System.out.println(Arrays.toString(arr));
            for(int k = 0; k < arr.length; k++){
                            if(arr[k] != da[k]) return false;
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

    public static void check(){


        for(int m1 = 0; m1 <5000; m1++){
            System.out.println(m1);
            for(int m2 = m1; m2 < 5000; m2++){
                if(isPandigital(m1,m2))
                    products.add(m1 * m2);
            }
        }


    }



    public static void solve(){
        check();
        System.out.print("\n\n----------------\n\n");
        System.out.print(Arrays.toString(products.toArray()));
        int sum = 0;
        for(Integer i: products){
            sum += i;
        }
        System.out.print("\n\n --- sum-----\n" + "Sum = " + sum);



    }



}
