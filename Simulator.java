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
  public void mainMakeStatistic(LinkedHashMap<String, LinkedHashMap<String, Double>> results) {
    LinkedHashMap<String, Double> temp = new LinkedHashMap<String, Double>();
    LinkedHashMap<String, LinkedHashMap<String, Double>> stats = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
    Set<String> mainKeys = results.keySet();
    for(String mainKey: mainKeys) {
      temp = subMakeStatistic(results.get(mainKey));
      result.setResultPercent(mainKey, temp);
      }
  }
  public LinkedHashMap<String, Double> subMakeStatistic(LinkedHashMap<String, Double> results) {
    LinkedHashMap<String, Double> stats = new LinkedHashMap<String, Double>();
    Set<String> subKeys = results.keySet();
    for(String subKey: subKeys) {
      double stat = ((double)results.get(subKey) / simulation.getData().size())*100;
      stats.put(subKey, stat);
    }
    return stats;
  }
  public void checkColor(ArrayList<String> datas) {
    double black = 0.0, red = 0.0;
    LinkedHashMap<String, Double> color = new LinkedHashMap<String, Double>();
    for(String data: datas) {
      if(data.substring(0, 1).equals("b")) {
        color.put("Black", ++black);
      } else {
        color.put("Red", ++red);
      }
    }
    result.setResultNumbers("Color", color);
  }
  public void checkType(ArrayList<String> datas) {
    double even = 0.0, odd = 0.0;
    LinkedHashMap<String, Double> type = new LinkedHashMap<String, Double>();
    for(int i = 0; i < datas.size(); i++) {
      int currentNum = Integer.parseInt(datas.get(i).substring(1));
      if(currentNum % 2 == 0) {
        type.put("Even", ++even);
      }
      else {
        type.put("Odd", ++odd);
      }
    }
    result.setResultNumbers("Type", type);
  }
  public void checkNumbers(ArrayList<String> dataList) {
    LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
    Integer[] data = new Integer[dataList.size()];
    for(int i = 0; i < dataList.size(); i++) {
      data[i] = Integer.parseInt(dataList.get(i).substring(1));
    }
    for(int number = 0; number < 37; number++) {
      double n = 0.0;
      for(int dataIndex = 0; dataIndex < data.length; dataIndex++) {
        if(data[dataIndex].equals(number)) {
          n += 1;
        }
      }
      map.put(Integer.toString(number), n);
    }
    result.setResultNumbers("Numbers", map);
  }
  public void checkRow(ArrayList<String> datas) {
    LinkedHashMap<String, Double> temp = new LinkedHashMap<String, Double>();
    double first = 0.0, second = 0.0, third = 0.0;
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
    result.setResultNumbers("Row", temp);
  }
  public void checkRange(ArrayList<String> datas, String[] ranges) {
    LinkedHashMap<String, Double> temp = new LinkedHashMap<String, Double>();
    for(String range: ranges) {
      int start = Integer.parseInt(range.substring(0, range.indexOf("-")));
      int stop = Integer.parseInt(range.substring(range.indexOf("-") + 1));
      double counter = 0.0;
      for(String data: datas) {
        if(start <= Integer.parseInt(data.substring(1)) && Integer.parseInt(data.substring(1)) <= stop) {
          temp.put(range, ++counter);
        }
      }
    }
    result.setResultNumbers("Range", temp);
  }
}
