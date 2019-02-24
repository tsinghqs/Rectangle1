import student.TestCase;
/**
 * Class to test BSTNode
 * @author tsingh
 * @version 2019
 */
public class ParserTest extends TestCase {
    
    /**
     * Fields for set up.
     */
    private BST<Rectangle> bst;
    private BST<Rectangle> bst1;
    //private String commands;
    private Parser parser; 
    private Parser failInsert;

    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        bst = new BST<Rectangle>();
        bst1 = new BST<Rectangle>();
        String commands = "insert e 11 11 10 10";
        String commands1 = "remove 11 11 0 0";
        parser = new Parser(bst, commands);
        failInsert = new Parser(bst1, commands1);
    }
    
    /**
     * method to test Insert
     */
    public void testParseStrint()
    {
        parser.parseString();
        assertFalse(bst.size() < 1);
        failInsert.parseString();
    }
}