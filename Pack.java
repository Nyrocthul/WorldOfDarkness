import org.jetbrains.annotations.NotNull;

import java.util.*;
public class Pack extends Party{
  String packName;
  List<WorldOfDarknessCharacter> members;
  Spirit totem;
  List<Merit> sharedMerits;
  public void addPackMate(@NotNull WorldOfDarknessCharacter character) {
    members.add(character);
    character.joinParty(this);
  }
  public void listMembers() {
    for (WorldOfDarknessCharacter c: members) {
      System.out.println(c.firstName);
    }
  }
}
