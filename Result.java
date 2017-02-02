import java.util.LinkedHashMap;
public class Result {
  protected LinkedHashMap<String, LinkedHashMap<String, Double>> resultNumbers;
  protected LinkedHashMap<String, LinkedHashMap<String, Double>> resultPercent;
  public Result() {
    resultNumbers = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
    resultPercent = new LinkedHashMap<String, LinkedHashMap<String, Double>>();
  }
  public void setResultNumbers(String name, LinkedHashMap<String, Double> resultMap) {
    resultNumbers.put(name, resultMap);
  }
  public LinkedHashMap<String, LinkedHashMap<String, Double>> getFullResultNumbers() {
      return resultNumbers; }
  public LinkedHashMap<String, Double> getColorNumbers() {
    return resultNumbers.get("Color"); }
  public LinkedHashMap<String, Double> getTypeNumbers() {
    return resultNumbers.get("Type"); }
  public LinkedHashMap<String, Double> getNumbersNumbers() {
    return resultNumbers.get("Numbers"); }
  public LinkedHashMap<String, Double> getRowNumbers() {
    return resultNumbers.get("Row"); }
  public LinkedHashMap<String, Double> getRangeNumbers() {
    return resultNumbers.get("Range"); }

  public void setResultPercent(String name, LinkedHashMap<String, Double> resultMap) {
    resultPercent.put(name, resultMap);
  }
  public LinkedHashMap<String, LinkedHashMap<String, Double>> getFullResultPercent() {
      return resultPercent; }
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
