import java.util.HashMap;
public class Result {
  HashMap<String, Integer> result;
  public Result() {
    result = new HashMap<String, Integer>();
  }
  public void addResults(HashMap[] hashmaps) {
    for(HashMap<String, Integer> hashmap: hashmaps) {
      result.putAll(hashmap);
    }
  }
}
