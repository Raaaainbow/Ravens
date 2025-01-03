import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

public class Ravens {
    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("To recieve a random raven fact, please type \"yes\", if you wish to exit the program type \"no\"");
        factReader();
    }

    public static void factGiverInput(int counter, HashMap<Integer, String> factsHash, Set<Integer> usedFacts) {
        while (true) {
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            int randNum;
            do {
                randNum = randomNumber(counter);
            } while (usedFacts.contains(randNum));

            if (input.toLowerCase().equals("yes")) {
                factFinder(randNum, factsHash, usedFacts);
            }

            if (usedFacts.size() == counter) {
                System.out.println("This program only has " + counter + " raven facts");
                System.out.println("If you wish to add more facts, please edit the file called \"Facts.txt\"");
                console.close();
                break;
            }

            if (input.toLowerCase().equals("no")) {
                System.out.println("Goodbye");
                console.close();
                break;
            }
            console.close();
        }
    }

    public static void factFinder(int randNum, HashMap<Integer, String> factsHash, Set<Integer> usedFacts) {
            System.out.println("Here is a random raven fact:");
            System.out.println(factsHash.get(randNum));
            System.out.println("-------------------------------");
            System.out.print("Do you wish to recieve another fact? ");
            usedFacts.add(randNum);
            // System.out.println(usedFacts.size()); // used for debugging
    }

    public static void factReader() throws FileNotFoundException {
        File file = new File("Facts.txt");      // Opens file change string if file changed 
        Scanner reader = new Scanner(file);     // Creates Scanner object to read the file
        HashMap<Integer, String> factsHash = new HashMap<>();
        Set<Integer> usedFacts = new HashSet<>();
        // Implement HashMap for gettings facts, keys = {1,2,3,..}, facts in order
        // Implement Hashset for checking if fact has appeared before
        int counter = 0;

        if (file.exists() && file.canRead()) {  // Checks if file is accessible
            while (reader.hasNextLine()) {
                factsHash.put(counter, reader.nextLine());
                counter++;
            }
        } else {
            reader.close();
            throw new FileNotFoundException("The file \"Facts.txt\" could not be found in the correct directory");
        }
        reader.close();
        /*
        for (int i = 0; i < facts.size(); i++) {    // Prints all facts, mainly for debugging purposes
            System.out.println((i+1) + ": " + facts.get(i));
        }
        */
        factGiverInput(counter, factsHash, usedFacts);
    }

    public static int randomNumber (int counter) {
        Random rand = new Random();
        return rand.nextInt(counter);
    }
}
