package problems1_100;

/**
 * Created by Lagrange on 3/31/2017.
 */
public class Problem_28 {
    static int size = 1001 * 1001;

    static int[] nums = new int[size];

    static void fill(){
        for(int k = 0; k < size; k++){
            nums[k] = k+1;
        }
    }

    static int count(){
        int sum = 0;
        int k = 2;
        int index = 0;
        int n = 0;
        while(index < size) {

            while (n < 4) {
                sum += nums[index];
                index += k;
                n++;
                if(index > size){
                    return sum;
                }
            }

            n = 0;
            k += 2;

        }
        return sum;

    }

    public static void solve(){
        fill();
        //System.out.print(nums.length);
        System.out.print(count());
    }



}
