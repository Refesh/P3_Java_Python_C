package p3;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class EvaluateAlgorithm {
    static int [] vecs = null;
    public static void evaluate(String fileName){
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
        vecs = VectLoader.loadVectFile(fileName);
        double msInit = System.nanoTime();
        MayorityElement.findMajority(vecs,vecs.length);
        System.out.println(vecs.length + " elements" + "\nTime: \t" + df.format( (double) ((System.nanoTime()- msInit)/1000000000)) + " s\n");

    }
}
