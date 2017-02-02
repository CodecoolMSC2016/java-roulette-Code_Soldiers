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

  public String getInput() {
    return scanner.nextLine();
  }
  public void easterEgg() throws InterruptedException {
    String[] easterEgg = new String[] {"   __       __  _______    ______    ______  ",
                                       "  |  \\     /  \\|       \\  /      \\  /      \\ ",
                                       "  | $$\\   /  $$| $$$$$$$\\|  $$$$$$\\|  $$$$$$\\",
                                       "  | $$$\\ /  $$$| $$__/ $$| $$ __\\$$| $$__| $$",
                                       "  | $$$$\\  $$$$| $$    $$| $$|    \\| $$    $$",
                                       "  | $$\\$$ $$ $$| $$$$$$$ | $$ \\$$$$| $$$$$$$$",
                                       "  | $$ \\$$$| $$| $$      | $$__| $$| $$  | $$",
                                       "  | $$  \\$ | $$| $$       \\$$    $$| $$  | $$",
                                       "   \\$$      \\$$ \\$$        \\$$$$$$  \\$$   \\$$",
                                       "                                             ",
                                       "             Make Python Great Again         ",
                                       "                                             "};
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
                      "\n\n                          A Roulette Simulation Game"};
    for(String line: logo) {
      System.out.println(line);
    }
  }
  public void mainMenu() {
    System.out.println("Main menu");
    System.out.println("--> generate");
    System.out.println("--> color");
    System.out.println("--> type");
    System.out.println("--> numbers");
    System.out.println("--> row");
    System.out.println("--> range");
    System.out.println("--> exit");
  }
  private void logByType(String type, String message) {
    switch(type) {
      case "TimeStamp":
        String text = getDate() + " " + " " + message;
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
