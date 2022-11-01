package model.cycleList;

import model.comparator.Comparator;
import model.usertype.prototype.UserType;

import java.io.*;

public class CycleList implements Serializable {

    private Node head;
    private int length;

    private Comparator comparator;

    private class Node implements Serializable {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public CycleList(Comparator comparator) {
        this.comparator = comparator;
    }

    public void add(Object data) {
        if (head == null) {
            Node node = new Node(data);
            node.next = node.prev = node;
            head = node;
            length++;
            return;
        }
        Node tail = head.prev;
        Node node = new Node(data);
        node.next = head;
        head.prev = node;
        node.prev = tail;
        tail.next = node;
        length++;
    }

    public void add(Object data, int index) {
        Node tmp = getNode(index);
        Node newNode = new Node(data);
        Node tail = head.prev;
        if (tmp != head) {
            tmp.prev.next = newNode;
            newNode.prev = tmp.prev;
        } else {
            head = newNode;
        }
        newNode.next = tmp;
        tmp.prev = newNode;
        tail.next = head;
        head.prev = tail;
        length++;
    }

    public void remove(int index) {
        Node tmp = getNode(index);
        Node tail = head.prev;
        if (tmp != head) {
            tmp.prev.next = tmp.next;
        } else {
            head = tmp.next;
        }
        if (tmp != tail) {
            tmp.next.prev = tmp.prev;
        } else {
            tail = tmp.prev;
        }
        tmp.next = tmp.prev = null;
        tail.next = head;
        head.prev = tail;
        length--;
    }

    public Object getByIndex(int index) {
        return getNode(index).data;
    }

    public int getLength() {
        return length;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void forEach(Iterator<Object> iterator) {
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            iterator.toDo(tmp.data);
            tmp = tmp.next;
        }
    }

    public void sort() {
        if (this.length == 0)
            return;

        quickSort( 0, length-1);
    }

    public void quickSort(int low, int high) {

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Object opora = getByIndex(middle);

        int i = low, j = high;
        while (i <= j) {
            while ( comparator.compare(getByIndex(i), opora) < 0) {
                i++;
            }

            while (comparator.compare(getByIndex(j), opora) > 0) {
                j--;
            }

            if (i <= j) {
                Object temp = this.getByIndex(i);
                getNode(i).data = getNode(j).data;
                getNode(j).data = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }


    public void forEachReverse(Iterator<Object> iterator) {
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            iterator.toDo(tmp.data);
            tmp = tmp.prev;
        }
    }

    public void printList() {
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(i + ") ");
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            str = str + tmp.data + "\n";
            tmp = tmp.next;
        }
        return str;

    }

    public void clearList() {
        head = null;
        length = 0;
    }


    public void save(UserType userType, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(userType.typeName() + "\n");
            this.forEach(el -> {
                try {
                    writer.write(el.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(UserType userType, String fileName) {
        clearList();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = br.readLine();
            if (!userType.typeName().equals(line)) {
                throw new Exception("Wrong file structure");
            }

            while ((line = br.readLine()) != null) {
                add(userType.parseValue(line));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}