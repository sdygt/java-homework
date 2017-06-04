package net.sdygt.java.ex21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {
    static void main(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            new ClientWriterThread(socket).start();
            BufferedReader buf_reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new ClientReaderThread(buf_reader).start();
        } catch (UnknownHostException e) {
            Log.error("Unknown Host: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
