package net.sdygt.java.ex21;

import java.text.SimpleDateFormat;
import java.util.Date;

import static net.sdygt.java.ex21.Main.verbose;

class Log {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static void log(LOG_LEVEL level, String msg) {
        if (!verbose && level == LOG_LEVEL.DEBUG) {
            return;
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(dateFormat.format(new Date()));
        switch (level) {
            case ERROR:
                strBuilder.append(" [ERR!] ");
                break;
            case WARNING:
                strBuilder.append(" [WARN] ");
                break;
            case NOTICE:
                strBuilder.append(" [NOTI] ");
                break;
            case INFO:
                strBuilder.append(" [INFO] ");
                break;
            case DEBUG:
                if (verbose) {
                    strBuilder.append(" [DBG.] ");
                } else {
                    return;
                }
        }
        strBuilder.append(msg);
        switch (level) {
            case ERROR:
            case WARNING:
            case NOTICE:
                System.err.println(strBuilder.toString());
                break;
            case INFO:
            case DEBUG:
                System.out.println(strBuilder.toString());
                break;
        }

    }

    static void error(String msg) {
        log(LOG_LEVEL.ERROR, msg);
    }

    static void warning(String msg) {
        log(LOG_LEVEL.WARNING, msg);
    }

    static void notice(String msg) {
        log(LOG_LEVEL.NOTICE, msg);
    }

    static void info(String msg) {
        log(LOG_LEVEL.INFO, msg);
    }

    static void debug(String msg) {
        log(LOG_LEVEL.DEBUG, msg);
    }

    enum LOG_LEVEL {
        ERROR, WARNING, NOTICE, INFO, DEBUG
    }
}
