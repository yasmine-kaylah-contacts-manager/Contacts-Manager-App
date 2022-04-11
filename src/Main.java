package src;

import java.io.IOException;

public interface Main {

    static void main(String args[]) throws IOException {

        while (true) {
            int userChoice = Manager.startMenu();
            if (userChoice == 1)
                Manager.printList();
            else if (userChoice == 2)
                Manager.addPerson();
            //Search
            //Delete Contact
            else if (userChoice == 5) {
                Manager.exit();
            } else
                System.out.println("Invalid input.");
        }
    }
}


//Line 7 Throws IOException Findings
// can be used with a method to declare multiple exceptions IOException is the exception class name and checks exceptions by itself.. This is a big difference with the Throw method which can only be used WITHIN the method and only a single execption will be thrown.

// https://rollbar.com/blog/how-to-use-the-throws-keyword-in-java-and-when-to-use-throw/