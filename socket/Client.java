// Client code
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            while ((inputLine = userInput.readLine()) != null) {
                out.println(inputLine);
                String response = in.readLine();
                System.out.println("Server response: " + response);
            }
        }
    }
}

