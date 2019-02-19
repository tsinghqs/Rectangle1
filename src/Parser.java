
public class Parser {
    
    private BST<Rectangle> parseBoy;
    private String input;
    
    public Parser(BST<Rectangle> name, String terms)
    {
        parseBoy = name;
        input = terms;
    }
    
    public void parseString()
    {
        String[] commands = input.split(" ");
        if (commands[0].equals("insert"))
        {
            Rectangle rec = new Rectangle();
            rec.setName(commands[1]);
            System.out.println(commands[1]);
            rec.setXpos(Integer.parseInt(commands[2]));
            System.out.println(commands[2]);
            rec.setYpos(Integer.parseInt(commands[3]));
            System.out.println(commands[3]);
            rec.setWidth(Integer.parseInt(commands[4]));
            System.out.println(commands[4]);
            rec.setLength(Integer.parseInt(commands[5]));
            System.out.println(commands[5]);
            parseBoy.insert(rec);

        }
    }
    
    

}