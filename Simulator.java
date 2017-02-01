import java.util.ArrayList;
import java.util.HashMap;
public class Simulator {
  Simulation simulation;
  Logger logger;
  public Simulator(Simulation simulation, Logger logger) {
    this.simulation = simulation;
    this.logger = logger;
  }
  public Result run() {
    return new Result(new Simulation());
  }
  public HashMap<String, Double> checkColor(ArrayList<String> datas) {
    return null;
  }
  public HashMap<String, Double> checkEvenOdd(ArrayList<String> datas) {
   return null;
  }
  public HashMap<String, Double> checkNumbers(ArrayList<String> datas) {
   return null;
  }
  public HashMap<String, Double> checkRow(ArrayList<String> datas) {
   return null;
  }
  public HashMap<String, Double> checkRange(ArrayList<String> datas, int start, int stop) {
   return null;
  }
}
