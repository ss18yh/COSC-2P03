import java.util.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
/*Salman Saeed
Student Number: 6479018
Assignment #1
COSC 2P03
 */

/* we create a class called rnaSecStrcAnalysis" to implement a doubly linked list and
then read and store data from the rna_data.txt file to the doubly linked list as specified
by the assignment.
 */
public class rnaSecStrcAnalysis extends stackForDotBracket {
    private LinkedListNode head;//the assignment specified the list should have a head, so we create the instance here, the head holds the first node of the doubly linked list
    private LinkedListNode tail;//the assignment also specified the list have a tail, the tail holds the last node of the doubly linked list
    private int size; //holds the length of the doubly linked list, returns the number of nodes the list has


    /* Here we create an inner class for the doubly linked list
     and specify the contents each node should have
     */

    private class LinkedListNode {
        private String primarySequence; //data #1 of each node should be in format "CCUCCAAUACCCGGCCGAGACGACUGGUCUCAGCUGGAUA" is defined as a String type.
        private String dotBracketString;//data #1 of each node should be in format ".......((.((.((.(((((.....))))).)).)).))" is also defined as a String type.
        private int validity;// data #3 of each node, validity is an integer that represents weather each dotBracketString has matching brackets (1 for Yes and 0 for No).
        private LinkedListNode previous; //the list holds a pointer to the previous node (unlike a singly linked list where you only have a next pointer).
        private LinkedListNode next;//the list holds a pointer to next node as well, hence making it  a doubly linked list

        public LinkedListNode(String primarySequence, String dotBracketString, int validity) { //constructor takes our three data types.
            this.primarySequence = primarySequence; //data #1.
            this.dotBracketString = dotBracketString;// data #2.
            this.validity = validity;//data #3.
        }

    }

    public rnaSecStrcAnalysis() {//constructor for the rnaSecStrcAnalysis class to assign the values of the 3 instance variables we created in the private DoublyLinkedList class above.
        this.head = null;// head points to null initially.
        this.tail = null;//tail also points to null initially.
        this.size = 0;// size is 0 as the list is originally empty.
    }

    public boolean isEmpty() {//this method returns a boolean value to indicate weather the doubly linked list is empty or not.
        return size == 0;// will return True is size is equal to 0, otherwise False.
    }

    public int size() {//this method returns the length of the doubly linked list.
        return size;//returns an integer value indicating the length of the linked list.
    }
    /*This method enables us to add a node at the end of a doubly linked list,
    it takes 3 arguments since we want to place 3 different data in each node (primarySequence (String), dotBracketString (String), validity (int).
     */

    public void insertLast(String value1, String value2, int value3) {
        LinkedListNode newNode = new LinkedListNode(value1, value2, value3);// we create a new node based on the values we pass to the method.

        if (isEmpty()) {// if the linked list isEmpty = True
            head = newNode;//the newNode value gets assigned to head.

        } else { //we know the tail should point to the last node in a doubly linked list.
            tail.next = newNode;// here we use the next pointer with the tail to point it to the new node.
            newNode.previous = tail;// because we are making a doubly linked list, the new node should point back to tail so it refers to each other.
        }
        tail = newNode;// lastly, we reassign tail to point to the new node
        size++;// we increase the length of the list by 1 when a new node is inserted at the end of the doubly linked list
    }

    /*This method is to display the doubly linked list
    for my own convenience.
     */
    public void displayList() {
        if (head == null) {
            return;
        }
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println("[" + temp.primarySequence + "," + "" + temp.dotBracketString + "," + temp.validity + "]" + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /* As specified in the assignment, we create a readData method that loads
    the data from the rna_data.txt file into the class and then store the data in a doubly
    linked list accordingly. Then we also write the data from the linked list to the rna_data_result.txt file.
     */

    public void readData() throws FileNotFoundException {//we throw an exception if the desired file is not found.
        rnaSecStrcAnalysis dll1 = new rnaSecStrcAnalysis();// we create a new doubly linked list.
        PrintWriter writer = new PrintWriter("rna_data_result.txt");
        String data1 = "";// data #1 is of type String and empty initially.
        String data2 = "";//data #2 is of type String and empty at the beginning as well.
        File file = new File("C:/Users/wwwsa/OneDrive/Desktop/rna_data.txt");//create the file and input filepath and name.
        Scanner scan = new Scanner(file);//use scanner to read file
        while (scan.hasNextLine()) {//loop through the text file, if there is a next line we keep going
            data1 = scan.nextLine();//every first line gets assigned to data #1, the first data in each node (primary sequence)
            data2 = scan.nextLine();//every second line gets assigned to data #2 the second piece of data in each node (dotBracketString).
            int data3 = checkValidity(data2);//data #3 is of type int and gets the value from the checkValidity method (0 or 1) as per the assignment instruction.
            dll1.insertLast(data1, data2, data3);// we insert the data into the each node of the doubly linked list.
            writer.println(data1);
            writer.println(data2);
            writer.println(data3);
        }
        writer.close();
        dll1.displayList();

    }


    public static void main (String [] args) throws FileNotFoundException {
        rnaSecStrcAnalysis doublyLinkedList = new rnaSecStrcAnalysis();
        doublyLinkedList.readData();




        }








    }


