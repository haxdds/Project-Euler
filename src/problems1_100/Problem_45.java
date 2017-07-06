package problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Lagrange on 4/7/2017.
 */
public class Problem_45 {
    static HashSet<Long> tri = new HashSet<>();
    static HashSet<Long> pent = new HashSet<>();
    static HashSet<Long> hex = new HashSet<>();

    static List<Long> all = new ArrayList<>();

    static void fill(int limit){
        for(long k = 1; k <= limit; k++){
            tri.add(k * (k + 1) / 2);
            pent.add(k * ((3*k) - 1) / 2);
            hex.add(k * ((2*k) - 1));
        }
    }
    static void find(){
        //int k = 0;
        for(Long i: tri){
            //System.out.println(k++);
            if(pent.contains(i) && hex.contains(i)) all.add(i);
        }

    }



    public static void solve() {
        fill(500000);
        find();

        System.out.print(Arrays.toString(all.toArray()));

    }
}
