import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket and bind it to port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Listening on port 12345...");

        while (true) {
            // Wait for a client to connect and accept the connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // Create a new thread to handle the client's requests
            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            // Set up input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Process the client's request and send a response
                System.out.println("Received from client: " + inputLine);
                out.println("Server response: " + inputLine.toUpperCase());
            }

            // Close the input and output streams, and the client socket
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
