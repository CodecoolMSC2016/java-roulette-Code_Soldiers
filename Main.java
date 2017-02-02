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
    } else if(args.length == 0) {
      simulator = new Simulator(simulation, logger);
      startMenu(simulator, logger);
    } else {
      throw new IllegalArgumentException();
    }
    // simulation.load();
  }

  public static void startMenu(Simulator simulator, Logger logger){
    boolean running = true;
    while(running){
      String[] commands = logger.getInput();
      switch(commands.length){
        case 2:
          switch(commands[0]){
            case "generate":

            }
      }
    }
  }

}
