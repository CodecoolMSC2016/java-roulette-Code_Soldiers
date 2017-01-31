import java.util.ArrayList;
import java.util.Random;


public class Simulation {
  String data;
  private static String colors = "grbrbrbrbrbbr" + "brbrbrrbrbrb" + "rbrbbrbrbrbr";
  public void generateData() {
    int random = new Random().ints(1, 0, 37).findFirst().getAsInt();
    data = "" + colors.charAt(random) + String.valueOf(random);
  }

  public Simulation load() {

    return null;
  }
}
