import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;


public class WorldOfDarknessCharacter {
  String firstName;
  String lastName;
  public WorldOfDarknessCharacter(String _firstName,String _lastName) {
    this.firstName = _firstName;
    this.lastName = _lastName;
  }
  public static WorldOfDarknessCharacter callDataBase(String lname) {
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;

    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:worldofdarkness/characters.db");
      statement = connection.prepareStatement("select * from characters where lname = ?");
      statement.setString(1, lname);
      resultSet = statement
              .executeQuery();
      String fname = null;
      try {
        fname = resultSet.getString("fname");
        lname = resultSet.getString("lname");
      } catch (Exception e) {
        e.printStackTrace();
      }
      while (resultSet.next()) {
        return new WorldOfDarknessCharacter(fname, lname);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        resultSet.close();
        statement.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }
  
  @NotNull Attributes attributes = new Attributes();
  @NotNull MentalSkills mentalSkills = new MentalSkills();
  @NotNull PhysicalSkills physicalSkills = new PhysicalSkills();
  @NotNull SocialSkills socialSkills = new SocialSkills();
  @NotNull Integer size = 5;
  @NotNull Integer hitBoxes = size + attributes.stamina.dots;
  Integer bashingTaken;
  Integer lethalTaken;
  Integer agTaken;
  String firstAsperation;
  String secondAsperation;
  String thirdAsperation;
  @NotNull List<Party> parties = new ArrayList<Party>();
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
