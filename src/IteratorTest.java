/**
 * Class to test BSTNode
 * @author tsingh
 *@version 2019
 * @param <T>
 */
public class IteratorTest<T> extends student.TestCase {
    
    private Iterator<Integer> tester;
    private BSTNode<Integer> rootNode = new BSTNode<Integer>(5);
    private BSTNode<Integer> left = new BSTNode<Integer>(2);

    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        tester = new Iterator<Integer>(rootNode);
    }
    
    public void testHasNext()
    {
        assertTrue(tester.hasNext());
        rootNode.setLeftNode(left);
        assertEquals(rootNode, tester.next());
        
    }
    
    
}
