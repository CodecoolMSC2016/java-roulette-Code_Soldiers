import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, LinkedHashMap<String, Double>> result;
  public Result() {
    result = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
  }
  public void setResult(String name, LinkedHashMap<String, Double> resultMap) {
    result.put(name, resultMap);
  }
  public LinkedHashMap<String, LinkedHashMap<String, Double>> getFullResults() {
      return result;
  }
  public LinkedHashMap<String, Double> getColor() {
    return result.get("Color");
  }
  public LinkedHashMap<String, Double> getType() {
    return result.get("Type");
  }
  public LinkedHashMap<String, Double> getNumbers() {
    return result.get("Numbers");
  }
  public LinkedHashMap<String, Double> getRow() {
    return result.get("Row");
  }
  public LinkedHashMap<String, Double> getRange() {
    return result.get("Range");
  }
}
