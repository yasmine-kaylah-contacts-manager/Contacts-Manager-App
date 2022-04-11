package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Manager {
    private String fileName;
    private String directory;
    private List<String> contactData;

    private Path directoryPath;
    private Path filePath;


    //Read the file
    public Manager(String filename, String directory) {
        this.fileName = filename;
        this.directory = directory;

        // Paths for directory and files
        this.directoryPath = Paths.get(directory);
        this.filePath =  Paths.get(directory, filename);

        this.contactData = getContacts();
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



        // readAllLines -> returns a List<String>

}
