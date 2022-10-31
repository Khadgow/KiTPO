package model.usertype.type;
import java.io.Serializable;
import java.lang.Exception;

public class TimeClass implements Serializable{
    private int hour;
    private int minute;
    private int second;

    public TimeClass( int hour, int minute, int second)  {
        try {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        }
        catch(Exception ex) {
            System.out.println("Bad time");
        }
    }

    public TimeClass() {
        try{
            setHour(11);
            setMinute(11);
            setSecond(11);

        }
        catch(Exception ex) {
            System.out.println("Bad time");
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws Exception {
        if(hour < 0 || hour > 23) {
            throw new Exception("Bad hour");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws Exception {
        if(minute < 0 || minute > 59) {
            throw new Exception("Bad minute");
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) throws Exception {
        if(second < 0 || second > 59) {
            throw new Exception("Bad second");
        }
        this.second = second;
    }
    @Override
    public String toString() {
        String total = "";
        if(hour < 10) total += "0";
        total += String.valueOf(hour);
        total += ":";
        if(minute < 10) total += "0";
        total += String.valueOf(minute);
        total += ":";
        if(second < 9) total += "0";
        total += String.valueOf(second);
        return total;
    }
}
