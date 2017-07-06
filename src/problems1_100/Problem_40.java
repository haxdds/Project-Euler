package problems1_100;

/**
 * Created by Lagrange on 4/4/2017.
 */
public class Problem_40 {

    static String num = "";

    public static void concate(int limit){

        for(int i = 1; i <= limit; i++){
            if(i % 10000 == 0) System.out.println(i);

            num += String.valueOf(i);
        }
    }

    public static int retrieveInt(int index){
        return Character.getNumericValue(num.charAt(index-1));
    }




    public static void solve(){
        concate(250000);
        int d1 =  retrieveInt(1);
        int d2 =  retrieveInt(10);
        int d3 =  retrieveInt(100);
        int d4 =  retrieveInt(1000);
        int d5 =  retrieveInt(10000);
        int d6 =  retrieveInt(100000);
        int d7 =  retrieveInt(1000000);

        int ans = d1 * d2 * d3 * d4 * d5 * d6 * d7; //
        System.out.println(num);
        System.out.print("\n" + d1 + "\n" + d2 + "\n" + d3 +"\n" + d4 + "\n" + d5);

        System.out.print("\nanswer: " + ans);
    }
}
