package problems1_100;

import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.util.Arrays;

//The Fibonacci sequence is defined by the recurrence relation:
//
//        Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
//        Hence the first 12 terms will be:
//
//        F1 = 1
//        F2 = 1
//        F3 = 2
//        F4 = 3
//        F5 = 5
//        F6 = 8
//        F7 = 13
//        F8 = 21
//        F9 = 34
//        F10 = 55
//        F11 = 89
//        F12 = 144
//        The 12th term, F12, is the first term to contain three digits.
//
//        What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
/**
 * Created by Lagrange on 3/30/2017.
 */
public class Problem_25 {

    static BigInteger fib1 = BigInteger.ONE;
    static BigInteger fib2 = BigInteger.ONE;


    public static int getNumLength(BigInteger b){
        int count = 0;
        BigInteger temp = b;
        while(!temp.equals(BigInteger.ZERO)){
            temp = temp.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }

    public static BigInteger getNextFibo(BigInteger b1, BigInteger b2){
        return b1.add(b2);
    }

    public static BigInteger[] getFibo(){
        BigInteger n = BigInteger.valueOf(3);
        BigInteger f1 = fib1;
        BigInteger f2 = fib2;
        BigInteger f3 = getNextFibo(fib1,fib2);
        while(getNumLength(f3) < 1000){
            BigInteger temp = f3;
            f3 = getNextFibo(f2,f3);
            f2 = temp;
            n = n.add(BigInteger.ONE);
        }

        BigInteger[] ba = {n,f3};
        return ba;
    }




    public static void solve(){
        BigInteger big = BigInteger.valueOf(10946);
        System.out.println("length: " + getNumLength(big));

        System.out.println("n: "+ getFibo()[0] + "\t num:" + getFibo()[1]);



    }


}
