package net.sdygt.java.ex21;

import static net.sdygt.java.ex21.Log.LOG_LEVEL;
import static net.sdygt.java.ex21.Log.log;

class Client {
    static void main(String host, int port) {
        log(LOG_LEVEL.NOTICE, "Client  " + host + ":" + port);
        System.out.println();
    }
}
