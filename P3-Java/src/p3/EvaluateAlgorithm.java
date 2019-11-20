package p3;

public class EvaluateAlgorithm {
    static int [] vecs = null;
    public static void evaluate(String fileName){
        vecs = VectLoader.loadVectFile(fileName);
        double msInit = System.nanoTime();
        MayorityElement.findMajority(vecs,vecs.length);
        System.out.println("MajorityNumber_"+ vecs.length + "\t  Time: \t" + (System.nanoTime()- msInit)/1000000000 + " seg");
    }
}
