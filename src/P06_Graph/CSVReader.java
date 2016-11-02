package P06_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class CSVReader {

    public static final String CSVDELIMITER = ",";

    static ArrayList<Integer> readFile(String filepath) {
        BufferedReader reader = null;
        ArrayList<Integer> valueList = new ArrayList<>();
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filepath);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String currentRow = reader.readLine();
            while (currentRow != null) {
                String[] numbers = currentRow.split(CSVDELIMITER);
                for (String number : numbers) {
                    valueList.add(new Integer(number));
                }
                currentRow = reader.readLine();
            }
        }
        catch (NullPointerException e) {
            System.out.println("The file doesn't exist");
        }
        catch (IOException e) {
            System.out.println("Couldn't read from file");
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Couldn't close the file although it appears to be still open");
            }
        }
        return valueList;
    }
}
