import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ChatClient extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private PrintWriter out;
    private Socket socket;

    private String username;

    public ChatClient(String username) {
        this.username = username;

        setupUI();
        connectToServer();
    }

    private void setupUI() {

        setTitle("Chat - " + username);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // ENTER key send
        inputField.addActionListener(e -> sendMessage());

        // Button send
        sendButton.addActionListener(e -> sendMessage());

        // Window close handling
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (out != null) {
                    out.println("QUIT");
                }
                closeConnection();
            }
        });

        setVisible(true);
    }

    private void connectToServer() {

        new Thread(() -> {
            try {
                socket = new Socket("localhost", 5000);

                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                // SEND USERNAME
                out.println(username);

                chatArea.append("Connected to server\n");

                String msg;

                while ((msg = in.readLine()) != null) {
                    chatArea.append(msg + "\n");
                }

            } catch (IOException e) {
                chatArea.append("Connection error\n");
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void sendMessage() {

        String msg = inputField.getText().trim();

        if (!msg.isEmpty()) {
            out.println(msg);
            chatArea.append("You: " + msg + "\n");
            inputField.setText("");
        }
    }

    private void closeConnection() {

        try {
            if (out != null) out.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your name:");

        if (name != null && !name.trim().isEmpty()) {
            new ChatClient(name);
        } else {
            System.exit(0);
        }
    }
}