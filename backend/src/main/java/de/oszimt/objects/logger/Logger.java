package de.oszimt.objects.logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private SimpleDateFormat time;

    /**
     * Constructor from object.
     */
    public Logger() {
        time = new SimpleDateFormat("HH:mm:ss");
    }
    /**
     * Log message into console.
     */
    public void log(LogType type, String message) {
        try {                                                                     
            //Date date = this.time.parse(System.currentTimeMillis().);
            System.out.println("[" + type + "] [" + 12 + "] " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
