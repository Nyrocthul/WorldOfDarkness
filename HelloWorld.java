import java.util.*;

public class HelloWorld {
  public static void main(String[] args) {
    WorldOfDarknessCharacter victoria = new WorldOfDarknessCharacter("Victoria","Shaw");
    victoria.sayHello();
    victoria.hitBoxes = 8;
    victoria.firstAsperation = "Kill the nightmare child";
    victoria.secondAsperation = "Do ghost stuff";
    victoria.thirdAsperation = "Have fun with Josir";
    victoria.printAttributes();
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter New Intelligence:");
    Integer n = reader.nextInt();
    victoria.attributes.intelligence.dots = n;
    victoria.printAttributes();
  }

}
