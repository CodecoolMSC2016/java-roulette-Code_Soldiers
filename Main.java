import java.lang.Thread;
import java.util.LinkedHashMap;
public class Main {
  public static Simulation generateSimulation(int round, Simulation simulation) {
    for(int i = 0; i < round; i++) {
      simulation.generateData();
    }
    return simulation;
  }

  public static Simulation generateSimulation(int round) {
    return generateSimulation(round, new Simulation());
  }


  public static void main(String[] args) {
    Logger logger = new Logger();
    Simulation simulation = null;
    Simulator simulator = null;
    Result result = null;
    LinkedHashMap<String, Double> unSortedResult = new LinkedHashMap<String, Double>();
    LinkedHashMap<String, Double> resultNumbers = new LinkedHashMap<String, Double>();
    if(args.length == 0) {
      simulation = new Simulation();
      logger.log("TimeStamp", "Loading...");
      logger.waitTime(1000);
      simulation.load();
      logger.log("TimeStamp", "Loading completed!");
      logger.waitTime(500);
    } else if(args.length == 1) {
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
      switch(logger.getInput("Choose from above: ")) {
        case "1":
          int generateTimes = Integer.parseInt(logger.getInput("How many new rounds do you want to generate? "));
          simulation = generateSimulation(generateTimes, simulation);
          result = simulator.run();
          break;
        case "2":
          logger.printResult(result.sortResult(result.getColorPercent()), result.getColorNumbers());
          break;
        case "3":
          logger.printResult(result.sortResult(result.getTypePercent()), result.getTypeNumbers());
          break;
        case "4":
          logger.printResult(result.sortResult(result.getNumbersPercent()), result.getNumbersNumbers());
          break;
        case "5":
          logger.printResult(result.sortResult(result.getRowPercent()), result.getRowNumbers());
          break;
        case "6":
          logger.printResult(result.sortResult(result.getRangePercent()), result.getRangeNumbers());
          break;
        case "7":
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
