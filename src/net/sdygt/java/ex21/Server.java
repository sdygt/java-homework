package net.sdygt.java.ex21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;


class Server {

    static void main(int port) {

        CopyOnWriteArrayList<Socket> clients = new CopyOnWriteArrayList<>();
        try {
            ServerSocket srvsock = new ServerSocket(port);
            Log.notice("Server listening on port " + port);
            while (true) {
                Socket sock = srvsock.accept();
                Log.notice("New client connected: " + sock.getInetAddress().getHostName());
                clients.add(sock);
                new ServerThread(sock, clients).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
