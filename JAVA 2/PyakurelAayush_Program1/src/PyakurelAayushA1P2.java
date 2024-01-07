import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PyakurelAayushA1P2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the name of the text file: ");
        String fileName = userInput.nextLine();

        File file = new File(fileName);

        try {
            Scanner fileScanner = new Scanner(file);

            int totalScores = 0;
            int parsableLines = 0;
            int unparsableLines = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] tokens = line.split(" ");

                if (tokens.length == 2) {
                    try {
                        int score = Integer.parseInt(tokens[1]);
                        totalScores += score;
                        parsableLines++;
                    } catch (NumberFormatException e) {
                        unparsableLines++;
                        System.err.println("Cannot parse '" +tokens[1]+ "' as an integer.");
                    }
                } else {
                    unparsableLines++;
                    System.out.println("Line does not have two items: " +line);
                }
            }

            if (parsableLines > 0) {
                int average = totalScores / parsableLines;
                System.out.println("Average of grades is "+average);
            } else {
                System.out.println("Average of grades can't be calculated, there are no grades.");
            }

            System.out.println("Number of parsable lines: "+parsableLines);
            System.out.println("Number of unparsable lines: "+unparsableLines);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Source file " +fileName+ " does not exist");
            System.exit(1);
        }
    }
}
