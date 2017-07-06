package problems1_100;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_39 {

    static Map<Integer, Integer> sqre = new HashMap<>();

    static List<Integer[]> triplets = new ArrayList<>();

    static Map<Integer, Integer> perimeter = new HashMap<>();

    static void fill(int limit){
        for(int k = 1; k < limit; k++){
            int s = (int)Math.pow(k,2);
            sqre.put(k,s);
        }
    }


    static void findTrips(){

        for(Integer i: sqre.keySet()){
            System.out.println(i);
            for(Integer j: sqre.keySet()){
                if(sqre.containsValue(sqre.get(i) - sqre.get(j))) {
                    Integer[] trip = {i,j,(int)Math.sqrt(sqre.get(i)-sqre.get(j))};
                    Arrays.sort(trip);
                    triplets.add(trip);

                }

            }
        }

    }

    static void sum(){
        for(Integer[] i: triplets){
            int p = i[0] + i[1] + i[2];
            if(perimeter.get(p) != null){
              perimeter.put(p, perimeter.get(p) + 1);
            }else{
                perimeter.put(p,1);
            }
        }
    }








    public static void solve(){
        fill(1000);
        System.out.println(sqre);
        findTrips();
//        HashSet<Integer[]> set = new HashSet<>(triplets);
//        triplets = new ArrayList<>(set);

        System.out.println("Length: " + triplets.size());
        sum();

//        for(Integer[] i: triplets){
//            System.out.println(Arrays.toString(i));
//        }


        System.out.print("\n\n" + perimeter);

        int max = 12;
        for(Integer i: perimeter.keySet()){
            if(perimeter.get(i) > perimeter.get(max) && i <= 1000)
                max = i;
        }
        System.out.println("\n-----------\n");
        System.out.println("\n\nMax Solutions: P: " + max + " N: " + perimeter.get(max));


    }
}
