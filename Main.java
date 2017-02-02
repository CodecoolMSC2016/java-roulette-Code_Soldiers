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
    Result result = null;
    if(args.length == 0) {
      simulation.load();
    } else if(args.length == 0) {
      simulation = generateSimulation(Integer.parseInt(args[0]));
    }
    simulator = new Simulator(simulation, logger);
    result = simulator.run();
    boolean running = true;
    while(running) {
      switch(logger.getInput().toLowerCase()) {
        case "color":
          break;
        case "type":
          break;
        case "numbers":
          break;
        case "row":
          break;
        case "range":
          break;
        case "exit":
          running = false;
          try {
            logger.easterEgg();
          } catch (InterruptedException e) {}
          break;
        default:
          break;
      }
    }
  }
}
