package problems1_100;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Problem_22 {

    public static Map<Character, Integer> amap = new HashMap<Character, Integer>();
    public static List<String> str = new ArrayList<>();

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    static void fillmap() {
        int k = 1;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            amap.put(alphabet, k++);

        }
    }


    static String[] toArr(String s) {
        String yourString = s;

        String[] array = yourString.split(",\"");
        for (int i = 0; i < array.length; i++)
            array[i] = array[i].replaceAll("\"", "");

        return array;
    }


    static int stringVal(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            val += amap.get(c);
        }
        return val;
    }


    static int nameval() {
        int val = 0;
        for (int k = 0; k < str.size(); k++) {
            int pos = k + 1;
            int tempval = stringVal(str.get(k)) *  pos;
            if(pos == 938)
            System.out.println(str.get(k) + ": " +  ": " + pos + ": " + stringVal(str.get(k)) + ":" + tempval);

            val += tempval;

        }
        return val;
    }


    static void problem22() {
        String s;

        int val = 0;

        try {
            s = readFile("p022_names.txt", StandardCharsets.UTF_8);

            System.out.println("File successfully read.");
            str = Arrays.asList(toArr(s));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(str);

//        for(int k = 0; k < str.size(); k++) {
//            System.out.println((k+1) + ": " +str.get(k));
//        }
        fillmap();
//        for(Character c : amap.keySet()){
//            System.out.println(c + " : " + amap.get(c));
//        }

        val = nameval();


        System.out.println(val);
    }


}