package model.factory;

import model.usertype.prototype.AvailableTypes;
import java.util.Arrays;

import model.usertype.prototype.IntegerType;
import model.usertype.prototype.TimeType;
import model.usertype.prototype.UserType;

import java.util.ArrayList;

public class FactoryType {
    private final static ArrayList<UserType> typeNameList = new ArrayList<>();

    static {
        ArrayList<UserType> buildersClasses = new ArrayList<>(Arrays.asList(new IntegerType(), new TimeType()));
        typeNameList.addAll(buildersClasses);
    }
    public ArrayList<String> getTypeNameList() {
        ArrayList<String> list = new ArrayList<>();
        for(AvailableTypes at : AvailableTypes.values()) {
            list.add(String.valueOf(at));
        }
        return list;
    }

    public UserType getBuilderByName(String name){
        for (UserType userType : typeNameList) {
            if (name.equals(userType.typeName()))
                return userType;
        }
        return null;
    }
}
