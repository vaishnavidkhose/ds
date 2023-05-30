import CalculatorApp.*;

public class CalculatorClient {

  public static void main(String[] args) {
    try {
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
      org.omg.CORBA.Object objRef = orb.string_to_object("IOR_OF_CALCULATOR_SERVER"); // Replace with the actual IOR

      Calculator calculator = CalculatorHelper.narrow(objRef);

      // Perform calculator operations
      float a = 10;
      float b = 5;
      System.out.println("Addition: " + calculator.add(a, b));
      System.out.println("Subtraction: " + calculator.subtract(a, b));
      System.out.println("Multiplication: " + calculator.multiply(a, b));
      System.out.println("Division: " + calculator.divide(a, b));
    } catch (Exception e) {
      System.err.println("Error: " + e);
      e.printStackTrace(System.out);
    }
  }
}
