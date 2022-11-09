package model.usertype.prototype;

import model.comparator.Comparator;
import model.comparator.TimeComparator;
import model.usertype.type.TimeClass;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.Collectors;

public class TimeType implements UserType {

    @Override
    public String typeName() {
        return "Time";
    }

    @Override
    public Object create() {

        int minHour = 0, maxHour = 23;
        int minTime = 0, maxTime = 59;

        Random rand = new Random();
        int hour = rand.nextInt(maxHour - minHour);
        int minute = rand.nextInt(maxTime - minTime);
        int second = rand.nextInt(maxTime - minTime);
        TimeClass dateTimeValue;
        try {
        dateTimeValue = new TimeClass(hour, minute, second);
        }
        catch(Exception ex) {
            System.out.println("Bad time, generating using a static values");
            dateTimeValue = new TimeClass();
        }
        return dateTimeValue;
    }

    @Override
    public Object clone(Object obj) {
        TimeClass copyDateTime;
        try {
            copyDateTime = new TimeClass(((TimeClass)obj).getHour(), ((TimeClass)obj).getMinute(), ((TimeClass)obj).getSecond());
        }
        catch(Exception ex) {
            copyDateTime = new TimeClass();
        }
        return copyDateTime;
    }

    @Override
    public Object readValue(InputStream inputStream) {
        return parseValue(new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n")));
    }

    @Override
    public Object parseValue(String line) {
        String[] timeStr = line.split(":");
        Integer[] timeInt = new Integer[3];

        for (int i = 0; i < 3; i++) {
            timeInt[i] = Integer.parseInt(timeStr[i]);
        }

        TimeClass dateTimeValue;
        try {
            dateTimeValue = new TimeClass(timeInt[0], timeInt[1], timeInt[2]);
        }
        catch(Exception ex) {
            System.out.println("Bad time, generating using a static values");
            dateTimeValue = new TimeClass();
        }

        return dateTimeValue;
    }

    @Override
    public Comparator getTypeComparator() {
        Comparator comparator = new TimeComparator();
        return comparator;
    }
}
