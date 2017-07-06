package problems1_100;

/**
 * Created by Lagrange on 3/31/2017.
 */
public class Problem_27 {

    public static int func(int n, int a, int b) {
        return ((n * n) + (a * n) + (b));
    }


    public static boolean isPrime(int x) {
        int i = Math.abs(x);


        int sqrt = (int) Math.sqrt(i);
        for (int k = 2; k < Math.sqrt(i); k++) {

            if (i % k == 0)
                return false;


        }

        if (sqrt * sqrt == i) return false;

        return true;
    }


    public static int[] check() {
        int maxA = 0;
        int maxB = 0;
        int maxCount = 0;
        for (int a = -999; a < 1000; a++) {

            for (int b = -1000; b <= 1000; b++) {

                System.out.print("\t" + "a: " + a + "\tb:" + b);

                int primeCount = 0;


                for (int n = 0; n < 1000; n++) {
                    if (isPrime(func(n, a, b))) {
                        primeCount++;
                    } else {
                        break;
                    }
                }
                if (primeCount > maxCount) {
                    maxA = a;
                    maxB = b;
                    maxCount = primeCount;
                }
                System.out.print("\tprimes: " + primeCount + "\n");

            }


        }


        int[] arr = {maxA, maxB, maxCount};

        return arr;
    }


    public static void solve() {

//        System.out.println(isPrime(-8));

        int[] ans = check();
        System.out.print("\n\n -------------- \n\n");
        for (int i : ans) {
            System.out.println(i);
        }
        System.out.println("\nproduct:" + (ans[0] * ans[1]));
//        for(int n = 0; n < 41; n++) {
//            System.out.println(isPrime(func(n, -999, -1000)));
//        }
//


    }

}
