
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
    
    //public boolean remove(BST<Rectangle> bst, String name)
    //{
      //  ArrayList<Rectangle> sameNames = search(rootNode, name);
        //if (sameNames.size() == 0)
        //{
          //  return false;
        //}
        //remove((T)sameNames.get(0));
        //return true;
    //}
    
    public boolean remove(BST<Rectangle> bst, int x, int y, int w, int h)
    {
        Iterator<Rectangle> iter = new Iterator<Rectangle>(bst.getRootNode());
        while (iter.hasNext())
        {
            BSTNode<Rectangle> currNode = (BSTNode<Rectangle>) iter.next();
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
}

