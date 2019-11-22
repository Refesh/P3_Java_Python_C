package p3;

import RandomArray.GenRandomArray;

public class P3 {
    public static void main(String[] args) {
        int [] vecs;
        double ms;
        String res ,param = "";
        for (String arg : args)param += arg + ",";
        int pos = param.indexOf("-f");
        if(param.indexOf("-h") == -1 && param.indexOf("-ev") == -1 &&((-1 != pos) || -1 != param.indexOf("-a"))){
            if(-1 != pos){
                int pos2 = param.indexOf("," , pos+3);
                vecs = VectLoader.loadVectFile(param.substring(pos + 3, pos2));
            }else{
                int pos2 = param.indexOf("-a");
                int n = Integer.parseInt(param.substring(pos2+3,param.indexOf(",",pos2+3)));
                vecs = GenWorstCase.generate(n);
            }
            double msInit = System.nanoTime();
            res = MayorityElement.findMajority(vecs,vecs.length);
            ms = System.nanoTime()- msInit;
            StringBuilder di = new StringBuilder("");
            if(-1 != param.indexOf("-di")){
                System.out.print("[");
                for(int w : vecs)di.append(w + ",");
                System.out.println(di.toString().substring(0, di.lastIndexOf(",")) + "]");
            }
            if( -1 != param.indexOf("-do"))System.out.println("\n"+ res.trim());
            if(-1 != param.indexOf("-dt"))System.out.println("Time: " + (ms/1000000000) + " s\n");
        } else if(param.indexOf("-h") != -1){
            System.out.println("Input switches\n" + 
                                "-a length : input initialized with ascending values\n" +
                                "-f filename : input data from given filename\n" +
                                "-ev :Evaluate and show how the algorithm works with diferent arrays sizes\n" +
                                "Display switches\n" +
                                "-dt : Display time in seconds\n" +
                                "-di : Display input\n" +
                                "-do : Display output");
        }else if(param.indexOf("-ev") != -1){
            String s = "..\\..\\ArraysFiles\\VecFile_";
            EvaluateAlgorithm.evaluate(s + 200 + ".txt");
            EvaluateAlgorithm.evaluate(s + 500 + ".txt");
            EvaluateAlgorithm.evaluate(s + 1000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 3000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 5000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 10000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 15000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 20000 + ".txt");
            EvaluateAlgorithm.evaluate(s + 25000 + ".txt");
        }else System.out.println("ERROR");
    }     
}