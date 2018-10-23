package com.chao.netty.socket;

/**
 * Created by Admin on 2018/10/23.
 */
public class ServerBoot {
	public static void main(String[] args) {
		Server server = new Server(5000);
		server.start();
	}
}
