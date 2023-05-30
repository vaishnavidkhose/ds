import java.rmi.*;

public abstract class AddServer {
    public static void main(String[] args) {
        try{
            // Create an instance of the AddServerImpl class
            AddServerImpl addServerImpl = new AddServerImpl();
            
            // Bind the AddServerImpl object to a name "AddServer" in the registry
            Naming.bind("AddServer", addServerImpl);
            
            // The above line makes the AddServerImpl object available for remote method invocations
            // Clients can look up this object in the registry using the specified name
        } catch(Exception e) {
            // Print any exceptions that occur during the execution
            System.out.println("Exception " + e);
        }        
    }    
}
