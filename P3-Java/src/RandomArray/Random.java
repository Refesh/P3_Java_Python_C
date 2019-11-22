package RandomArray;

import p3.VectSaver;

public class Random {
    public static void main(String[] args) {
        if(args.length == 1){
            int [] vecs = GenRandomArray.generate(Integer.parseInt(args[0]), 0, Integer.parseInt(args[0])/2);
            VectSaver.saveVectFile("..\\..\\ArraysFiles\\VecFile_" + args[0] + ".txt" , vecs);
        }else{
            System.out.println("Send through parameters the number of values of the array."
                    + "Then a random array will be created with the number of values and will be saved in the directory ..\\..\\ArraysFiles\\"
                    + "with the name VecFile_+ n + .txt  n is the number of values that the array have.");
        }
    }
}
