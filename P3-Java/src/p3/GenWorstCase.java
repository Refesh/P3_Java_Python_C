package p3;

public class GenWorstCase {
    public static int[] generate(int numberElements){
        int [] res = new int[numberElements];
        for(int i = 0 ; i<numberElements ; i++)res[i]   = i;
        return res;
    }
}
