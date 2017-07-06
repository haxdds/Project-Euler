package problems1_100;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;

/**
 * Created by Lagrange on 4/26/2017.
 */
public class Problem_59 {

    static int[] readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String[] array =  new String(encoded, encoding).split(",");
        for (int i = 0; i < array.length; i++)
            array[i] = array[i].replaceAll(" ", "");
        int[] vals = new int[array.length];
        for(int k = 0; k < array.length; k++)
            vals[k] = Integer.parseInt(array[k].trim());
        return vals;
    }



    static int getLowerCaseASCII(char c){
        return (int) Character.toLowerCase(c);
    }
    static char getChar(int ascii){
        return (char) ascii;
    }






    static double getCharFreq(String s, char c){
        int count = 0;
        s = s.replaceAll("\\s+","");
        for(int k = 0; k < s.length(); k++)
            if(Character.toLowerCase(s.charAt(k)) == c) count++;
        return (double)count/(double)s.length();
    }

    static boolean isWithinMargin(char c, double freq, double error){
        c = Character.toLowerCase(c);
        double e = .12702d;
        double t= .09056d;
        double a = .08167d;
        double o = .07507d;
        switch(c){
            case 'e':
                if(Math.abs(freq - e) < error) return true;
                return false;
            case 't':
                if(Math.abs(freq - t) < error) return true;
                return false;
            case 'a':
                if(Math.abs(freq - a) < error) return true;
                return false;
            case 'o':
                if(Math.abs(freq - o) < error) return true;
                return false;
            default:
                throw new IllegalArgumentException("Invalid character");
        }
    }

    static String decrypt(int[] data, int key1, int key2, int key3){
        String message = "";
        for(int k = 0; k < data.length; k += 3){

            if(k < data.length)
                message += getChar(key1 ^ data[k]);
            if(k + 1 < data.length)
                message += getChar(key2 ^ data[k+1]);
            if(k + 2 < data.length)
                message += getChar(key3 ^ data[k+2]);
        }
        return message;
    }


    public static void solve() {
        int[] data = null;
        try {
            data = readFile("p059_cipher.txt", StandardCharsets.UTF_8);
            System.out.println("File read Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(data));



        String s = decrypt(data,getLowerCaseASCII('g'),getLowerCaseASCII('o'),getLowerCaseASCII('d'));
        System.out.println(s);
        char[] c = s.toCharArray();
        int sum = 0;
        for(char k : c){
            sum += (int) k;
        }
        System.out.println(sum);

    }
}
