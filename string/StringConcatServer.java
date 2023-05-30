import StringConcatApp.StringConcat;
import StringConcatApp.StringConcatHelper;

public class StringConcatServer extends StringConcatPOA {
  
  @Override
  public String concatenate(String str1, String str2) {
    return str1 + str2;
  }

  public static void main(String[] args) {
    try {
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
      StringConcatServer stringConcatServer = new StringConcatServer();
      orb.connect(stringConcatServer);

      // Obtain the root POA and activate the object
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
      org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(objRef);
      org.omg.PortableServer.POAManager poaManager = rootPOA.the_POAManager();
      poaManager.activate();
      
      // Print the IOR (Interoperable Object Reference)
      String ior = orb.object_to_string(stringConcatServer);
      System.out.println("String Concatenation Server is ready:\n" + ior);
      
      // Wait for client requests
      orb.run();
    } catch (Exception e) {
      System.err.println("Error: " + e);
      e.printStackTrace(System.out);
    }
  }
}
