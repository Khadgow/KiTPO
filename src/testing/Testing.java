package testing;

import model.cycleList.CycleList;
import model.factory.FactoryType;
import model.usertype.prototype.UserType;


public class Testing {
    private FactoryType factoryType;
    private UserType userType;
    private CycleList cycleList;


    private static String INT_FILE_SAVE = "integer.dat";
    private static String TIME_FILE_SAVE = "time.dat";
    public void testFloatType(){
        factoryType = new FactoryType();
        System.out.println("\n--------------TEST FOR INTEGER-------------");
        userType = factoryType.getBuilderByName("Integer");
        cycleList = new CycleList(userType.getTypeComparator());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("-----SAVE TO FILE .DAT----");
        try {
            cycleList.save(userType, INT_FILE_SAVE);
            System.out.println("Saving is successful!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n----GET NODE BY INDEX 3, 4, 5, 6----");
        System.out.println("3) = " + cycleList.getByIndex(3).toString());
        System.out.println("4) = " + cycleList.getByIndex(4).toString());
        System.out.println("5) = " + cycleList.getByIndex(5).toString());
        System.out.println("6) = " + cycleList.getByIndex(6).toString());

        System.out.println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--");
        cycleList.remove(3);
        cycleList.remove(4);
        cycleList.remove(5);
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM FILE----");
        cycleList.load(userType, INT_FILE_SAVE);
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);

        System.out.println("---------ITERATOR REVERSE-----------");
        cycleList.forEachReverse(System.out::println);
    }

    public void testPointType(){
        factoryType = new FactoryType();
        System.out.println("\n--------------TEST FOR TIME-------------");
        userType = factoryType.getBuilderByName("Time");
        cycleList = new CycleList(userType.getTypeComparator());

        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("-----SAVE TO FILE .DAT----");
        try {
            cycleList.save(userType, TIME_FILE_SAVE);
            System.out.println("Saving is successful!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n----GET NODE BY INDEX 3, 4, 5, 6----");
        System.out.println("3) = " + cycleList.getByIndex(3).toString());
        System.out.println("4) = " + cycleList.getByIndex(4).toString());
        System.out.println("5) = " + cycleList.getByIndex(5).toString());
        System.out.println("6) = " + cycleList.getByIndex(6).toString());

        System.out.println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--");
        cycleList.remove(3);
        cycleList.remove(4);
        cycleList.remove(5);
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM FILE----");
        cycleList.load(userType, TIME_FILE_SAVE);
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);

        System.out.println("---------ITERATOR REVERSE-----------");
        cycleList.forEachReverse(System.out::println);
    }
}