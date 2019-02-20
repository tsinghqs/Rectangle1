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
     * @param name
     * @param terms
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
            
            System.out.println(commands[0]);
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
                    System.out.println("Rectangle accepted:(" + rec.getName() + ", " +
                    rec.getX() + ", " + rec.getY() + ", " + rec.getWidth() + ", " + rec.getHeight()+ ")");
                    
                    
                }
                else
                {
                    System.out.println("REJECTED");
                }
            }
            else if (commands[0].equals("search")) {
                ArrayList<Rectangle> ans = Rectangle.search(parseBoy, parseBoy.getRootNode(), commands[1]);
                for (int i = 0; i < ans.size(); i++)
                {
                    System.out.println(ans);
                }
            }
            else if (commands[0].equals("dump"))
            {
                String dump = parseBoy.dump();
                System.out.println(dump);
            }
            else if (commands[0].equals("remove") && commands.length > 4)
            {
                Rectangle.remove(parseBoy, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]),Integer.parseInt(commands[4]));
 
            }
            /**else if (commands[0].equals("remove"))
            {
                parseBoy.remove(commands[1]);
            }**/
            
        }
        
        
    }
    
    

}