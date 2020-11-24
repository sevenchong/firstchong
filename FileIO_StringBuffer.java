package com.kgc;

import java.io.*;

public class FileIO_StringBuffer {

    public static void main(String[] args) {
        //文件读取到StringBuffer
        StringBuffer sb = new StringBuffer();

        String filePath = "src/log.log";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String str;
            while((str = br.readLine())!= null){
                //将读取的数据添加到StringBuffer中
                sb.append(str);
                //行尾加换行符
                sb.append("\n");
            }
            System.out.println(sb);
            br.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //写入文件
        String targetPath = "src/log1.log";
        //新建文件
        File f = new File(targetPath);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
