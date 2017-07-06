package problems1_100;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_67 {

    static List<Integer[]> num = new ArrayList<>();

    public static void filereader(String path) throws IOException{
        FileReader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);

        String line;
        while((line = br.readLine()) != null){

            String[] sa =line.split(" ");
            Integer[] na = new Integer[sa.length];
            for(int i = 0; i < sa.length; i++){
                na[i] = Integer.parseInt(sa[i]);
            }
            num.add(na);
        }
        in.close();
    }

    static Integer[] reduce(Integer[] top, Integer[] bot){
        if(top.length != bot.length - 1) System.out.println("Array Error");
        Integer[] reduced = new Integer[top.length];
        for(int i = 0; i < top.length; i++){
            if(bot[i] > bot[i+1]){
                reduced[i] = top[i] + bot[i];
            }else {
                reduced[i] = top[i] + bot[i + 1];
            }
        }
        return reduced;
    }

    static void getAns(){

        for(int i = num.size() - 1; i > 0; i--){
            num.add(i-1,reduce(num.get(i-1),num.get(i)));
        }

    }




    public static void solve(){
        try {
            filereader("p067_triangle.txt");
            System.out.println("file read");
        } catch (IOException e) {
            e.printStackTrace();
        }

       getAns();

//        int top = 0;
//        int bot = 1;
//
//        System.out.print("top: " + Arrays.toString(num.get(top)) + "\nbottom: " + Arrays.toString(num.get(bot)) +
//                "\nreduced: " +Arrays.toString(reduce(num.get(top),num.get(bot))));

        System.out.println("\n\n Answer: " + Arrays.toString(num.get(0)));
    }


	
}
