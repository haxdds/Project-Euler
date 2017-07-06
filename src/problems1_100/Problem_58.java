package problems1_100;

/**
 * Created by Lagrange on 4/14/2017.
 */
public class Problem_58 {





    static int[] fill(int size){
        int[] nums = new int[size];
        for(int k = 0; k < size; k++){
            nums[k] = k+1;
        }
        return nums;
    }

    static boolean isPrime(int n){

        if((int)Math.sqrt(n) == Math.sqrt(n)) return false;

        for(int k = 2; k < Math.sqrt(n); k++)
            if(n % k == 0) return false;
        return true;
    }

    static int count(int size){
        int[] nums = fill(size);
        int primes = 0;
        int count = 0;
        int k = 2;
        int index = 0;
        int n = 0;
        while(index < size) {

            while (n < 4) {
                //System.out.println(nums[index]);
                if(isPrime(nums[index])) primes++;
                index += k;
                n++;
                if(index > size ){
                    return primes;
                }

                count++;
            }

            n = 0;
            k += 2;

        }
        return primes;
    }







    public static void solve() {
        double ratio = 1;
        int length = 26219;

        //int a = count(length*length);

        while(ratio >= 0.10){

        int size = length * length;
        int primes = count(size);
        int diagonals = (2*length) - 1;
        ratio = (double)primes/(double)diagonals;
        System.out.print("\nLength: " + length);
        System.out.print("\nPrimes: " + primes);
        System.out.print("\nDiagonals: " + diagonals);
        System.out.print("\nRatio: " + ratio + "\n\n");
        length += 2;
        }

        System.out.print("\n\nAnswer: " + (length - 2));
    }
}
