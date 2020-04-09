package com.jc;

import com.jc.utls.FileUtils;
import com.jc.utls.ReadFromFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: StartUp.java
 * @Package com.fendo.mybatis_generator_plus
 * @Description: TODO
 * @author fendo
 * @date 2017年10月5日 下午3:53:17
 * @version V1.0
 */
public class StartUp {

    private static String[] tables = new String[]{"IIA_TADJUSTPOSITION",
            "IIA_TCOMBINFO",
            "IIA_TCOMBPOSITION",
            "IIA_TCOMBTAGRELATION",
            "IIA_TCOMBVALUE",
            "IIA_TKYCQUESTION",
            "IIA_TKYCQUESTIONOPTION",
            "IIA_TKYCQUESTIONSUBJECT",
            "IIA_TKYCOPTIONTAGRELATION",
            "IIA_TPRODUCTINFO",
            "IIA_TPRODUCTMARKET",
            "IIA_TTAG"};
    private static String path = "D:\\Hundsun\\XProject\\mybatisGenerator\\src\\main\\resources\\mybatis-generator-config.xml";

    public static void main(String[] args) throws URISyntaxException {
            //runByTable(tables[10]);
        runGenerator();
    }

    /**
     * 根据某表名，获取其dao，po和mapper层
     *
     * @param tableName
     * @return
     **/
    public static void runByTable(String tableName) {
        List<String> strList = ReadFromFile.read(path);
        List<String> tarStrList = new ArrayList<>();
        for (String s : strList) {
            //System.out.println(s);
            if (s.contains("enableCountByExample")) {
                //System.out.println(s);
                String tarS1 = s.substring(0, s.indexOf("\"") + 1);
                s = s.substring(s.indexOf("\"") + 1);
                //System.out.println(tarS1);
                String tarS2 = s.substring(0, s.indexOf("\""));
                String tarS3 = s.substring(s.indexOf("\""));
                //System.out.println(tarS2);
                //System.out.println(tarS3);
                //System.out.println(tarS1+tarS2+tarS3);
                s = tarS1 + tableName + tarS3;
            }
            tarStrList.add(s);
        }
        FileUtils.delFile(path);
        FileUtils.writeToFile(path, tarStrList);


        //MyThread myThread=new MyThread();
        //myThread.tableName=tableName;
        //Thread my=new Thread(myThread);
        //my.start();
    }

    /**
     * 调用mybatis工具生成代码
     *
     * @return
     **/
    public static void runGenerator() {
        try {
            System.out.println("--------------------start generator-------------------");
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("mybatis-generator-config.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("--------------------end generator-------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread implements Runnable {
        String tableName;
        @Override
        public void run() {
            System.out.println("MyThread.run()");
            System.out.println(tableName);
            try {
                runGenerator();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(tableName);
        }
    }

}