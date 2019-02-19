
public class Rectangle implements Comparable<Rectangle> {

    private String name;
    private int xpos;
    private int ypos;
    private int width;
    private int length;
    
    /**
     * Constructor for the rectangle class
     * @param name
     * @param xpos
     * @param ypos
     * @param width
     * @param length
     */
    public Rectangle(String name, int xpos, int ypos, int width, int length)
    {
        this.name = name;
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.length = length;
    }
    
    public Rectangle() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
        //return length
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the ypos
     */
    public int getYpos() {
        return ypos;
    }

    /**
     * @param ypos the ypos to set
     */
    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    /**
     * @return the xpos
     */
    public int getXpos() {
        return xpos;
    }

    /**
     * @param xpos the xpos to set
     */
    public void setXpos(int xpos) {
        this.xpos = xpos;
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
        return name;
    }

    @Override
    public int compareTo(Rectangle r) {
        return this.toString().compareTo(r.toString());
    }
    
    
}

