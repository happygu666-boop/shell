package com.shell;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "gu", version = "gu 1.0.0", mixinStandardHelpOptions = true) 
public class App implements Runnable {
    @Option(names = { "-v", "--verbose" }, description = "Verbose mode. Helpful for troubleshooting. " +
                                                         "Multiple -v options increase the verbosity.")
    private boolean[] verbose = new boolean[0];

    @Option(names = { "-h", "--help" }, usageHelp = true,
            description = "Displays this help message and quits.")
    private boolean helpRequested = false;

    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    String password;

    public void run() {
        System.out.println("Hello, " + user + "! Your password is: " + password);
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
