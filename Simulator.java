import java.util.ArrayList;
import java.util.LinkedHashMap;
public class Simulator {
  Simulation simulation;
  Logger logger;
  public Simulator(Simulation simulation, Logger logger) {
    this.simulation = simulation;
    this.logger = logger;
  }
  @SuppressWarnings("rawtypes")
  public Result run() {
    Result result = new Result();
    String[] ranges = new String[] {"1-18", "19-36", "1-12", "13-24", "25-36"};
    result.setResults(new LinkedHashMap[] {checkColor(simulation.getData()), checkEvenOdd(simulation.getData()),
                                     checkNumbers(simulation.getData()), checkRow(simulation.getData())});
    for(String range: ranges) {
      result.setResults(new LinkedHashMap[] {checkRange(simulation.getData(), range)});
    }
    return result;
  }
  public LinkedHashMap<String, Integer> checkColor(ArrayList<String> datas) {
    int black = 0, red = 0;
    LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
    for(String data: datas) {
      if(data.substring(0, 1).equals("b")) {
        result.put("Black", ++black);
      } else {
        result.put("Red", ++red);
      }
    }
    return result;
  }
  public LinkedHashMap<String, Integer> checkEvenOdd(ArrayList<String> datas) {
    int even = 0, odd = 0;
    LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
    for(int i = 0; i < datas.size(); i++) {
      int currentNum = Integer.parseInt(datas.get(i).substring(1));
      if(currentNum % 2 == 0) {
        map.put("Even", ++even);
      }
      else {
        map.put("Odd", ++odd);
      }
    }
    return map;
  }
  public LinkedHashMap<String, Integer> checkNumbers(ArrayList<String> dataList) {
    LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
    Integer[] data = new Integer[dataList.size()];
    for(int i = 0; i < dataList.size(); i++) {
      data[i] = Integer.parseInt(dataList.get(i).substring(1));
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
  public LinkedHashMap<String, Integer> checkRow(ArrayList<String> datas) {
    LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
    int first = 0, second = 0, third = 0;
    for(String data: datas) {
      if(Integer.parseInt(data.substring(1)) != 0) {
        if(Integer.parseInt(data.substring(1)) % 3 == 1) {
          result.put("First", ++first);
        } else if (Integer.parseInt(data.substring(1)) % 3 == 2) {
          result.put("Second", ++second);
        } else {
          result.put("Third", ++third);
        }
      }
    }
    return result;
  }
  public LinkedHashMap<String, Integer> checkRange(ArrayList<String> datas, String range) {
    int start = Integer.parseInt(range.substring(0, range.indexOf("-")));
    int stop = Integer.parseInt(range.substring(range.indexOf("-") + 1));
    int counter = 0;
    LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
    for(String data: datas) {
      if(start <= Integer.parseInt(data.substring(1)) && Integer.parseInt(data.substring(1)) <= stop) {
        result.put(range, ++counter);
      }
    }
    return result;
  }
}
