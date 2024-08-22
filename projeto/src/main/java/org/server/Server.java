package org.server;

import org.controller.Facade;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);
        while (true) {
            System.out.println("Waiting for connection");
            try (Socket connectionSocket = server.accept()) {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());
                String clientSentence = inFromClient.readLine();
                String[] data = clientSentence.split(";");
                String response = (new Facade(data)).executarOperacao();
                System.out.println("Received: " + response);
                out.writeObject(response);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
