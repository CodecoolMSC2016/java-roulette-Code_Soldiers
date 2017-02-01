public class Main {
  public static Simulation generateSimulation(int round) {
    Simulation simulation = new Simulation();
    simulation.load();
    for(int i = 0; i < round; i++) {
      simulation.generateData();
    }
    return simulation;
  }

  public static void main(String[] args) {
    Logger logger = null;
    Simulation simulation = generateSimulation(Integer.parseInt(args[0]));
    Simulator simulator = new Simulator(simulation, logger);
  }
}
