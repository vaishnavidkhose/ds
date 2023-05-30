import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Define the server address and port
        String serverAddress = "localhost";
        int serverPort = 12345;

        // Establish a connection to the server using a Socket
        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Set up input streams for user input and server responses
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            // Read user input and send it to the server, then receive and display the server response
            while ((inputLine = userInput.readLine()) != null) {
                out.println(inputLine); // Send user input to the server
                String response = in.readLine(); // Receive response from the server
                System.out.println("Server response: " + response); // Display the server response
            }
        }
    }
}
