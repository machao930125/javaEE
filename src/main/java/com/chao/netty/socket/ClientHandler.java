package com.chao.netty.socket;


import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Admin on 2018/10/23.
 */
public class ClientHandler {

	private static int MAX_DATE_LEN = 1024;
	private Socket socket;

	public ClientHandler(Socket socket){
		this.socket = socket;
	}

	public void start(){
		System.out.println("新建客户端接入");
		new Thread(() -> {
			dostart();
		}).start();
	}

	public void dostart(){
		try {
			InputStream inputStream = socket.getInputStream();
			while (true){
				byte[] data = new byte[MAX_DATE_LEN];
				int len;
				while ((len = inputStream.read(data)) != -1){
					String message = new String(data, 0, len);
					System.out.println("客户端传来消息："+ message);
					socket.getOutputStream().write(data);
				}
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
