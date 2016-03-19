import java.sql.*;
import java.util.*;

public class HelloWorld {
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
    public static void main(String[] args) {
        WorldOfDarknessCharacter victoria = callDataBase("Shaw");
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
