package P04_Baume;

import java.io.*;
import java.text.ParseException;

/**
 * This class imports competitor data from a CSV into a binary sorted tree.
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class Importer {
    private static final String FILEPATH = "/Users/margash/ownCloud/ZHAW/3_Semester/ADS/P4/zuerich_marathon_utf_8.csv";

    /**
     * Imports competitor data from a CSV file into a binary sorted tree.
     * The file needs the following cells in the correct ordering followed by a linefeed.
     * Number, First name, Last name, Year of birth, City, Time
     * @param args not used
     */
    public static void main (String[] args) {
        BinarySearchTree<Competitor> tree = new BinarySearchTree<>();
        BufferedReader CSVFile = null;

        try {
            CSVFile = new BufferedReader(new FileReader(FILEPATH));

            String currentRow = CSVFile.readLine();
            while (currentRow != null) {
                String[] cells = currentRow.split(",");
                tree.add(new Competitor(new Integer(cells[0]),cells[1],cells[2],new Integer(cells[3]),cells[4],cells[5]));
                currentRow = CSVFile.readLine();
            }
        }

        catch (ParseException e) {
            System.out.println("Couldn't convert one of the values to Integer");
        }
        catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist");
        }
        catch (IOException e) {
            System.out.println("Couldn't read from file");
        }
        finally {
            try {
                if (CSVFile != null) {
                    CSVFile.close();
                }
            } catch (IOException e) {
                System.out.println("Couldn't close the file although it appears to be still open");
            }
        }
    }
}
