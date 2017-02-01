public class Main {
  public static Simulation generateSimulation(int round){
    return new Simulation();
  }

  public static void main(String[] args) {
    generateSimulation(Integer.parseInt(args[0]));
  }
}
