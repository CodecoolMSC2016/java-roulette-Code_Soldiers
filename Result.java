import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, LinkedHashMap<String, Integer>> result;
  public Result() {
    result = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
  }
  public void setResult(String name, LinkedHashMap<String, Integer> resultMap) {
    result.put(name, resultMap);
  }
  public LinkedHashMap<String, LinkedHashMap<String, Integer>> getFullResults() {
      return result;
  }
  public LinkedHashMap<String, Integer> getColor() {
    return result.get("Color");
  }
  public LinkedHashMap<String, Integer> getType() {
    return result.get("Type");
  }
  public LinkedHashMap<String, Integer> getNumbers() {
    return result.get("Numbers");
  }
  public LinkedHashMap<String, Integer> getRow() {
    return result.get("Row");
  }
  public LinkedHashMap<String, Integer> getRange() {
    return result.get("Range");
  }
}
