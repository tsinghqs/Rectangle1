import student.TestCase;


public class BSTNodeTest<T> extends student.TestCase{
    
    BSTNode<T> tester;
    BSTNode<T> left;
    BSTNode<T> right;
    Rectangle rect;
    /**
     *  Sets up test cases.
     */
    public void setUp() 
    {
        tester = new BSTNode<Rectangle>(rect);
        left = new BSTNode<T>(null);
        right = new BSTNode<T>(null);
    }

    /**
     *  Tests insert()
     */
    public void testGetRootNode() 
    {
        
    }
    
    


}
