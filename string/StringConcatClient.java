import StringConcatApp.*;

public class StringConcatClient {

  public static void main(String[] args) {
    try {
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
      org.omg.CORBA.Object objRef = orb.string_to_object("IOR_OF_STRING_CONCAT_SERVER"); // Replace with the actual IOR

      StringConcat stringConcat = StringConcatHelper.narrow(objRef);

      // Perform string concatenation
      String str1 = "Hello, ";
      String str2 = "CORBA!";
      String result = stringConcat.concatenate(str1, str2);
      System.out.println("Concatenated String: " + result);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      e.printStackTrace(System.out);
    }
  }
}
