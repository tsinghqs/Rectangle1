import student.TestCase;

/**
 * @version 2019
 * @author tsingh
 *Class for BST Testing
 */
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
     *  Tests getRootNode()
     */
    public void testGetRootNode() 
    {
        assertNull(bst.getRootNode());
    }

    /**
     *  Tests getIterator()
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
        Rectangle b = new Rectangle("b", 1, 2, 3, 4);
        bst.insert(b);
        assertEquals(bst.size(), 1);
        Rectangle a = new Rectangle("a", 1, 2, 3, 4);
        bst.insert(a);
        assertEquals(bst.size(), 2);
        Rectangle c = new Rectangle("c", 1, 2, 3, 4);
        bst.insert(c);
        assertEquals(bst.size(), 3);
    }
    
    /**
     *  Tests remove()
     */
    public void testRemove() 
    {     
        BST<Integer> bstInt = new BST<Integer>();
        bstInt.insert(1);
        assertEquals(bstInt.size(), 1);
        bstInt.insert(0);
        bstInt.insert(2);
        bstInt.remove(1);
        bstInt = new BST<Integer>();
        bstInt.insert(1);
        bstInt.insert(0);
        bstInt.remove(0);
        bstInt = new BST<Integer>();
        bstInt.insert(0);
        bstInt.insert(1);
        bstInt.remove(1);
        bstInt = new BST<Integer>();
        bstInt.insert(1);
        bstInt.insert(0);
        bstInt.remove(1);
        bstInt = new BST<Integer>();
        bstInt.insert(0);
        bstInt.insert(1);
        bstInt.remove(0);
    }

    /**
     *  Tests findMin(), findMax()
     */
    public void testDump() 
    {
        bst.dump();
        Rectangle b = new Rectangle("b", 1, 2, 3, 4);
        assertEquals(b.getName(), "b");
        bst.insert(b);
        bst.dump();
        Rectangle a = new Rectangle("a", 1, 2, 3, 4);
        bst.insert(a);
        bst.dump();
        Rectangle c = new Rectangle("c", 1, 2, 3, 4);
        bst.insert(c);
        bst.dump();
    }


}
