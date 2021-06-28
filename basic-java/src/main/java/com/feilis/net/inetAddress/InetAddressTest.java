package com.feilis.net.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.*;

/**
 * @ClassName InetAddressTest
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/22 11:38
 * @Version V1.0
 *
 * java 中 InetAddress 类代表某一计算机
 */
public class InetAddressTest {

    public static void main(String[] args) {
        InetAddressTest.test();
    }

    static void test(){
        try {

            //InetAddress iA1= InetAddress.getLocalHost();
            //System.out.println(iA1);
            InetAddress IA2 = InetAddress.getByName("www.baidu.com");
            System.out.println(IA2);
            System.out.println(IA2.getHostName());
            System.out.println(IA2.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
