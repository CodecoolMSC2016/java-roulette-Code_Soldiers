import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;


public class Simulation {
  private ArrayList<String> data;
  private static String colors = "grbrbrbrbrbbr" + "brbrbrrbrbrb" + "rbrbbrbrbrbr";
  public Simulation() {
    data = new ArrayList<String>();
  }

  public ArrayList<String> getData() {
    return data;
  }

  public void generateData() {
    int r = new Random().ints(1, 0, 37).findFirst().getAsInt();
    String rec = "" + colors.charAt(r) + String.valueOf(r);
    data.add(rec);
    writeCsv(rec);
  }

  public void load() {
    BufferedReader br;
    String line;
    try {
      br = new BufferedReader(new FileReader("Simulation.csv"));
      while((line = br.readLine()) != null) {
        data.add(line);
      }
    }
    catch (IOException e) {

    }
  }

  private void writeCsv(String txt)
  {
    PrintWriter fw;
    try {
      fw = new PrintWriter(new FileOutputStream("Simulation.csv", true));
      fw.println(txt);
      fw.close();
    } catch(IOException e) { }
  }
}
