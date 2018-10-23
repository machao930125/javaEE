package com.chao.netty.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Admin on 2018/10/23.
 */
public class Client {
	private static final String HOST = "localhost";
	private static final int PORT = 5000;
	private static final int SLEEP_TIME = 5000;

	public static void main(String[] args) throws IOException{
		final Socket socket = new Socket(HOST, PORT);
		new Thread(() -> {
			System.out.println("启动客户端成功！");

			while (true){
				try {
					String message = "hello socket";
					System.out.println("客户端发送数据：" + message);
					socket.getOutputStream().write(message.getBytes());
				}catch (Exception e){
					System.out.println("写出数据错误！");
				}
				sleep();
			}
		}).start();

	}

	public static void sleep(){
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
