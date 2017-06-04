package net.sdygt.java.ex21;

import org.apache.commons.cli.*;

public class Main {
    static boolean verbose = false;

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("s", "server", true, "Run as a server on specific port");
        options.addOption("p", "port", true, "Connect to specific port");
        options.addOption("h", "host", true, "Connect to specific host");
        options.addOption("v", "verbose", false, "Be verbose");

        try {
            CommandLine cmdline = parser.parse(options, args);
            verbose = cmdline.hasOption('v');
            if (cmdline.hasOption("server")) {
                net.sdygt.java.ex21.Server.main(Integer.parseInt(cmdline.getOptionValue("server", "8888")));
            } else {
                net.sdygt.java.ex21.Client.main(
                        cmdline.getOptionValue("host", "127.0.0.1"),
                        Integer.parseInt(cmdline.getOptionValue("port", "8888"))
                );
            }

        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }


    }
}
