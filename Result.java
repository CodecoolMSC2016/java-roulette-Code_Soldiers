import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, LinkedHashMap<String, Double>> resultNumber;
  protected LinkedHashMap<String, LinkedHashMap<String, Double>> resultPercent;
  public Result() {
    resultNumber = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
    resultPercent = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
  }
  public void setResultNumbers(String name, LinkedHashMap<String, Double> resultMap) {
    resultNumber.put(name, resultMap);
  }
  public LinkedHashMap<String, LinkedHashMap<String, Double>> getFullResultNumbers() {
      return resultNumber; }
  public LinkedHashMap<String, Double> getColorNumbers() {
    return resultNumber.get("Color"); }
  public LinkedHashMap<String, Double> getTypeNumbers() {
    return resultNumber.get("Type"); }
  public LinkedHashMap<String, Double> getNumbersNumbers() {
    return resultNumber.get("Numbers"); }
  public LinkedHashMap<String, Double> getRowNumbers() {
    return resultNumber.get("Row"); }
  public LinkedHashMap<String, Double> getRangeNumbers() {
    return resultNumber.get("Range"); }

  public void setResultPercent(String name, LinkedHashMap<String, Double> resultMap) {
    resultPercent.put(name, resultMap);
  }
  public LinkedHashMap<String, Double> getColorPercent() {
    return resultPercent.get("Color"); }
  public LinkedHashMap<String, Double> getTypePercent() {
    return resultPercent.get("Type"); }
  public LinkedHashMap<String, Double> getNumbersPercent() {
    return resultPercent.get("Numbers"); }
  public LinkedHashMap<String, Double> getRowPercent() {
    return resultPercent.get("Row"); }
  public LinkedHashMap<String, Double> getRangePercent() {
    return resultPercent.get("Range"); }

}
