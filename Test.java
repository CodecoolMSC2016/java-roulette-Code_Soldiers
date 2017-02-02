import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class Test
{
  public static void main(String[] args)
  {
    Simulation sn = new Simulation();
    sn.load();
    //sn.load()
    Simulator sr = new Simulator(sn, new Logger());
    Result result = sr.run();
    System.out.println(sn.getData());
    //System.out.println(result.getFullResults());
    //System.out.println(result.getColor());
    //System.out.println(result.getType());
    //System.out.println(result.getNumbers());
    //System.out.println(result.getRow());
    //System.out.println(result.getRange());
    System.out.println(result.getFullResultPercent());
    System.out.println();
    Map<String, Double> asd = result.getNumbersNumbers();
    Map<String, Double> asd2 = asd.entrySet().stream()
      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    System.out.println(asd2);

  }
}
