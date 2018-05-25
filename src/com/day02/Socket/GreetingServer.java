package com.day02.Socket;

import java.io.*;
import java.net.*;

/**
 * 使用 Socket 来监听一个指定的端口。
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10*1000);
    }

    public void run() {
        while (true) {
            try {

                System.out.println("等待远程连接" + serverSocket.getLocalSocketAddress() + ":" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        //int port = Integer.parseInt(args[0]);
        int port = 4100;
        try {
            Thread t = new GreetingServer(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
