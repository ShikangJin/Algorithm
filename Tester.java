import java.util.*;

class Tester {
  public static void main(String[] args) {
    System.out.println("test start");
    
    String[] input = {"add.sd@gmail.com", "addsd@gmail.com", "add+sd@gmail.com", "add+sd@gmail@com"};
    System.out.println(UniqueEmailAddress.numUniqueEmails(input));
  }  
}