import java.util.*;
import java.text.*;

public class Logger {
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

  private void logByType(String type, String message) {
    switch(type) {
      case "TimeStamp":
        String text = getDate() + " " + type + " " + message;
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
