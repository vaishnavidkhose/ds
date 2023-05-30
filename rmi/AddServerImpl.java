import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {

    public AddServerImpl() throws RemoteException {
        // Default constructor for the AddServerImpl class
        // It extends UnicastRemoteObject to enable remote method invocation
        // The constructor throws a RemoteException to handle remote communication errors
    }

    // Implement the add() method declared in the AddServerIntf interface
    // This method takes two double values as parameters and returns their sum
    @Override
    public double add(double d1, double d2) throws RemoteException {
        // Calculate the sum of the two double values
        return (d1 + d2);
    }

}
