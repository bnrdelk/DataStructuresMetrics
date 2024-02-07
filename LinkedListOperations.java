import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

class Node {
    public int data;
    public Node next;

    public Node(int data){
    this.data = data;
    this.next = null;   
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
    this.head = null;
    this.tail = null;
    }

    //Used to insert a node at the start of the Linked List
    public void insertToHead(int data) {
        LocalTime insertHeadStart = LocalTime.now();

        Node newNode = new Node(data);
        if(this.head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }

        LocalTime insertHeadEnd = LocalTime.now();

        Duration insertHeadDuration = Duration.between(insertHeadStart,insertHeadEnd);
        System.out.println("2b) An integer is inserted into the head of the linked list in " + insertHeadDuration.toMillis() + " milliseconds.");
    }

    //Used to insert a node at the end of the Linked List
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if(this.head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    //Used to insert a node at any index in the Linked List
    public void insert_At(int data, int index) {
        LocalTime insertAtStart = LocalTime.now();

        Node node = new Node(data);
        node.data = data;
        node.next = null;

        try{
            if(head == null) {
                head = node;
            }
            else if(index == 0) {
                node.next = head;
                head = node;
            }
            else{
                Node current = head;
                for(int i = 0; i < index - 1; i++){
                    current = current.next;
                }
                node.next = current.next;
                current.next = node;
            }
        } catch(NullPointerException e){
            e.printStackTrace();
        }

        LocalTime insertAtEnd = LocalTime.now();

        Duration insertAtDuration = Duration.between(insertAtStart, insertAtEnd);
        System.out.println("2c) An integer is inserted into index 900000 of the linked list in " + insertAtDuration.toMillis() + " milliseconds.");
    }

    //Used to read the integer at given index
    public Object get_at(int node_index){
        LocalTime getAtStart = LocalTime.now();

        if (head == null) {
            return null;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {

            if (currentIndex == node_index) {
                LocalTime getAtEnd = LocalTime.now();

                int the_value = current.data;
                Duration getAtDuration = Duration.between(getAtStart, getAtEnd);

                if(node_index == 900000 || node_index == 45000000)
                    System.out.println("2d) An integer, which is " + the_value +", is read from the index "+ node_index + " of the integer linked list in " + getAtDuration.toMillis() + " milliseconds.");
                else if(node_index == 9)
                    System.out.println("2e) An integer, which is " + the_value +", is read from the index "+ node_index + " of the integer linked list in " + getAtDuration.toMillis() + " milliseconds.");
                else
                    System.out.println("An integer, which is " + the_value +", is read from the index "+ node_index + " of the integer linked list in " + getAtDuration.toMillis() + " milliseconds.");

                return the_value;
            }
            current = current.next;
            currentIndex++;
        }

        return -1;
    }
}

public class LinkedListOperations{
    
    public static void linkedListOperations(String fileName, int bigIndex, int smallIndex) throws NullPointerException{
        LinkedList list = new LinkedList();

        list = buildList(fileName);
        list.insertToHead(5);
        list.insert_At(5, bigIndex);
        list.get_at(bigIndex);
        list.get_at(smallIndex);
    }

    //Method for building the list
    public static LinkedList buildList(String fileName) {
        LocalTime fileBuildStart = LocalTime.now();
        LinkedList list = new LinkedList();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                try {
                    int value = Integer.parseInt(nextLine);
                    list.insertLast(value);
                } catch (NumberFormatException e) {
                   e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalTime fileBuildEnd = LocalTime.now();
        Duration fileBuildDuration = Duration.between(fileBuildStart, fileBuildEnd);
        System.out.println("\n2a) The integer linked list structure is built in " + fileBuildDuration.toMillis() + " milliseconds.");

        return list;
    }
}