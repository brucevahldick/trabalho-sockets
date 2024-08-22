package org.server;

import java.io.*;
import java.util.Scanner;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipConfig;
        System.out.println("Insira o ip do servidor");
        ipConfig = scanner.nextLine();
        System.out.println("Creating connection");
        System.out.println("Connected");
        while (true) {
            try (Socket conn = new Socket(ipConfig, 8080)) {
                System.out.println();
                System.out.println("Insira as informações");
                String inputData = scanner.nextLine();
                PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                out.println(inputData);
                String response = in.readLine();
                if (response != null) {
                    System.out.println("Response received: " + response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
