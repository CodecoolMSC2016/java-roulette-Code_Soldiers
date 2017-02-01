public class Main {
  public static Simulation generateSimulation(int round) {
    Simulation simulation = new Simulation();
    for(int i = 0; i < round; i++) {
      simulation.generateData();
    }
    return simulation;
  }

  public static void main(String[] args) throws IllegalArgumentException {
    Logger logger = null;
    Simulation simulation = null;
    Simulator simulator = null;
    if(args.length == 1)
    {
      simulation = generateSimulation(Integer.parseInt(args[0]));
      simulator = new Simulator(simulation, logger);
    }
    else
      throw new IllegalArgumentException();
    // simulation.load();

  }
}
