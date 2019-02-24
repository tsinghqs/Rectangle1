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
    private BSTNode<Integer> right = new BSTNode<Integer>(5);
    private Iterator<Integer> tester1;

    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        tester = new Iterator<Integer>(rootNode);
        tester1 = new Iterator<Integer>(null);

    }
    
    public void testHasNext()
    {
        assertTrue(tester.hasNext());
        rootNode.setLeftNode(left);
        rootNode.setRightNode(right);
        assertEquals(rootNode, tester.next());
        tester.next();
        assertFalse(tester1.hasNext());
    }
    
    
}
