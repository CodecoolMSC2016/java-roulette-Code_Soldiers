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
    int totalResult;
    logger.printLogo();
    logger.waitTime(1000);
    if(args.length == 0) {
      simulation = new Simulation();
      logger.log("TimeStamp", "Loading...");
      logger.waitTime(1000);
      simulation.load();
      logger.log("TimeStamp", "Loading completed!");
      logger.waitTime(500);
    } else if(args.length == 1) {
      simulation.load();
      simulation = generateSimulation(Integer.parseInt(args[0]));
    }
    simulator = new Simulator(simulation, logger);
    logger.log("TimeStamp", "Simulator initializing...");
    logger.waitTime(3000);
    result = simulator.run();
    logger.log("TimeStamp", "Simulation completed!");
    logger.waitTime(1000);
    boolean running = true;
    while(running) {
      logger.mainMenu();
      totalResult = simulation.getData().size();
      switch(logger.getInput("Choose from above: ")) {
        case "1":
          int generateTimes = Integer.parseInt(logger.getInput("How many new rounds do you want to generate? "));
          simulation = generateSimulation(generateTimes, simulation);
          logger.log("TimeStamp", String.format("Simulating %d evenets...", generateTimes));
          logger.waitTime(2000);
          logger.log("TimeStamp", "Simulation completed!");
          logger.log("TimeStamp", "Evaluation of results...");
          logger.waitTime(generateTimes * 2);
          result = simulator.run();
          logger.log("TimeStamp", "Evaluation done!");
          break;
        case "2":
          logger.printResult(result.sortResult(result.getColorPercent()), result.getColorNumbers(), totalResult);
          break;
        case "3":
          logger.printResult(result.sortResult(result.getTypePercent()), result.getTypeNumbers(), totalResult);
          break;
        case "4":
          logger.printResult(result.sortResult(result.getNumbersPercent()), result.getNumbersNumbers(), totalResult);
          break;
        case "5":
          logger.printResult(result.sortResult(result.getRowPercent()), result.getRowNumbers(), totalResult);
          break;
        case "6":
          logger.printResult(result.sortResult(result.getRangePercent()), result.getRangeNumbers(), totalResult);
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
