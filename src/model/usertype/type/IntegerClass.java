package model.usertype.type;

import java.io.Serializable;

public class IntegerClass implements Serializable {
    private int value;
    public IntegerClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
