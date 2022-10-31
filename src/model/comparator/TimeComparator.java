package model.comparator;

import model.usertype.type.TimeClass;

import java.io.Serializable;

public class TimeComparator implements Comparator, Serializable {
    @Override
    public int compare(Object o1, Object o2) {
        int hourL = ((TimeClass) o1).getHour();
        int hourR = ((TimeClass) o2).getHour();
        int minuteL = ((TimeClass) o1).getMinute();
        int minuteR = ((TimeClass) o2).getMinute();
        int secondL = ((TimeClass) o1).getSecond();
        int secondR = ((TimeClass) o2).getSecond();

        int timeL = hourL * 60 * 60 + minuteL * 60 + secondL;
        int timeR = hourR * 60 * 60 + minuteR * 60 + secondR;

        return timeL - timeR;
    }
}
