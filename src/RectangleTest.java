import student.TestCase;

/**
 * Tests for Rectangle class
 * @author vpratha
 * @version 2019
 *
 */
public class RectangleTest extends TestCase
{
    /**
     * field used in multiple tests
     */
    private Rectangle rect;
    private Rectangle rect2;
    
    /**
     * Set up for test cases.
     */
    public void setUp() 
    {
        rect2 = new Rectangle();
        rect = new Rectangle("", 1, 2, 3, 4);
    }
    
    /**
     * Tests getWidth()
     */
    public void testGetWidth()
    {
        assertEquals(rect.getWidth(), 3);
    }

    /**
     * Tests setWidth()
     */
    public void testSetWidth()
    {
        rect.setWidth(5);
        assertEquals(rect.getWidth(), 5);
    }
    
    /**
     * Tests getHeight()
     */
    public void testGetHeight()
    {
        assertEquals(rect.getHeight(), 4);
    }

    /**
     * Tests setHeight()
     */
    public void testSetHeight()
    {
        rect.setHeight(5);
        assertEquals(rect.getHeight(), 5);
    }
    
    /**
     * Tests getX()
     */
    public void testGetX()
    {
        assertEquals(rect.getX(), 1);
    }

    /**
     * Tests setX()
     */
    public void testSetX()
    {
        rect.setX(0);
        assertEquals(rect.getX(), 0);
    }
    
    /**
     * Tests getY()
     */
    public void testGetY()
    {
        assertEquals(rect.getY(), 2);
    }

    /**
     * Tests setY()
     */
    public void testSetY()
    {
        rect.setY(0);
        assertEquals(rect.getY(), 0);
    }
    
    /**
     * Tests getName()
     */
    public void testGetName()
    {
        assertEquals(rect.getName(), "");
    }

    /**
     * Tests setName()
     */
    public void testSetName()
    {
        rect.setName("name");
        assertEquals(rect.getName(), "name");
    }
    
    /**
     * Tests compareTo()
     */
    public void testCompareTo()
    {
        assertEquals(rect.compareTo(rect2), 0);
    }
}
