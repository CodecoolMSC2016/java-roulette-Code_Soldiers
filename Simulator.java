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
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    for(int i = 0; i < datas.size(); i++) {
      int currentNum = Integer.parseInt(datas.get(i).substring(1));
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
  public HashMap<String, Integer> checkNumbers(ArrayList<String> dataList) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    Integer[] data = new Integer[dataList.size()];
    for(int i = 0; i < dataList.size(); i++) {
      data[i] = Integer.parseInt(dataList.get(i));
    }
    for(int number = 0; number < 37; number++) {
      int n = 0;
      for(int dataIndex = 0; dataIndex < data.length; dataIndex++) {
        if(data[dataIndex].equals(number)) {
          n += 1;
        }
      }
      map.put(Integer.toString(number), n);
    }
    return map;
  }
  public HashMap<String, Integer> checkRow(ArrayList<String> datas) {
    HashMap<String, Integer> result = null;
    int first = 0, second = 0, third = 0;
    for(String data: datas) {
      if(Integer.parseInt(data.substring(1)) != 0) {
        if(Integer.parseInt(data.substring(1)) % 3 == 1) {
          first += 1;
        } else if (Integer.parseInt(data.substring(1)) % 3 == 2) {
          second += 1;
        } else {
          third += 1;
        }
      }
    }
    result.put("First", first);
    result.put("Second", second);
    result.put("Third", third);
  }
  public HashMap<String, Integer> checkRange(ArrayList<String> datas, int start, int stop) {
    String range = Integer.toString(start) + "-" + Integer.toString(stop);
    int counter = 0;
    HashMap<String, Integer> result = null;
    for(String data: datas) {
      if(start <= Integer.parseInt(data.substring(1)) && Integer.parseInt(data.substring(1)) >= stop) {
        counter += 1;
      }
    }
    result.put(range, counter);
  }
}
