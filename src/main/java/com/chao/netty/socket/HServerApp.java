package com.chao.netty.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HServerApp implements Runnable {
    public int port;

    public HServerApp(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                //等待client的请求
                System.out.println("waiting...");
                Socket socket = server.accept();
                // 接收客户端的数据
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String string = in.readUTF();
                System.out.println("client:" + string);
                // 发送给客户端数据
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("hi,i am hserver!i say:" + string);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HServerApp serverApp = new HServerApp(9050);
        serverApp.run();
    }
}
