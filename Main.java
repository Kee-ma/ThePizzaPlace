import java.util.scanner;

public class Main {
  public static void main(String[] args) {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();
    if (input.equalsIgnoreCase("c")) {
      System.out.println(YELLOW + "________________________" + RESET);
      System.out.println(YELLOW + "Customers" + RESET);
      System.out.println(YELLOW + "________________________" + RESET);
      }
    else if (input.equalsIgnoreCase("k")) {
      System.out.println(RED + "___________________" + RESET);
      System.out.println(RED + "Ingredient" + RESET);
      System.out.println(RED + "___________________" + RESET);
      }
    else if (input.equalsIgnoreCase("r")) {
      System.out.println(GREEN + "___________________" + RESET);
      System.out.println(GREEN + "Truck" + RESET);
      System.out.println(GREEN + "___________________" + RESET);
      }
    else {
    System.out.println("Not a valid option")
      }
  }
}
