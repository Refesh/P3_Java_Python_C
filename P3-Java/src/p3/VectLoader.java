package p3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VectLoader {
    public static int[] loadVectFile(String fileName){
        int [] s = null;
        try (FileReader read = new FileReader(fileName); BufferedReader br = new BufferedReader(read)) {
                s = stringArrayToInt(br.readLine().split(","));
        }catch(IOException e){
            e.printStackTrace();
        }
        return s;
    }
    
    private static int [] stringArrayToInt(String [] s){
        int[] res = new int[s.length];
        for(int i  = 0 ; i < s.length ; i++){
            res [i] = Integer.parseInt(s[i]);
        }
        return res;
    }
}