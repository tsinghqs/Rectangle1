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
        for (int i = 0; i < commands.length; i++)
        {
            System.out.println(commands[i]);
        }
        
        if (commands.length > 0)
        {
            
            System.out.println(commands[0]);
            if (commands[0].equals("insert"))
            {
                Rectangle rec = new Rectangle();
                rec.setName(commands[1]);
                System.out.println(commands[1]);
                System.out.println(commands[2]);
                rec.setXpos(Integer.parseInt(commands[2]));
                rec.setY(Integer.parseInt(commands[3]));
                System.out.println(commands[3]);
                rec.setWidth(Integer.parseInt(commands[4]));
                System.out.println(commands[4]);
                rec.setHeight(Integer.parseInt(commands[5]));
                System.out.println(commands[5]);
                parseBoy.insert(rec);
                System.out.println("Rectangle accepted:(" + rec.getName() + ", " +
                rec.getX() + ", " + rec.getY() + ", " + rec.getWidth() + ", " + rec.getHeight()+ ")");

            }
            else if (commands[0].equals("dump"))
            {
                String dump = parseBoy.dump();
                System.out.println("BST Dump:");
                System.out.println(dump);
            }
            
        }
        
        
    }
    
    

}