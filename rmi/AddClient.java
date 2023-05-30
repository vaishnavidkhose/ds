import java.rmi.*;

public class AddClient {
    public static void main(String[] args) {
        try{
            // Construct the RMI server URL using the first command-line argument
            String addServerURL = "rmi://" + args[0] + "/AddServer";
            
            // Look up the remote object with the specified URL in the RMI registry
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            
            // Print the first number passed as a command-line argument
            System.out.println("The first number is: " + args[1]);
            
            // Convert the second command-line argument to a double value
            double d1 = Double.valueOf(args[1]).doubleValue();
            
            // Print the second number passed as a command-line argument
            System.out.println("The second number is: " + args[2]);
            
            // Convert the third command-line argument to a double value
            double d2 = Double.valueOf(args[2]).doubleValue();
            
            // Invoke the remote method 'add' on the addServerIntf object
            // Pass the two double values as arguments to the remote method
            // Receive and print the sum returned by the remote method
            System.out.println("The sum is: " + addServerIntf.add(d1, d2));
        } catch(Exception e) {
            // Print any exceptions that occur during the execution
            System.out.println("Exception " + e);
        }
    }
}
