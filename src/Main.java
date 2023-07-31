import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> myArrList = new ArrayList<>();  // note the diamond notation on the type parameter <>

    //Void:- it is a return type that is it does not return any value.
    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            //Display menu
            displayMenu();
            String userChoice = SafeInput.getRegExString(in, "Enter your choice", "[AaDdPpQq]");
            if (userChoice.equalsIgnoreCase("A")) {
                addItem();
            } else if (userChoice.equalsIgnoreCase("D")) {
                deleteItem();
            } else if (userChoice.equalsIgnoreCase("P")) {
                printList();
            } else if (userChoice.equalsIgnoreCase("Q")) {
                quitProgram();
                System.exit(0);
            } else {
                System.out.println("You get other");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print (display) the list");
        System.out.println("Q – Quit the program");
    }
    ////Insert an element at location m
    private static void addItem(){
        System.out.println("Enter the item to add: ");
        String item = in.nextLine();
        if (myArrList.size() < 1)
        {myArrList.add(item);}
        else {
            if (SafeInput.getYNConfirm(in,"Do you want to rearrange the item?"))
            {
                int m = SafeInput.getRangedInt(in,"Enter the location of item you want to add: ",1,myArrList.size())-1;
                in.nextLine(); // Consume the leftover newline character after reading the integer
                //When enter an integer, the Scanner consumes only the number and leaves the newline character (\n) in the input buffer.
                //using in.nextLine() to read the item, it reads the leftover newline character instead of waiting for  input.
                //To fix this, can add an additional in.nextLine() after reading the integer to consume the leftover newline character before reading the item.
                myArrList.add(m,item);
            }
            else {myArrList.add(item);}
        }
        System.out.println(myArrList);
    }
    private static void deleteItem(){
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int m = SafeInput.getRangedInt(in,"Enter the location of item you want to delete: ",1, myArrList.size())-1;
        myArrList.remove(m); //Overwrite or replace an item at index m:
        in.nextLine();
        System.out.println(myArrList);
    }
    private static void printList(){
        if (myArrList.isEmpty())
        {
            System.out.println("The list is empty. Nothing to print.");
            return;
        }
        else
        {
            System.out.println("Current list: ");
            System.out.println(myArrList);
        }
    }
    private static void quitProgram()
    {
        if(SafeInput.getYNConfirm(in,"Are you sure you want to quit? (Y/N): "))
        {
            System.out.println("Goodbye!");
        }
        in.close();
    }
}
