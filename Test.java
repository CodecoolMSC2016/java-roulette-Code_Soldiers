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
  }
}
