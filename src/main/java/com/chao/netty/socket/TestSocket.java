package com.chao.netty.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    final static int PORT = 8090;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(PORT);

        System.out.println("server socket port: " + PORT);

        while (true) {
            Socket client = socket.accept();
            System.out.println("client: " + client.getPort());

            new Thread(() -> {
                try {
                    InputStream inputStream = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true){
                        System.out.println(reader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
