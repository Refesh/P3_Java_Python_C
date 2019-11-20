package p3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VectSaver {
    public static void saveVectFile(String fileName,int [] vec){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(fileName);
            pw = new PrintWriter(fichero);
            for(int i = 0 ; i< vec.length ; i++){
                pw.print(vec[i] + ",");
            }
            pw.print(vec[vec.length-1]+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
            }           
        }
    }
}