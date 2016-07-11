package br.com.munieri.checkout.boot;

import br.com.munieri.checkout.boot.server.ApplicationServer;
import br.com.munieri.checkout.boot.server.WebServer;

public class Main {

    public static void main(String[] args) throws Exception {

        WebServer server = new ApplicationServer();
        server.start();
    }
}
