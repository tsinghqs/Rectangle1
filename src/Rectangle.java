import java.util.ArrayList;

public class Rectangle implements Comparable<Rectangle> {

    private String name;
    private int x;
    private int y;
    private int w;
    private int h;
    
    /**
     * Constructor for the rectangle class
     * @param name
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Rectangle(String name, int x, int y, int w, int h)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public Rectangle() {
        // TODO Auto-generated constructor stub
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
    public void setXpos(int xPos) {
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
    public int compareTo(Rectangle r) {
        return this.getName().compareTo(r.getName());
    }
    
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
                System.out.println(currRectangle.toString());
                bst.remove(currRectangle);
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<Rectangle> search(BST<Rectangle> bst, BSTNode<Rectangle> node, String name)
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
            while (compare.getRightNode() != null && compare.getRightNode().getElement().getName().equals(name))
            {
                compare = compare.getRightNode();
                ans.add(compare.getElement());
            }
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
}

