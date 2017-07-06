package problems1_100;

import java.util.ArrayList;

/**
 * Created by Lagrange on 3/31/2017.
 */
public class Problem_30 {

    public static ArrayList<Integer> nums = new ArrayList<>();

    public static int powSumDigits(int x){
        int power = 5;
        int digit;
        int temp = x;
        int sum = 0;

        while(temp != 0){
            digit = temp % 10;
            sum += Math.pow(digit,power);
            temp /= 10;
        }

        return sum;
    }

    public static void find(int limit){
        for(int k = 2; k < limit; k++){
            if(powSumDigits(k) == k) nums.add(k);
        }
    }




    public static void solve(){
        long start = System.nanoTime();

        find(100000000);
        int sum = 0;
        for(int i: nums){
            sum += i;
            System.out.println(i);
        }

        System.out.println("sum: " + sum);



        long end = System.nanoTime();
        double runtime = end - start;
        runtime /= 1000000000;
        System.out.println("time: "+ runtime);

    }


}
