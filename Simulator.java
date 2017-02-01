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
    Result result = new Result();
    return result;
  }
  public HashMap<String, Integer> checkColor(ArrayList<String> datas) {
    int green = 0, black = 0, red = 0;
    HashMap<String, Integer> result = null;
    for(String data: datas) {
      if(data.substring(0, 1).equals("g")) {
        green += 1;
      } else if(data.substring(0, 1).equals("b")) {
        black += 1;
      } else {
        red += 1;
      }
    }
    result.put("Green", green);
    result.put("Black", black);
    result.put("Red", red);
    return result;
  }
  public HashMap<String, Integer> checkEvenOdd(ArrayList<String> datas) {
    int even = 0;
    int odd = 0;
    Hashmap<String, Integer> map = new Hashmap<String, Integer>();

    for(int i = 0; i < datas.size(); i++) {
      int currentNum = datas[i].substring(1);
      if(currentNum % 2 == 0) {
        even += 1;
      }
      else {
          odd += 1;
      }
    }
    map.put("Even", even);
    map.put("Odd", odd);
    return map;
  }
  public HashMap<String, Integer> checkNumbers(ArrayList<String> datas) {
   return null;
  }
  public HashMap<String, Integer> checkRow(ArrayList<String> datas) {
   return null;
  }
  public HashMap<String, Integer> checkRange(ArrayList<String> datas, int start, int stop) {
   return null;
  }
}
