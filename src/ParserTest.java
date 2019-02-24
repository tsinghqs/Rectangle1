/**
 * Class to test BSTNode
 * @author tsingh
 *@version 2019
 * @param <T>
 */
public class ParserTest extends student.TestCase {
    
    BST<Rectangle> bst = new BST<Rectangle>();
    BST<Rectangle> bst1 = new BST<Rectangle>();

    String commands = "insert e 11 11 10 10";
    String commands1 = "insert e 11 11 0 0";
    Parser parser; 
    Parser failInsert;

    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
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