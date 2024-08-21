package org.server;

import java.io.*;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipConfig;
        System.out.println("Insira o ip do servidor");
        ipConfig = scanner.nextLine();
        String inputData;
        System.out.println("Creating connection");
        System.out.println("Connected");
        while (true) {
            try (Socket conn = new Socket(ipConfig, 80);) {
//                    InputStream inputStream = conn.getInputStream();
                System.out.println("");
                System.out.println("Insira as informações");
                inputData = scanner.nextLine();
                DataOutputStream outToServer = new DataOutputStream(conn.getOutputStream());
                outToServer.writeBytes(inputData + '\n');
                ObjectInputStream in = new ObjectInputStream(conn.getInputStream());
                String response = (String) in.readObject();
                System.out.println("Response received: " + response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
