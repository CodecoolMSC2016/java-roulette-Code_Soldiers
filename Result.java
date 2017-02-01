import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, Integer> result;
  Simulation simulation;
  Simulator simulator;
  public Result() {
    result = new LinkedHashMap<String, Integer>();
  }
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void setResults(LinkedHashMap[] hashmaps) {
    for(LinkedHashMap<String, Integer> hashmap: hashmaps) {
      result.putAll(hashmap);
    }
  }
  public void setResults(LinkedHashMap<String, Integer> resultsMap) {
    result = resultsMap;
  }
  public LinkedHashMap<String, Integer> getFullResults() {
      return result;
  }
  public LinkedHashMap<String, Integer> getColor() {
    return simulator.checkColor(simulation.getData());
  }
  public LinkedHashMap<String, Integer> getEvenOdd() {
    return simulator.checkEvenOdd(simulation.getData());
  }
  public LinkedHashMap<String, Integer> getNumbers() {
    return simulator.checkNumbers(simulation.getData());
  }
  public LinkedHashMap<String, Integer> getRow() {
    return simulator.checkRow(simulation.getData());
  }
  public LinkedHashMap<String, Integer> getRange() {
    return simulator.checkRange(simulation.getData(), simulator.ranges);
  }
}
