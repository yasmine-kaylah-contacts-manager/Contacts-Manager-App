package src;

import com.sun.source.tree.ClassTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private String fileName;
    private String directory;
    private List<String> contactData;

    private Path directoryPath;
    private Path filePath;

    public static List<Contacts> Personlist = new ArrayList<>();

    public static int startMenu() {
//        System.out.println("-----------------------------");
        System.out.println("\nWhat would you like to do?");
        System.out.println("  1. View contacts");
        System.out.println("  2. Add a new contact");
        System.out.println("  3. Search a contact by name and/or phone number.");
        System.out.println("  4. Delete an existing contact.");
        System.out.println("  5. Exit");
        System.out.print("\nEnter an option (1, 2, 3, 4 or 5): ");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        System.out.println("-----------------------------");
        return userInput;
    }

    public static void addPerson() throws IOException{
        Scanner sc= new Scanner(System.in);
        System.out.println(" 1. Add a New Person");
        System.out.print(" First Name: ");
        String firstName = sc.nextLine();
        System.out.print(" Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = sc.nextLine();
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + phoneNumber),
                StandardOpenOption.APPEND //If the file is opened for WRITE access then bytes will be written to the end of the file rather than the beginning.
        );
        Personlist.add(new Contacts(firstName, lastName, phoneNumber));
        System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");

    }


    //Read the file
    public Manager(String filename, String directory) {
        this.fileName = filename;
        this.directory = directory;

        // Paths for directory and files
        this.directoryPath = Paths.get(directory);
        this.filePath =  Paths.get(directory, filename);

        this.contactData = getContacts();
    }

    public static void printList() {
        System.out.println("Name | Phone number ");
        System.out.println("-----------------------------");
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist = null;
        try {
            Personlist = Files.readAllLines(ContactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Personlist.size(); i += 1) {
            System.out.println((i + 1) + ": " + Personlist.get(i));

        }
    }

    //Create our getContact method
    private List<String> getContacts() {

        // Make sure the directory exists
        try {
            if(Files.notExists(directoryPath)) Files.createDirectories(directoryPath);
        } catch (IOException e) {
            System.out.println("Could not create directories " + directoryPath.getFileName());
            e.printStackTrace();
        }

        // We need to make sure the files exists
        try {
            if(Files.notExists(filePath)) Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("Could not create files " + filePath.getFileName());
            e.printStackTrace();
        }

        // If the file does not exist, we need to create it

        List<String> data = null;

        try {
            data = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Could not read files " + filePath.getFileName());
            e.printStackTrace();
        }
        return data;
    }

        public void printLines(){
            for (String line : contactData) {
                System.out.println(line);
            }
        }
public static void exit(){
    System.out.println("Thanks for using Contacts Manager! Hope to see you soon.");
    System.exit(0);
}


        // readAllLines -> returns a List<String>

}
