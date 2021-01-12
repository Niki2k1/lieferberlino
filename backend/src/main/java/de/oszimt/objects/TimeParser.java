package de.oszimt.objects;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeParser {

    private ArrayList<LocalTime> times;

    /**
     * Constructor from object.
     */
    public TimeParser(String timeAsString) {
        this.times = new ArrayList<>();
        if(timeAsString.contains("&")) {
            timeAsString = timeAsString.split(" & ")[0];
        }
        String[] time = timeAsString.split("-");
        LocalTime time1 = LocalTime.parse(time[0].equalsIgnoreCase("0:00") ? "00:00" : time[0], DateTimeFormatter.ofPattern("HH:mm"));
        this.times.add(time1);
        LocalTime time2 = LocalTime.parse(time[1].equalsIgnoreCase("0:00") ? "00:00" : time[1], DateTimeFormatter.ofPattern("HH:mm"));
        this.times.add(time2);
    }
    /**
     * Return if the parsed time is in the current time.
     */
    public boolean isOpen() {
        LocalTime time = LocalTime.now();
        if (this.times.get(0).isAfter(this.times.get(1))) {
            return !time.isBefore(this.times.get(0)) || !time.isAfter(this.times.get(1));
        } else {
            return !time.isBefore(this.times.get(0)) && !time.isAfter(this.times.get(1));
        }
    }
}
