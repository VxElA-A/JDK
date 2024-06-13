package JavaDEvelomentKitLessone1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<PrintWriter> clientOutputStreams;

    public static void main(String[] args) {
        new ChatServer().startServer();
    }

    public void startServer() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("New client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private static final String LOG_FILE = "chat_log.txt";

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    logMessage("Client: " + inputLine);

                    
                    String outputLine = processInput(inputLine);

                    out.println(outputLine);
                    System.out.println("Server: " + outputLine);
                    logMessage("Server: " + outputLine);
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void logMessage(String message) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true));
                writer.write(message + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processInput(String input) {
            
            return "Processed: " + input;
        }
    }
}


