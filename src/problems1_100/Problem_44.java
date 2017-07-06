package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_44 {

    static List<Integer> pent = new ArrayList<>();

    static void getPent(int limit){
        for(int k = 1; k <= limit; k++){
            pent.add(k*((3*k) -1 ) / 2);
        }
    }

    static boolean sdPent(int p1, int p2){
        if(p1 < p2) {
            System.out.println("p1 < p2");
            return false;
        }


        if(pent.contains(p1 - p2) && pent.contains(p1 + p2)) return true;

        return false;
    }

    static int find(){
        int minDiff = Integer.MAX_VALUE;

        for(int k = pent.size() - 1; k > 0; k--){
            for(int m = 0; m < k;m++){
                System.out.println(k + "   " + m);
                if(sdPent(pent.get(k),pent.get(m))){
                    System.out.print("p1: " + pent.get(k) + " p2:" + pent.get(m) );
                    if(pent.get(k) - pent.get(m) < minDiff){
                        minDiff = pent.get(k) - pent.get(m);
                    }
                }
            }

        }
        return minDiff;

    }






    public static void solve() {

        getPent(3000);
        int ans = find();
        System.out.print(ans);
    }
}
