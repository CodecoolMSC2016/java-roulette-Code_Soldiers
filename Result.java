import java.util.HashMap;
public class Result {
  protected HashMap<String, Integer> result;
  public Result() {
    result = new HashMap<String, Integer>();
  }
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void setResults(HashMap[] hashmaps) {
    for(HashMap<String, Integer> hashmap: hashmaps) {
      result.putAll(hashmap);
    }
  }
  public HashMap<String, Integer> getResults() {
      return result;
  }
}
