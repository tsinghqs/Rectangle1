import java.util.ArrayList;

/**
 * Rectangle class to store rectangle data parsed from command file.
 * @author vpratha
 * @version 2019
 */
public class Rectangle implements Comparable<Rectangle> {

    private String name;
    private int x;
    private int y;
    private int w;
    private int h;
    
    /**
     * Default constructor for rectangle class
     */
    public Rectangle()
    {
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;
    }
    
    /**
     * Constructor for the rectangle class
     * @param name name of rectangle
     * @param x x coordinate of rectangle
     * @param y y coordinate of rectangle
     * @param w width of rectangle
     * @param h height of rectangle
     */
    public Rectangle(String name, int x, int y, int w, int h)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return w;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.w = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return h;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.h = height;
    }

    /**
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @param yPos the value to set y
     */
    public void setY(int yPos) {
        this.y = yPos;
    }

    /**
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @param xPos the value to set x
     */
    public void setX(int xPos) {
        this.x = xPos;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * determines if this rectangle intersects the given rectangle
     * @param xPos xPos
     * @param yPos yPos
     * @param width width
     * @param height height
     * @return true if this rectangle intersects the given rectangle
     */
    public boolean intersects(int xPos, int yPos, int width, int height)
    {
        int firstXMin = this.getX();
        int firstXMax = this.getX() + this.getWidth();
        int secondXMin = xPos;
        int secondXMax = xPos + width;
        boolean xIntersect = false;
        
        if (firstXMin < secondXMax && secondXMin < firstXMax)
        {
            xIntersect = true;
        }
        
        int firstYMin = this.getY();
        int firstYMax = this.getY() + this.getHeight();
        int secondYMin = yPos;
        int secondYMax = yPos + height;
        boolean yIntersect = false;
        
        if (firstYMin < secondYMax && secondYMin < firstYMax)
        {
            yIntersect = true;
        }
        
        return xIntersect && yIntersect;
    }
    
    /**
     * Determines whether two rectangle objects intersect
     * @param r1 First rectangle
     * @param r2 Second rectangle
     * @return true if r1 and r2 intersect
     */
    public static boolean intersects(Rectangle r1, Rectangle r2)
    {
        // edit to use non static intersects
        int firstXMin = r1.getX();
        int firstXMax = r1.getX() + r1.getWidth();
        int secondXMin = r2.getX();
        int secondXMax = r2.getX() + r2.getWidth();
        boolean xIntersect = false;
        
        if (firstXMin < secondXMax && secondXMin < firstXMax)
        {
            xIntersect = true;
        }
        
        int firstYMin = r1.getY();
        int firstYMax = r1.getY() + r1.getHeight();
        int secondYMin = r2.getY();
        int secondYMax = r2.getY() + r2.getHeight();
        boolean yIntersect = false;
        
        if (firstYMin < secondYMax && secondYMin < firstYMax)
        {
            yIntersect = true;
        }
        
        return xIntersect && yIntersect;
    }
    
    /**
     * returns values of rectangle in string format
     * @return string representation of rectangle
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(this.getName());
        sb.append(", ");
        sb.append(this.getX());
        sb.append(", ");
        sb.append(this.getY());
        sb.append(", ");
        sb.append(this.getWidth());
        sb.append(", ");
        sb.append(this.getHeight());
        sb.append(")");
        
        return sb.toString();
    }

    @Override
    /**
     * compareTo
     */
    public int compareTo(Rectangle r) {
        return this.getName().compareTo(r.getName());
    }
    
    /**
     * removes any rectangle in bst with name
     * @param bst bst
     * @param name name
     * @return true if removed successfully
     */
    public static boolean remove(BST<Rectangle> bst, String name)
    {
        ArrayList<Rectangle> sameNames = search(bst, bst.getRootNode(), name);
        if (sameNames.size() == 0)
        {
            return false;
        }
        bst.remove(sameNames.get(0));
        return true;
    }
    
    /**
     * removes any rectangle in bst with x, y, w, h
     * @param bst bst
     * @param x x
     * @param y y
     * @param w w
     * @param h h
     * @return true if removed successfully
     */
    public static boolean remove(BST<Rectangle> bst, int x, int y, int w, int h)
    {
        Iterator<Rectangle> iter = new Iterator<Rectangle>(bst.getRootNode());
        while (iter.hasNext())
        {
            BSTNode<Rectangle> currNode = iter.next();
            Rectangle currRectangle = currNode.getElement();
            boolean sameX = (currRectangle.getX() == x);
            boolean sameY = (currRectangle.getY() == y);
            boolean sameW = (currRectangle.getWidth() == w);
            boolean sameH = (currRectangle.getHeight() == h);
            if (sameX && sameY && sameW && sameH)
            {
                bst.remove(currRectangle);
                return true;
            }
        }
        return false;
    }
    
    /**
     * searches
     * @param bst bst   
     * @param node node
     * @param name name
     * @return search result
     */
    public static ArrayList<Rectangle> search(BST<Rectangle> bst, 
        BSTNode<Rectangle> node, String name)
    {
        Iterator<Rectangle> iter = new Iterator<Rectangle>(node);
        ArrayList<Rectangle> ans = new ArrayList<Rectangle>();
        BSTNode<Rectangle> compare = iter.next();
        
        if (compare == null)
        {
            return ans;
        }
        
        if (compare.getElement().getName().equals(name))
        {
            ans.add(compare.getElement());
            while (compare.getRightNode() != null && 
                compare.getRightNode().getElement().getName().equals(name))
            {
                compare = compare.getRightNode();
                ans.add(compare.getElement());
            }
            //iter = bst.getIterator();
            return ans;
        }
        
        if (compare.getElement().getName().compareTo(name) < 0)
        {
            if (compare.getRightNode() == null)
            {
                return ans;
            }
            return search(bst, compare.getRightNode(), name);
        }
        
        if (compare.getLeftNode() == null)
        {
            return ans;
        }
        
        return search(bst, compare.getLeftNode(), name);    
    }
    
    /**
     * searches region
     * @param bst bst
     * @param x x
     * @param y y
     * @param w w
     * @param h h
     * @return region
     */
    public static ArrayList<Rectangle> regionsearch(BST<Rectangle> bst, int x, 
        int y, int w, int h)
    {
        ArrayList<Rectangle> ans = new ArrayList<Rectangle>();
        if (w < 0 && h < 0)
        {
            return ans;
        }
        Iterator<Rectangle> iter = new Iterator<Rectangle>(bst.getRootNode());
        while (iter.hasNext())
        {
            BSTNode<Rectangle> currNode = iter.next();
            Rectangle currRectangle = currNode.getElement();
            if (currRectangle.intersects(x, y, w, h))
            {
                ans.add(currRectangle);
            }
        }
        return ans;
    }
    
    /**
     * intersections
     * @param bst bst
     * @return all pairs
     */
    public static 
        ArrayList<ArrayList<Rectangle>> intersections(BST<Rectangle> bst)
    {
        ArrayList<ArrayList<Rectangle>> allPairs = 
            new ArrayList<ArrayList<Rectangle>>();
        
        //initialize iterator for outer loop
        Iterator<Rectangle> outerIter = 
            new Iterator<Rectangle>(bst.getRootNode());
        int outerNodePos = 0;
        
        // outerIter iterates through all the nodes in bst
        while (outerIter.hasNext())
        {
            //progress iterator for outer loop
            BSTNode<Rectangle> outerNode = outerIter.next();
            Rectangle outerRectangle = outerNode.getElement();
            outerNodePos++;
            
            Iterator<Rectangle> innerIter = 
                new Iterator<Rectangle>(bst.getRootNode());
            
            // bring the innerIter to same position as outerIter
            // to avoid duplicate pairs of rectangles
            for (int i = 0; i < outerNodePos; i++)
            {
                innerIter.next();
            }
            
            // innerIter iterates through all the nodes in 
            //bst following outerIter's currentNode
            while (innerIter.hasNext())
            {
                //progress iterator for inner loop
                BSTNode<Rectangle> innerNode = innerIter.next();
                Rectangle innerRectangle = innerNode.getElement();
                
                if (Rectangle.intersects(outerRectangle, innerRectangle))
                {
                    ArrayList<Rectangle> pair = new ArrayList<Rectangle>();
                    pair.add(outerRectangle);
                    pair.add(innerRectangle);
                    
                    allPairs.add(pair);
                }
            }
        }
        
        return allPairs;
    }
}

