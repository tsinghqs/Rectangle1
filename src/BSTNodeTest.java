/**
 * Class to test BSTNode
 * @author tsingh
 *@version 2019
 * @param <T>
 */
public class BSTNodeTest<T> extends student.TestCase {
    
    private BSTNode<Integer> tester;
    private BSTNode<Integer> left;
    private BSTNode<Integer> right;
    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        tester = new BSTNode<Integer>(1);
        left = new BSTNode<Integer>(2);
        right = new BSTNode<Integer>(3);
    }

    /**
     *  Tests insert()
     */
    public void testGetElement() 
    {
        int elem = tester.getElement();
        assertEquals(elem, 1);
        tester.setElement(5);
        elem = tester.getElement();
        assertEquals(elem, 5);
    }
    
    /**
     * Method to get left node
     */
    public void testGetLeftNode()
    {
        tester.setLeftNode(left);
        assertEquals(left, tester.getLeftNode());
    }
    
    /**
     * Method to get right node
     */
    public void testGetRightNode()
    {
        tester.setRightNode(right);
        assertEquals(right, tester.getRightNode());
        String test = tester.toString();
        assertEquals(test, tester.toString());
    }
    
   
    
    
    
    
    
    


}
