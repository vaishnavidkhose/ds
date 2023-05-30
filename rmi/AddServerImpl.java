import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {

    public AddServerImpl() throws RemoteException {}
    // i have added a comment
    @Override
    public double add(double d1, double d2) throws RemoteException {        
        return (d1 + d2);
    }
    
}
