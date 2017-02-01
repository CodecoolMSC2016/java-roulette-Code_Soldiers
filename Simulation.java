import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;


public class Simulation {
  String data;
  private static String colors = "grbrbrbrbrbbr" + "brbrbrrbrbrb" + "rbrbbrbrbrbr";
  public Simulation(int number) {
    data = "" + colors.charAt(number) + String.valueOf(number);
  }
  public void generateData() throws IOException {
    PrintWriter fw;
    try {
      fw = new PrintWriter(new FileOutputStream("Simulation.csv", true));
      fw.println(data);
      fw.close();
    } catch(IOException e) {
      // "Simulation.csv", "UTF-8"
    }
  }

  public Simulation load() {
      
    return null;
  }
}
