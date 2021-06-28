package com.feilis.noIo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NioServer
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/18 14:30
 * @Version V1.0
 * <p>
 * java NOIO(非阻塞IO)实现机制
 */
public class NioServer {
    private int port; //端口
    private Selector selector;// 服务端用于监听的selector
    private ExecutorService service = Executors.newFixedThreadPool(5);//固定线程5个

    public static void main(String[] args) throws IOException {
        new NioServer(9099).start();
    }

    public NioServer(int port) {
        this.port = port;
    }

    public void init() {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();                  //获取一个ServerSocketChannel通道
            ssc.configureBlocking(false);                      //设置为非阻塞的
            ssc.bind(new InetSocketAddress(port));             //绑定端口
            selector = Selector.open();                        //获取一个监听器
            ssc.register(selector, SelectionKey.OP_ACCEPT);    //把channal注册到selector 事件位 OP_ACCEPT(连接接受事件)
            System.out.println("NIO server is started.....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        System.out.println("accept a client : " + sc.socket().getInetAddress().getHostName());
    }

    public void start() throws IOException {
        this.init();
        //循环等待客户端连接
        while (true) {
            //select block方法 可以设置超时事件timeout
            int events = selector.select();
            if (events > 0) {
                //Set<SelectionKey> selectionKeys= selector.selectedKeys();
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {
                    SelectionKey key = selectionKeys.next();
                    selectionKeys.remove();
                    if (key.isAcceptable())
                        accept(key);
                    else
                        service.submit(new NioServerHandler(key));
                }
            }
        }
    }

    static class NioServerHandler implements Runnable {

        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println("收到客户端" + socketChannel.socket().getInetAddress().getHostName() + "的数据：" + new String(buffer.array()));
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    socketChannel.write(outBuffer); //将消息反馈给客户端
                    selectionKey.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}