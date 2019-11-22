package RandomArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenRandomArray {
    static int n1;
    static int n2;
    static int n3;
    static int n4;
    
    public static int[] generate(final int length, final int minVal, final int maxVal) {
        List<Integer> data = new ArrayList<>(length-1);
        Integer rndNum;
        
        n1 = getRandomVal(minVal, maxVal);
        n2 = getRandomVal(minVal, maxVal);
        n3 = getRandomVal(minVal, maxVal);
        n4 = getRandomVal(minVal, maxVal);
        for (int i = 0; i < length-1; i++) {
            rndNum = getRandomVal(minVal, maxVal);
            data.add(rndNum);
        }
        return data.stream().mapToInt(i -> i).toArray();
    }
    private static int getRandomVal(int min, int max) {
        double d = Math.random();
        if(d <= 0.5){
            return n1;
        }else if(d<=0.65){
            return n2;
        }else if(d<=0.75){
            return n3;
        }else if(d<=0.8){
            return n4;
        }else{
            return (int)(min + (max - min + 1) * Math.random());
        }
    }
}
