package net.sdygt.java.ex21;

import java.io.*;
import java.net.Socket;

class ClientWriterThread extends Thread {
    private Socket socket;

    ClientWriterThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader buf_reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter buf_writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String msg = buf_reader.readLine();
                if (msg == (null)) {
                    buf_writer.close();
                    socket.close();
                }
                buf_writer.write(msg);
                buf_writer.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
