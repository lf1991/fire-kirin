package com.feilis.noIo.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOFileChannel01
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/27 23:55
 * @Version V1.0
 */
public class NIOFileChannel {
    public static void main(String[] args) throws Exception {
        //NIOFileChannel.writeFile();
        NIOFileChannel.readFile();
    }

    //使用通道写文件
    static void writeFile() throws Exception {
        String str = "hello feilis";
        String path = "E:\\workspace\\workspace_architect\\fire-kirin\\datas\\NIO\\hello.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        //通过fileOutputStream获取对应的 FileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建一个缓冲区 1024字节大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将str字节写入到buffer中
        buffer.put(str.getBytes());
        //buffer反转
        buffer.flip();
        //将buffer中的数据写入到当前的fileChannel
        fileChannel.write(buffer);
        //关闭流
        fileOutputStream.close();
    }

    static void readFile() throws Exception {
        String path = "E:\\workspace\\workspace_architect\\fire-kirin\\datas\\NIO\\testRead.txt";
        //创建文件类
        File fs = new File(path);
        //创建文件的输入流
        FileInputStream fileInputStream = new FileInputStream(fs);
        //获取对应输入流的Channel通道
        FileChannel channel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int) fs.length());
        //将通道中的数据写到buffer
        channel.read(buffer);
        //将buffer中的字节转换成字符串
        System.out.println(new String(buffer.array()));
        fileInputStream.close();

    }
}
