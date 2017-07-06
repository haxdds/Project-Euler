package problems1_100;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lagrange on 4/5/2017.
 */
public class Problem_42 {

    static HashMap<Character, Integer> charMap = new HashMap<>();
    static List<Integer> triangleNum = new ArrayList<>();

    static String fileReader(String path, Charset encoding) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded,encoding);
    }

    static String[] toArr(String in){
        String s = in;
        String[] arr = s.split(",\"");
        for(int i = 0; i < arr.length; i++)
            arr[i] = arr[i].replace("\"", "");

        return arr;
    }

    static void fillMap(HashMap<Character, Integer> cMap){
        int k = 1;
        for(char x = 'A'; x <= 'Z'; x++)
            cMap.put(x,k++);
    }

    static int stringVal(String s){
        int val = 0;
        for(int i = 0; i < s.length(); i++)
            val += charMap.get(s.charAt(i));

        return val;

    }

    static void generateTriangleNumbers(int limit){
        for(int n = 1; n <= limit; n++){
            triangleNum.add(n * (n + 1) / 2);
        }
    }

    public static void solve(){
        fillMap(charMap);
        generateTriangleNumbers(1000);
//        System.out.println(Arrays.toString(triangleNum.toArray()));
//        System.out.print(StringVal("ABC"));

        String s = null;
        try {
            s =fileReader("p042_words.txt", StandardCharsets.UTF_8);
            System.out.print("\n file read successfully. \n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = toArr(s);
        List<String> triword = new ArrayList<>();
        int n = 0;
        for(int k = 0; k < words.length; k++){
            if(triangleNum.contains(stringVal(words[k]))){
                n++;
                triword.add(words[k]);
            }
        }

        System.out.println("Answer: " + n);

        System.out.println("Triangle words:\n" + Arrays.toString(triword.toArray()) );





    }



}
