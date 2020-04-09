package com.jc.utls;/*
Copyright: 恒生电子股份有限公司.All rights reserved
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author jincheng19253
 * @date 2018/11/3
 */
public class ReadFromFile {
    public static void main(String[] args) throws IOException {
        String srcPath="D:\\tradecenter_1029_4.sql";
        String srcPtah2="D:\\trade_center.sql";
        read(srcPtah2);
    }
    /**
     * 按行读取文件
     * @param path
     * @return
     **/
    public static List<String> read(String path) {
        List<String> reStr=new ArrayList<String>();
        try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
            File file = new File(path);
            FileReader reader = new FileReader(file);
            FileInputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));

            String str = null;

            while((str = br.readLine()) != null) {
                sb.append(str+"\r\n");
                    //System.out.println(str);
                reStr.add(str);
            }

            br.close();
            reader.close();


        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return reStr;
    }
    //public static void writeToFile (String path) throws IOException {
    //    // writeToFile string to file
    //    FileWriter writer = new FileWriter("c://test2.txt");
    //    BufferedWriter bw = new BufferedWriter(writer);
    //    bw.writeToFile();
    //
    //    bw.close();
    //    writer.close();
    //}
}

//import java.io.BufferedReader;
//        import java.io.BufferedWriter;
//        import java.io.FileNotFoundException;
//        import java.io.FileReader;
//        import java.io.FileWriter;
//        import java.io.IOException;


