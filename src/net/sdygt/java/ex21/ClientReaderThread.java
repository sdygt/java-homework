package net.sdygt.java.ex21;

import java.io.BufferedReader;
import java.io.IOException;

class ClientReaderThread extends Thread {
    private BufferedReader buf_reader;

    ClientReaderThread(BufferedReader buf_reader) {
        this.buf_reader = buf_reader;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(buf_reader.readLine());
            }
        } catch (IOException e) {
            Log.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
