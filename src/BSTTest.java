import student.TestCase;

public class BSTTest extends TestCase {
    
    private BST<Rectangle> bst;
    
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        bst = new BST<Rectangle>();
    }

    /**
     *  Tests insert()
     */
    public void testGetRootNode() 
    {
        assertNull(bst.getRootNode());
    }

    /**
     *  Tests insert()
     */
    public void testGetIterator() 
    {
        bst.getIterator();
        assertNull(bst.getRootNode());
    }
    
    /**
     *  Tests insert()
     */
    public void testInsert() 
    {
        Rectangle r = new Rectangle("hello", 1, 2, 3, 4);
        bst.insert(r);
        assertEquals(bst.size(), 1);
    }
    
    /**
     *  Tests remove()
     */
    public void testRemove() 
    {     
  
    }

    /**
     *  Tests findMin(), findMax()
     */
    public void testDump() 
    {

    }


}
