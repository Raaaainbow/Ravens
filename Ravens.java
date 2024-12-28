import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Ravens {
    public static void main (String[] args) throws FileNotFoundException {
        factReader();
    }

    public static void factGiverInput(int counter, ArrayList <String> facts) {
        System.out.println("to recieve a random raven fact, please type \"yes\", if you wish to exit the program, type anything else.");
        int randNum = randomNumber(counter);
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        input.toLowerCase();
        if (input.equals("yes")) {
            System.out.println("Here is a random raven fact");
            System.out.println(facts.get(randomNumber(counter)));
            factGiverInput(counter, facts);
            console.close();
        } else {
            console.close();
            System.out.println("Goodbye");
        }
    }

    public static void factReader() throws FileNotFoundException {
        File file = new File("Facts.txt");      // Opens file change string if file changed 
        Scanner reader = new Scanner(file);     // Creates Scanner object to read the file
        ArrayList <String> facts = new ArrayList<String>();     // Array list to store facts in memory
        int counter = 0;

        if (file.exists() && file.canRead()) {  // Checks if file is accessible
            while (reader.hasNextLine()) {
                facts.add(reader.nextLine());   // Adds fact to list
                counter++;
            }
        } else {
            reader.close();
            throw new FileNotFoundException("The file \"Facts.txt\" could not be found in the correct directory");
        }
        reader.close();

        for (int i = 0; i < facts.size(); i++) {    // Prints all facts, mainly for debugging purposes
            System.out.println((i+1) + ": " + facts.get(i));
        }
        factGiverInput(counter, facts);
    }

    public static int randomNumber (int counter) {
        Random rand = new Random();
        return rand.nextInt(counter);
    }
}