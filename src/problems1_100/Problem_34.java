package problems1_100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/3/2017.
 */
public class Problem_34 {

    static ArrayList<Integer> numbers = new ArrayList<>();

    public static long factorial(int n){
        long product = 1;
        for(long k = n; k > 0; k--){
            product *= k;
        }
        return product;
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

    public static long sumFactorials(int n){
        List<Integer> list = new ArrayList<>();
        list = getDigits(n);
        int sum = 0;
        for(Integer i: list){
            sum += factorial(i);
        }
        return sum;
    }


    public static boolean equalsFactorial(int n){
        if(n == sumFactorials(n)) return true;

        return false;
    }

    public static void check(int limit){

        for(int k = 11; k < limit; k++){
            if(equalsFactorial(k)) numbers.add(k);
        }

    }



    public static void solve(){
        check(100000000);
        //System.out.print(equalsFactorial(146));
        System.out.println(Arrays.toString(numbers.toArray()));

        int sum = 0;

        for (Integer i: numbers){
            sum += i;
        }

        System.out.println("sum: " + sum);
    }

}
