import java.util.ArrayList;

/**
 * Parser is a class designed to parse command file
 * @author tsingh
 *
 */
public class Parser {
    
    /**
     * fields for parser
     */
    private BST<Rectangle> parseBoy;
    private String input;
    
    /**
     * Constructor for parser
     * @param name name of BST
     * @param terms string commands
     */
    public Parser(BST<Rectangle> name, String terms)
    {
        parseBoy = name;
        input = terms;
    }
    
    /**
     * Method to parse the string
     */
    public void parseString()
    {
        String[] commands = input.trim().split("\\s+");
       
        if (commands.length > 0)
        {
            
            if (commands[0].equals("insert"))
            {
                //Make sure height and width are greater than 0
                Rectangle rec = new Rectangle();
                rec.setName(commands[1]);
                rec.setXpos(Integer.parseInt(commands[2]));
                rec.setY(Integer.parseInt(commands[3]));
                rec.setWidth(Integer.parseInt(commands[4]));
                rec.setHeight(Integer.parseInt(commands[5]));
                boolean heightFits = (rec.getY() + rec.getHeight()) < 1024;
                boolean widthFits = (rec.getX() + rec.getWidth()) < 1024;
                if (rec.getX() >= 0 && rec.getY() >= 0 && rec.getHeight() > 0 && rec.getWidth() > 0 && heightFits && widthFits)
                {
                    
                    parseBoy.insert(rec);
                    System.out.println("Rectangle accepted: (" + rec.getName() + ", " +
                    rec.getX() + ", " + rec.getY() + ", " + rec.getWidth() + ", " + rec.getHeight()+ ")");
                    
                    
                }
                else
                {
                    System.out.println("Rectangle rejected: (" + rec.getName() + ", " + 
                        rec.getX() + ", " + rec.getY() + ", " + rec.getWidth() + ", " + rec.getHeight()+ ")");
                }
            }
            else if (commands[0].equals("search")) {
                ArrayList<Rectangle> ans = Rectangle.search(parseBoy, parseBoy.getRootNode(), commands[1]);
                if (ans.size() > 0)
                {
                    for (int i = 0; i < ans.size(); i++)
                    {
                        System.out.println("Rectangle found: " + ans.get(i));
                    }
                }
                else
                {
                    System.out.println("Rectangle not found: "+ commands[1]);
                }
                
            }
            else if (commands[0].equals("dump"))
            {
                String dump = parseBoy.dump();
                System.out.println(dump);
            }
            else if (commands[0].equals("remove") && commands.length > 4)
            {
                if (!Rectangle.remove(parseBoy, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]),Integer.parseInt(commands[4])))
                {
                    System.out.println("Rectangle rejected (" + Integer.parseInt(commands[1]) + "," + Integer.parseInt(commands[2]) + "," + Integer.parseInt(commands[3]) + "," + 
                        Integer.parseInt(commands[4]) + ")");
                }
 
            }
            else if (commands[0].equals("remove"))
            {
                if (!Rectangle.remove(parseBoy, commands[1]))
                {
                    System.out.println("Rectangle rejected "+ commands[1]);
                }
            }
            else if (commands[0].equals("regionsearch"))
            {
                ArrayList<Rectangle> reg = Rectangle.regionsearch(parseBoy, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]),Integer.parseInt(commands[4]));
                System.out.println("Rectangles intersecting region (" + Integer.parseInt(commands[1]) + "," + Integer.parseInt(commands[2]) + "," + Integer.parseInt(commands[3]) + "," + 
                    Integer.parseInt(commands[4]) + ")");
                for (int i = 0; i < reg.size(); i++)
                {
                    System.out.println(reg.get(i));
                }
            }
            
        }
        
        
    }
    
    

}