package net.sdygt.java.ex21;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerThread extends Thread {

    private Socket socket;
    private CopyOnWriteArrayList<Socket> clients;

    ServerThread(Socket socket, CopyOnWriteArrayList<Socket> clients) {
        super();
        this.socket = socket;
        this.clients = clients;
        Log.debug("New ServerThread Instance created: " + this);
    }


    public void run() {
        Log.debug(this + " is running");
        try {
            BufferedReader buf_reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            File file = new File("D:/java.log");
            BufferedWriter buf_writer_file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String name = socket.getInetAddress().getHostName();
            while (true) {
                String msg = buf_reader.readLine();
                if (msg == null) {
                    Log.notice(name + " Disconnected");
                    socket.close();
                    break;
                }
                String writeOut = String.format("%s %s\n%s\n\n", name, dateFormat.format(new Date()), msg);
                buf_writer_file.write(writeOut);
                buf_writer_file.flush();
                Log.info(name + " " + msg);
                for (Socket socket : clients) {
                    try {
                        BufferedWriter buf_writer_sock = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        Log.debug("Writing to " + socket);
                        buf_writer_sock.write(writeOut);
                        buf_writer_sock.flush();
                    } catch (SocketException e) {
                        Log.debug("Removing closed socket " + socket);
                        clients.remove(socket);

                    }
                }
            }
        } catch (IOException e) {
            Log.warning(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }


}
