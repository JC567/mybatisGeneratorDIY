/*
Copyright: 恒生电子股份有限公司.All rights reserved
*/
package com.jc.utls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * file处理工具类
 *
 * @author jincheng19253
 * @date 2019/1/26
 */
public class FileUtils {
    /**
     * 获取当前目录
     * @return
     **/
    public static String getLocalPath(){
        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){}
        return directory.getAbsolutePath();
    }
    /**
     *  写数据到文件中
     * @param path
     * @param content
     * @return
     **/
    public static void writeToFile(String path, String content){
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *  写数据到文件中
     * @param path
     * @param contents
     * @return
     **/
    public static void writeToFile(String path, List<String> contents){
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String content:contents) {
                bw.write(content);
                bw.write("\n");
            }
            bw.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 判断文件是否存在
     * @param filePath  文件路径
     * @return
     */
    public static boolean fileExist(String filePath){
        boolean flag = false;
        File file = new File(filePath);
        flag = file.exists();
        return flag;
    }
    /**
     *  删除文件
     * @param path
     * @return
     **/
    public static void delFile(String path){
        File file=new File(path);
        if(file.exists()&&file.isFile()){
            file.delete();
    }}
    /**
     *  创建文件
     * @param path
     * @return
     **/
    public static void createFile(String path) throws IOException {
        File file=new File(path);
        file.createNewFile();
    }
    /*
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static List<File> listDirectory(File dir)throws IOException {
        List<File> reFiles=new ArrayList<>();
        if(!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        /*String[] filenames=dir.list();//返回的是字符串数组 直接子的名称 不包含子目录
        for(String string:filenames){
            System.out.println(dir+"\\"+string);
        }*/
        //如果要遍历子目录下的内容就需要构造File对象做递归操作，File提供了直接返回File对象的API
        File[] files=dir.listFiles();
        //for(File file:files){
        //System.out.println(file);
        if(files!=null&&files.length>0){
            for(File file:files){
                if(file.isDirectory()) {
                    //递归
                    reFiles.addAll(listDirectory(file));
                }
                else {
                    //System.out.println(file);
                    reFiles.add(file);
                }
            }
        }
        return reFiles;
    }
    /**
     * 获取文件后缀名
     * @param file
     * @return
     **/
    public static String getSuffix(File file) {
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }
}
