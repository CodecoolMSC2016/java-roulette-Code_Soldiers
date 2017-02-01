import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
public class Simulator {
  Simulation simulation;
  Logger logger;
  Result result;
  protected String[] ranges = new String[] {"1-18", "19-36", "1-12", "13-24", "25-36"};
  public Simulator(Simulation simulation, Logger logger) {
    this.simulation = simulation;
    this.logger = logger;
    this.result = new Result();
  }
  public Result run() {
    ArrayList<String> dataList = simulation.getData();
    checkColor(dataList);
    checkType(dataList);
    checkNumbers(dataList);
    checkRow(dataList);
    checkRange(dataList, ranges);
    return result;
  }
  public LinkedHashMap<String, Double> makeStatistic(LinkedHashMap<String, Integer> results) {
    LinkedHashMap<String, Double> stats = new LinkedHashMap<String, Double>();
    Set<String> keys = results.keySet();
    for(String key: keys) {
      double stat = ((double)results.get(key) / results.size())*100;
      stats.put(key, stat);
    }
    return stats;
  }
  public void checkColor(ArrayList<String> datas) {
    int black = 0, red = 0;
    LinkedHashMap<String, Integer> color = new LinkedHashMap<String, Integer>();
    for(String data: datas) {
      if(data.substring(0, 1).equals("b")) {
        color.put("Black", ++black);
      } else {
        color.put("Red", ++red);
      }
    }
    result.setResult("Color", color);
  }
  public void checkType(ArrayList<String> datas) {
    int even = 0, odd = 0;
    LinkedHashMap<String, Integer> evenOdd = new LinkedHashMap<String, Integer>();
    for(int i = 0; i < datas.size(); i++) {
      int currentNum = Integer.parseInt(datas.get(i).substring(1));
      if(currentNum % 2 == 0) {
        evenOdd.put("Even", ++even);
      }
      else {
        evenOdd.put("Odd", ++odd);
      }
    }
    result.setResult("Type", evenOdd);
  }
  public void checkNumbers(ArrayList<String> dataList) {
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
    result.setResult("Numbers", map);
  }
  public void checkRow(ArrayList<String> datas) {
    LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    int first = 0, second = 0, third = 0;
    for(String data: datas) {
      if(Integer.parseInt(data.substring(1)) != 0) {
        if(Integer.parseInt(data.substring(1)) % 3 == 1) {
          temp.put("First", ++first);
        } else if (Integer.parseInt(data.substring(1)) % 3 == 2) {
          temp.put("Second", ++second);
        } else {
          temp.put("Third", ++third);
        }
      }
    }
    result.setResult("Row", temp);
  }
  public void checkRange(ArrayList<String> datas, String[] ranges) {
    LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    for(String range: ranges) {
      int start = Integer.parseInt(range.substring(0, range.indexOf("-")));
      int stop = Integer.parseInt(range.substring(range.indexOf("-") + 1));
      int counter = 0;
      for(String data: datas) {
        if(start <= Integer.parseInt(data.substring(1)) && Integer.parseInt(data.substring(1)) <= stop) {
          temp.put(range, ++counter);
        }
      }
    }
    result.setResult("Range", temp);
  }
}
