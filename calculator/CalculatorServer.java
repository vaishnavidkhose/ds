import CalculatorApp.*;

public class CalculatorServer extends CalculatorPOA {
  
  @Override
  public float add(float a, float b) {
    return a + b;
  }

  @Override
  public float subtract(float a, float b) {
    return a - b;
  }

  @Override
  public float multiply(float a, float b) {
    return a * b;
  }

  @Override
  public float divide(float a, float b) {
    if (b != 0)
      return a / b;
    else
      throw new ArithmeticException("Division by zero!");
  }

  public static void main(String[] args) {
    try {
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
      CalculatorServer calculatorServer = new CalculatorServer();
      orb.connect(calculatorServer);

      // Obtain the root POA and activate the object
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
      org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(objRef);
      org.omg.PortableServer.POAManager poaManager = rootPOA.the_POAManager();
      poaManager.activate();
      
      // Print the IOR (Interoperable Object Reference)
      String ior = orb.object_to_string(calculatorServer);
      System.out.println("Calculator Server is ready:\n" + ior);
      
      // Wait for client requests
      orb.run();
    } catch (Exception e) {
      System.err.println("Error: " + e);
      e.printStackTrace(System.out);
    }
  }
}
