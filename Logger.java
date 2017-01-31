import java.util.*;
import java.text.*;

public class Logger {
  public void log(String type, String message){
    switch(type){
      case "TimeStamp":
        String text = getDate() + " " + type + " " + message;
        System.out.println(text);
      default:
        System.out.println(message);
    }
  }
  
  private String getDate(){
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    return df.format(today);
  }
}
