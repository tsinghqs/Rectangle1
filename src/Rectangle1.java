import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


/**
 * This is class responsible for running the project properly. 
 * @author tsinghqs
 * @version 2018.02.19
 *
 */
public class Rectangle1 {
    /**
     * This is the main class and function that runs the project
     * 
     * @param args a string value to run the project
     * @throws FileNotFoundException 
     */

    public static void main(String[] args) throws FileNotFoundException
    {
       //read file as an argument
       String fileName = args[0];
       File file = new File(fileName);
       Scanner sc = new Scanner(file);
       
       //initialize BST
       BST<Rectangle> recBST = new BST<Rectangle>();
       while (sc.hasNextLine())
       {
           String line = sc.nextLine();
           Parser parse = new Parser(recBST, line);
           parse.parseString();
        
       }
       sc.close();
       
    }
}