package p3;

public class P3 {
    public static void main(String[] args) {
        String res;
        String param = "";
        int [] vecs;
        double ms;
        for (String arg : args)param += arg + ",";
        int pos = param.indexOf("-f");
        if(param.indexOf("-h") == -1 && param.indexOf("-ev") == -1 &&((-1 != pos) || -1 != param.indexOf("-r") || -1 != param.indexOf("-wc"))){
            if(-1 != pos){
                int pos2 = param.indexOf("," , pos+3);
                vecs = VectLoader.loadVectFile(param.substring(pos + 3, pos2));
            }else if(-1 != param.indexOf("-r")){
                vecs = GenRandomArray.generateRandomSlantedArray(88700,0,30000);
                VectSaver.saveVectFile("..\\..\\ArraysFiles\\VecFile_2000.txt", vecs);
                System.out.println("Array with 20000 elements.");
            }else{
                vecs = GenWorstCase.generate(4000);
            }
            double msInit = System.nanoTime();
            res = MayorityElement.findMajority(vecs,vecs.length);
            ms = System.nanoTime()- msInit;
            if(-1 != param.indexOf("-di")){
                System.out.print("[");
                for(int w : vecs)System.out.print(w + ",");
                System.out.println("]");
            }
            if( -1 != param.indexOf("-do"))System.out.println("\n"+ res.trim());
            if(-1 != param.indexOf("-dt"))System.out.println("\nTime: " + (ms/1000000000) + " seg.");
        } else if(param.indexOf("-h") != -1){
            System.out.println("Input switches\n" + 
                                "-wc : Generate the worst case with 20000 values.\n" +
                                "-f filename : input data from given filename\n" +
                                "-r Generate array with pseudorandom values and save them ArrayFiles\n" +
                                "-ev :Evaluate and show how the algorithm works with diferent arrays sizes.\n" +
                                "Display switches\n" +
                                "-dt : Display time in miliseconds\n" +
                                "-di : Display input\n" +
                                "-do : Display output");
        }else if(param.indexOf("-ev") != -1){
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_10.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_100.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_200.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_400.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_600.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_800.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_1000.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_1500.txt");
            EvaluateAlgorithm.evaluate("..\\..\\ArraysFiles\\VecFile_2000.txt");
        }else System.out.println("ERROR");
    }     
}