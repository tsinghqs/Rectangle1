/**
 * Class to test BSTNode
 * @author tsingh
 *@version 2019
 * @param <T>
 */
public class IteratorTest<T> extends student.TestCase {
    
    private Iterator<BSTNode<Integer>> tester;
    private BSTNode<Integer> rootNode = new BSTNode<Integer>(5);
    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        tester = new Iterator<BSTNode<Integer>>(rootNode);
    }
}
