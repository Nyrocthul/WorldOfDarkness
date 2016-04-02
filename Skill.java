import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Skill {
  String name;
  @NotNull Integer dots = 0;
  List<String> specializations;
  public Skill(String _name){
    this.name = _name;
  }
}
