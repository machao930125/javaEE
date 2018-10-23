package com.chao.netty.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 2018/10/23.
 */
public class Server {

	private ServerSocket serverSocket;

	public Server(int port){
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("服务启动成功，端口为：" + port);
		}catch (Exception e){
			System.out.println("服务启动失败：" + e.getMessage());
		}
	}

	public Server(){
		this(8080);
	}

	public void start(){
		new Thread(() -> {
			dostart();
		}).start();
	}

	public void dostart(){
		while (true){
			try {
				Socket client = serverSocket.accept();
				new ClientHandler(client).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("服务端异常");
			}
		}
	}
}
