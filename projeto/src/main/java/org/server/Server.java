package org.server;

import org.controller.Facade;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Server IP address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Failed to get IP address: " + e.getMessage());
        }
        ServerSocket server = new ServerSocket(8080);
        server.setReuseAddress(true);
        while (true) {
            System.out.println("Waiting for connection");
            try (Socket connectionSocket = server.accept()) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String clientSentence = in.readLine();
                System.out.println("Received: " + clientSentence);
                String[] data = clientSentence.split(";");
                String response = (new Facade(data)).executarOperacao();
                out.println(response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
