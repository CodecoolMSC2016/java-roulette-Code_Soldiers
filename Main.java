import java.lang.Thread;
public class Main {
  public static Simulation generateSimulation(int round) {
    Simulation simulation = new Simulation();
    for(int i = 0; i < round; i++) {
      simulation.generateData();
    }
    return simulation;
  }

  public static void main(String[] args) {
    Logger logger = new Logger();
    Simulation simulation = null;
    Simulator simulator = null;
    Result result = null;
    if(args.length == 0) {
      simulation = new Simulation();
      logger.log("TimeStamp", "Loading...");
      logger.waitTime(1000);
      simulation.load();
      logger.log("TimeStamp", "Loading completed!");
      logger.waitTime(500);
    } else if(args.length == 0) {
      simulation = generateSimulation(Integer.parseInt(args[0]));
    }
    simulator = new Simulator(simulation, logger);
    logger.log("TimeStamp", "Simulator initializing...");
    logger.waitTime(5000);
    result = simulator.run();
    logger.log("TimeStamp", "Simulation completed!");
    logger.waitTime(1000);
    boolean running = true;
    while(running) {
      logger.mainMenu();
      switch(logger.getInput().toLowerCase()) {
        case "generate":
          break;
        case "color":
          result.getColorPercent();
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
