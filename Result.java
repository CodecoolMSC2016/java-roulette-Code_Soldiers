import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, Integer> result;
  public Result() {
    result = new LinkedHashMap<String, Integer>();
  }
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void setResults(LinkedHashMap[] hashmaps) {
    for(LinkedHashMap<String, Integer> hashmap: hashmaps) {
      result.putAll(hashmap);
    }
  }
  public LinkedHashMap<String, Integer> getResults() {
      return result;
  }
}
