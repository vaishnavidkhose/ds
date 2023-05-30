import java.util.Scanner;

class tokenRing {
    public static void main(String[] args) throws Throwable{    
        
        // Prompt for the number of processes
        System.out.println("Enter the number of processes: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        
        int token = 0; // Variable to represent the token position
        int ch = 1; // Unused variable, can be removed
        int sender, reciever; // Variables to store the sender and receiver process numbers
        String message; // Variable to store the message
        boolean message_pass = false; // Flag to indicate whether the message is being passed
        
        System.out.println("Initializing ring");
        for(int i = 0; i < n; i++) {
            System.out.println(" " + i); // Print the process numbers of the ring
        }
        
        // Prompt for sender and receiver
        System.out.println("Enter sender : ");
        sender = sc.nextInt();
        System.out.println("Enter reciever : ");
        reciever = sc.nextInt();
        sc.nextLine();
        
        // Prompt for the message
        System.out.println("Enter message : ");
        message = sc.nextLine();
        
        // Loop to simulate the token passing through the ring
        for(token = 0; token < n; token++) {
            System.out.println("Token at process " + token);
            
            if(token == sender) {
                System.out.println("Sender found");
                System.out.println("Attaching message");
                message_pass = true; // Set the flag to indicate that the message is being passed
            } else if (token == reciever) {
                System.out.println("Token arrived at receiver");
                System.out.println("Message " + message + " received");
                message_pass = false; // Set the flag to indicate that the message has been received
            }
            
            if(message_pass) {
                System.out.println(token + " passing message " + message + " to " + (token + 1)%n);
            }
        }
    }
}
