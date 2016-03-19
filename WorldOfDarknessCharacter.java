import java.util.*;

public class WorldOfDarknessCharacter {
  String firstName;
  String lastName;
  public WorldOfDarknessCharacter(String _firstName,String _lastName) {
    this.firstName = _firstName;
    this.lastName = _lastName;
  }
  Attributes attributes = new Attributes();
  MentalSkills mentalSkills = new MentalSkills();
  PhysicalSkills physicalSkills = new PhysicalSkills();
  SocialSkills socialSkills = new SocialSkills();
  Integer size = 5;
  Integer hitBoxes = size + attributes.stamina.dots;
  Integer bashingTaken;
  Integer lethalTaken;
  Integer agTaken;
  String firstAsperation;
  String secondAsperation;
  String thirdAsperation;
  List<Party> parties = new ArrayList<Party>();
  public void joinParty(Party party){
    parties.add(party);
  }
  public void sayHello() {
    System.out.println("Hi, my name is "+firstName+" "+lastName);
  }
  public void printBorder() {
    String border = "==================================================";
    System.out.println(border);
  }
  public void printDetail(String detail) {
    System.out.println("|| "+detail);
  }
  public void printCharSheet() {
    printBorder();
    printDetail("Name: "+firstName+" "+lastName);
  }
  public void printHealth() {
    printCharSheet();
    printDetail("Hit Boxes: "+hitBoxes);
    printDetail("Filled Bashing: "+bashingTaken);
    printDetail("Filled Lethal: "+lethalTaken);
    printDetail("Filled Agravated: "+agTaken);
    printBorder();
  }
  public void printAspertions() {
    printDetail("First asperation: "+firstAsperation);
    printDetail("Second asperation: "+secondAsperation);
    printDetail("Third asperation: "+thirdAsperation);
    printBorder();
  }
  public void printAttributes() {
    printCharSheet();
    printDetail(attributes.intelligence.name+": "+String.valueOf(attributes.intelligence.dots));
    printDetail(attributes.wits.name + ": " + String.valueOf(attributes.wits.dots));
    printDetail(attributes.resolve.name + ": " + String.valueOf(attributes.resolve.dots));
    printDetail(attributes.strength.name + ": " + String.valueOf(attributes.strength.dots));
    printDetail(attributes.dexterity.name + ": " + String.valueOf(attributes.dexterity.dots));
    printDetail(attributes.stamina.name + ": " + String.valueOf(attributes.stamina.dots));
    printDetail(attributes.presence.name + ": " + String.valueOf(attributes.presence.dots));
    printDetail(attributes.manipulation.name + ": " + String.valueOf(attributes.manipulation.dots));
    printDetail(attributes.composure.name + ": " + String.valueOf(attributes.composure.dots));
    printBorder();
  }
}
