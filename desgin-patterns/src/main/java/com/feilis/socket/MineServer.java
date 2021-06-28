package com.feilis.socket;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName MineServer socke服务端
 * @Description TODO
 * @Author lf199
 * @Date 2021/5/9 17:34
 * @Version V1.0
 */
public class MineServer {
    private final static int PORT = 11111;
    private final static int BAKLOG = 3;
    private ServerSocket serverSocket;

    public MineServer() throws IOException {
        serverSocket = new ServerSocket(PORT, BAKLOG);
        System.out.print("服务初始化成功");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MineServer mineServer = new MineServer();
        Thread.sleep(6000);
        mineServer.service();
    }

}
