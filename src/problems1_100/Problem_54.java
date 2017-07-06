package problems1_100;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Lagrange on 4/11/2017.
 */
public class Problem_54 {
    static List<String[][]> hands = new ArrayList<>();


    static void readFile(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("p054_poker.txt"));
            String s = null;
            while((s = in.readLine()) != (null)){
                String[] source = s.split("\\s+");
                String[] part1 = new String[source.length/2];
                String[] part2 = new String[source.length/2];
                //              (src   , src-offset  , dest , offset, count)
                System.arraycopy(source, 0           , part1, 0     , part1.length);
                System.arraycopy(source, part1.length, part2, 0     , part2.length);

                String[][] a = {part1,part2};
                hands.add(a);
            }

            System.out.println("Successfully read and created");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static int handValue(String[] hand){
        int[] nums = new int[5];
        char[] suits = new char[5];
        int k = 0;
        int val = 0;
        for(String s: hand){
           char num = s.charAt(0);

           switch (num){
               case 'T':
                   nums[k] = 10;
                   suits[k] = s.charAt(1);
                   k++;
                   continue;
               case 'J':
                   nums[k] = 11;
                   suits[k] = s.charAt(1);
                   k++;
                   continue;
               case 'Q':
                   nums[k] = 12;
                   suits[k] = s.charAt(1);
                   k++;
                   continue;
               case 'K':
                   nums[k] = 13;
                   suits[k] = s.charAt(1);
                   k++;
                   continue;
               case 'A':
                   nums[k] = 14;
                   suits[k] = s.charAt(1);
                   k++;
                   continue;

           }

           nums[k] = Character.getNumericValue(s.charAt(0));
           suits[k] = s.charAt(1);
           k++;
        }
            Arrays.sort(nums);
            Arrays.sort(suits);
        System.out.println(Arrays.toString(nums) + "\n");
        System.out.print("Suits:" + Arrays.toString(suits) + "\n");
        //HighCard 2-14
        //onePair
        //twoPair
        //three of a kind
        //straight
        //flush
        //full house
        //four of a kind
        //straight flush
        //royal flush

        if(isConsecutive(nums) && isAllEqual(suits) && nums[0] == 10) {
            System.out.println("royal flush\n\n");
            val = 9000;
        }
        else if(isConsecutive(nums) && isAllEqual(suits)){
            System.out.println("straight flush\n\n");
            val = 8000 + nums[4];
        }
        else if(matches(nums) == 4) {
            System.out.println("four of a kind\n\n");
            val = 7000 + nums[2] + nums[4];
        }
        else if(matches(nums) == 3 && pairs(nums).length == 2){
            System.out.println("Full house\n\n");
            val = 6000 + nums[2];
        }
        else if(isAllEqual(suits)){
            System.out.println("flush\n\n");
            val = 5000 + nums[4];
        }
        else if(isConsecutive(nums)){
            System.out.println("straight\n\n");
            val = 4000 + nums[4];
        }
        else if(matches(nums) == 3){
            System.out.println("three of a kind\n\n");
            val = 3000 + nums[2]*4 + nums[4];
        }
        else if(pairs(nums).length == 2){
            System.out.println("two pairs\n\n");
            val = 2000 + pairs(nums)[0]*10 +  pairs(nums)[1]*20;
        }
        else if(pairs(nums).length == 1){
            System.out.println("one pair\n\n");
            val = 1000 + pairs(nums)[0]*10 + nums[4];
        }
        else{
            System.out.print("High card\n\n");
            val = nums[4];
        }

        return val;
    }

    public static boolean isAllEqual(char[] a){
        for(int i=1; i<a.length; i++){
            if(a[0] != a[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean isConsecutive(int[] a){

        for(int k = 1; k < a.length; k++){
            if(a[k] == 14 && a[0] == 2 ) return true;
            if(a[k] != a[k-1] + 1) return false;
        }

        return true;
    }
    public static int matches(int[] a){
        int maxMatches = 0;
        List<Integer> asList = new ArrayList<>();
        for(int i: a) asList.add(i);

        for(int k = 0; k < a.length; k++){
            int num = Collections.frequency(asList,a[k]);
            if(num > maxMatches) maxMatches = num;
        }

        return maxMatches;
    }
    public static int[] pairs(int[] a){
        Set<Integer> pairs = new HashSet<>();
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] == a[j]) pairs.add(a[i]);
            }
        }
        int[] b = new int[pairs.size()];
        int index = 0;
        for(Integer i: pairs){
            b[index++] = i;
        }
        return b;
    }







    public static void solve() {
        readFile();
        //System.out.println(hands.size());
        int ans = 0;
        int k = 1;
        for(String[][] i: hands){
            System.out.print("HAND " + k++ + "\n");
            System.out.println("\n--PLAYER ONE-----\n" +Arrays.toString(i[0]) + "\n");
            int o = handValue(i[0]);
            System.out.println("--PLAYER TWO-----\n" +Arrays.toString(i[1]) + "\n");
            int t = handValue(i[1]);
            if(o > t){
                System.out.print("player one wins");
                ans++;
            }
            else if(t > o) {
                System.out.print("player two wins");
                if(t - o < 10) System.out.print("\nWOOOOT");
            }
            else {
                System.out.print("wtf");
            }



            System.out.print("\n\n======\n\n");

        }

        System.out.print("\n\n\nANSWER: " + ans);
//        int[] a = {3,2,2,3,5};
//        System.out.print(pairs(a));
    }
}
