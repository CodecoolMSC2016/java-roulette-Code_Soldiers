import java.util.*;
import java.text.*;
import java.lang.Thread;

public class Logger {
  Scanner scanner = new Scanner(System.in);

  public void log(String... args) {
    switch(args.length) {
      case 0:
        System.out.println("__logError: nothing to log");
        break;
      case 1:
        System.out.println(args[0]);
        break;
      case 2:
        logByType(args[0], args[1]);
        break;
      default:
        System.out.println("__logError: too much arguments");
    }
  }

  public String getInput(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }
  public void waitTime(int millisecond) {
    try {
      Thread.sleep(millisecond);
    } catch (InterruptedException e) {};
  }
  public void easterEgg() throws InterruptedException {
    System.out.println(String.format("\033[2J"));
    String[] easterEgg = new String[] {"   __       __  _______    ______    ______  ",
                                       "  |  \\     /  \\|       \\  /      \\  /      \\ ",
                                       "  | $$\\   /  $$| $$$$$$$\\|  $$$$$$\\|  $$$$$$\\",
                                       "  | $$$\\ /  $$$| $$__/ $$| $$ __\\$$| $$__| $$",
                                       "  | $$$$\\  $$$$| $$    $$| $$|    \\| $$    $$",
                                       "  | $$\\$$ $$ $$| $$$$$$$ | $$ \\$$$$| $$$$$$$$",
                                       "  | $$ \\$$$| $$| $$      | $$__| $$| $$  | $$",
                                       "  | $$  \\$ | $$| $$       \\$$    $$| $$  | $$",
                                       "   \\$$      \\$$ \\$$        \\$$$$$$  \\$$   \\$$",
                                       "\n             Make Python Great Again\n         "};
    for(String line: easterEgg) {
      for(int character = 0; character < line.length(); character++) {
        System.out.print(line.charAt(character));
        Thread.sleep(15);
      }
      System.out.println();
    }
  }
  public void printLogo() {
    String [] logo = {"                       ______   ______    _______   _______                       ",
                      "                      /      | /  __  \\  |       \\ |   ____|                      ",
                      "                     |  ,----'|  |  |  | |  .--.  ||  |__                         ",
                      "                     |  |     |  |  |  | |  |  |  ||   __|                        ",
                      "                     |  `----.|  `--'  | |  '--'  ||  |____                       ",
                      "                      \\______| \\______/  |_______/ |_______|                      ",
                      "     _______.  ______    __       _______   __   _______ .______          _______.",
                      "    /       | /  __  \\  |  |     |       \\ |  | |   ____||   _  \\        /       |",
                      "   |   (----`|  |  |  | |  |     |  .--.  ||  | |  |__   |  |_)  |      |   (----`",
                      "    \\   \\    |  |  |  | |  |     |  |  |  ||  | |   __|  |      /        \\   \\    ",
                      ".----)   |   |  `--'  | |  `----.|  '--'  ||  | |  |____ |  |\\  \\----.----)   |   ",
                      "|_______/     \\______/  |_______||_______/ |__| |_______|| _| `._____|_______/    ",
                      "\n\n                          A Roulette Simulation Game\n\n"};
    for(String line: logo) {
      System.out.println(line);
    }
  }
  public void printResult(LinkedHashMap<String, Double> percent, LinkedHashMap<String, Double> numbers, int totalResult) {
    Set<String> keys = percent.keySet();
    System.out.println();
    for(String key: keys) {
      System.out.println(String.format("%s --> %.2f%s (%.0f pcs)", key, percent.get(key), "%", numbers.get(key)));
    }
    System.out.println(String.format("Total Result: %d pcs", totalResult));
    waitTime(5000);
  }
  public void mainMenu() {
    String[] menu = new String[]{"Generate", "Color", "Type", "Numbers", "Row", "Range", "Exit"};
    System.out.println("\nSimulator main menu");
    for(int index = 0; index < menu.length; index++) {
      System.out.print(String.format("--> %d: %s", index + 1, menu[index]));
      System.out.println();
    }
  }
  private void logByType(String type, String message) {
    switch(type) {
      case "TimeStamp":
        String text = getDate() + " " + message;
        System.out.println(text);
        break;
      case "Upper":
        System.out.println(message.toUpperCase());
        break;
      default:
        System.out.println(message);
    }
  }
  private String getDate() {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    return df.format(today);
  }
}
