package com.feilis.bIo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName BIOServer
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/20 16:51
 * @Version V1.0
 * <p>
 * java BIO实现 阻塞IO实现
 */
public final class BIOServer {
    private static final int PORT = 9999; //默认连接端口
    private static ServerSocket server;  //单例的ServerSocket


    public static void main(String[] args) throws IOException {
        new BIOServer().start();
    }

    void start() throws IOException {
        //使用线程池
        ExecutorService ProcessPool = Executors.newCachedThreadPool();
        server = new ServerSocket(PORT);
        System.out.println("服务启动ok......");
        while (true) {
            //等待客户端连接
            final Socket client = server.accept();
            System.out.println("接收到一个客户端连接");

            ProcessPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(client);
                }
            });
        }
    }

    public static void handler(Socket client) {
        byte[] bytes = new byte[1024];

        try {
            //获取输入流
            InputStream inputStream = client.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
