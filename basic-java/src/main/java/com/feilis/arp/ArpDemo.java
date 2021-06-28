package com.feilis.arp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName ArpDemo
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/23 11:54
 * @Version V1.0
 */
public class ArpDemo {
    public static void main(String[] args) {
        ArpDemo.start();
    }

    static void start() {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "arp -a");
            Process process=builder.start();
            InputStream reader=process.getInputStream();
            InputStreamReader streamReader=new InputStreamReader(reader,"GBK");
            BufferedReader br=new BufferedReader(streamReader);
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
