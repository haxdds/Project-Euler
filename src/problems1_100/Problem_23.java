package problems1_100;
//
//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//
//        A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//
//        As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//
//        Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


import java.util.ArrayList;
import java.util.Collections;

public class Problem_23 {

    public static ArrayList<Integer> abundantList = new ArrayList<>();


    public static boolean checkAbundant(int x){
        int sum = 1;
        int squareroot = (int) Math.sqrt(x);
        for(int k = 2; k <= squareroot; k++){
            if(x % k == 0) {
                sum += k;
                sum += x / k;
            }
        }
        if(squareroot * squareroot == x) sum -= squareroot;
        return sum > x;
    }


    public static void fill(int MAX){
        for(int k = 1; k <= MAX; k++){
            if(checkAbundant(k)) abundantList.add(k);
        }
    }


    public static boolean isSum(int x){
        for(Integer m : abundantList){
            int diff = x - m;
            if(diff < 0) return false;
            if(abundantList.contains(diff)) return true;
        }
        return false;
    }


    public static int findsum(int MAX){
        int total = 0;
        for(int k = 1; k < MAX; k++){
            if(!isSum(k)) total += k;

        }
        return total;
    }
    public String vo(){return "s";}
    public static void solve(){
        fill(28123);
        //System.out.print(checkAbundant(12));
//        for(Integer m: abundantList){
//            System.out.println(m);
//        }

        if(true)
            isSum(3);
        Collections.sort(abundantList);
        System.out.print(findsum(28123));

    }









}