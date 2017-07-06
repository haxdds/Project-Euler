package problems1_100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Lagrange on 3/31/2017.
 */
public class Problem_29 {
    public static ArrayList<BigInteger> nums;

    public static BigInteger power(BigInteger a, int b){
        return a.pow(b);
    }

    public static void fill(){
        HashSet<BigInteger> temp = new HashSet<>();

        for(int a = 2; a <= 100; a++){
            BigInteger bi = BigInteger.valueOf(a);
            for(int b = 2; b <= 100; b++){
                temp.add(power(bi,b));
            }
        }

        nums = new ArrayList<>(temp);
    }



    public static void solve(){
        //BigInteger bi = BigInteger.valueOf(100);

        fill();
        System.out.print(nums.size());

    }

}
