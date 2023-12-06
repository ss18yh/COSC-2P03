import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*Salman Saeed
Student Number: 6479018
Assignment #1
COSC 2P03
 */

/*we create the class to implement a stack, that will be used to check for matching brackets,
we will implement the stack using a linked list, that is represented by "StackNode".
 */
public class stackForDotBracket  { //this class will have 2 instance variables
    private StackNode top; //here we create the top instance.
    private int size;// the size instance indicated the length of the stack (integer value)

    public class StackNode { //we create an inner class of type StackNode that specified what the StackNode includes.
        private String data;// the first attribute is data which is a String type
        private StackNode next;//we create a next pointer

        public StackNode(String data) { //this constructor takes the data of a node in the stack
            this.data = data;
        }
    }

    public stackForDotBracket() { //we create a constructor for the StackForDotBracket class that has two instances
        top = null;// the top will point to null so we assign it 0
        size = 0;// assign the length as 0 as the stack is initially empty
    }

    public boolean isEmpty() {//this method return a boolean value that indicates if stack is empty or not
        return size == 0;// will return True if length is 0, False otherwise
    }

    public int size() {//this method returns the length of the stack
        return size;//gives an integer value representing the length of the stack
    }


    public boolean isFull() {// this method indicates if the stack is full or not
        return size != 0;//since we do not have a limit on the max number of items, a stack can hold, this will return True if the length is not 0, False otherwise.
    }

    /*this method allows us to add elements (node) to the stack (String values).

     */
    public void push(String data) {
        StackNode temp = new StackNode(data);//we pass data in the constructor.
        temp.next = top;// assigns the value of top to temp.next.
        top = temp;//assign the value of temp to top.
        size++;// increase the length by 1 as value gets added.
    }

    /* this method removes the element (node) at the top of the stack and returns it.
     */
    public String pop() {
        if (isEmpty()) {//first we check if the stack isEmpty (cannot pop an element from an empty stack).
            throw new EmptyStackException();//so we throw an exception if it is empty.
        }
        String value = top.data;//if the stack isn't empty,we create a String called value, and we assign it to top.
        top = top.next;// top moves to next node.
        size--;//the length of stack decreases by 1 since we have removed an element.
        return value;//return the String value.
    }

    /*this method gives us the element (node) that is at top of the stack.
     */
    public String top() {
        if (isEmpty()) {// we check if stack isEmpty, (cannot get the peek element if stack is empty)
            throw new EmptyStackException();//if it is empty, we throw an exception
        }
        return top.data;//gives the top element
    }
/*This method checks if a string has matching number of opening and closing brackets, this method is then used in the
rnaStrcAnalysis class to check if the dotBracketString in the doubly linked list has equal number of
opening and closing brackets, returns value of 1 if they match and 0 otherwise.
 */
   public int checkValidity(String s) {
       stackForDotBracket stack = new stackForDotBracket();
       for (int i = 0; i < s.length(); i++) {//loop over the string
           if (s.charAt(i) == '(') {//we check  if the index of the string is where there is an opening bracket (left bracket '(' ).
               stack.push("(");// if there is an opening bracket, we push it to the stack.
           } else if (s.charAt(i) == ')') {// we check if the index of the string is at a closing bracket (right bracket ')' ).
               if (stack.size == 0) {//check if stack length is 0
                   return 0;//if it is 0, return 0
               } else {
                   stack.pop();//otherwise we pop the element from the stack
               }
           }
       }
       return stack.size() == 0 ? 1 :0;
   }

}



