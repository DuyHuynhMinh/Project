package util;

import constant.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileUtil {

    public static void write (String pathFile, String data, Boolean append) {

        System.out.println("Calling write data \n "+ data + "\n");

        try {

            File file = new File(pathFile);
            BufferedWriter output = new BufferedWriter(new FileWriter(file, append));
            output.write(data);
            output.close();

        } catch (IOException e) {
            System.out.println("Error write data \n "+ data + "\n");
            e.printStackTrace();
        }
    }

    public static void writeHeader(String pathFile,String header){
        write(pathFile,header,false) ;
    }

    public static Boolean isExistFile(String pathFileName) {
        File f = new File(pathFileName);
        return f.exists() && !f.isDirectory();
    }
}
