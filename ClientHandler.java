import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private List<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run() {

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // READ USERNAME
            username = in.readLine();

            // PRINT ON SERVER
            System.out.println(username + " joined");

            // SEND TO OTHERS
            sendToAll("SERVER", username + " joined the chat");

            String msg;

            while ((msg = in.readLine()) != null) {

                if (msg.equalsIgnoreCase("QUIT")) {
                    break;
                }

                System.out.println(username + ": " + msg);

                sendToAll(username, msg);
            }

        } catch (IOException e) {
            System.out.println(username + " disconnected");
        } finally {
            closeConnection();
        }
    }

    // SEND MESSAGE TO ALL CLIENTS
    private void sendToAll(String sender, String message) {

        String fullMsg = sender + ": " + message;

        synchronized (clients) {
            for (ClientHandler c : clients) {

                if (c.username != null && !c.username.equals(this.username)) {
                    c.out.println(fullMsg);
                }
            }
        }
    }

    // CLOSE CONNECTION
    private void closeConnection() {

        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        clients.remove(this);

        if (username != null) {
            sendToAll("SERVER", username + " left the chat");
            System.out.println(username + " disconnected");
        }
    }
}