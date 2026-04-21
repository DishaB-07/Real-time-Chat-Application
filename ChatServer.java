import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static final int PORT = 5000;

    // Thread-safe list
    private static List<ClientHandler> clients =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        System.out.println("=== Server Started ===");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket, clients);
                clients.add(client);

                new Thread(client).start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}