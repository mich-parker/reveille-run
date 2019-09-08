import mayflower.*;
import java.util.List;

public class Runner extends Mayflower
{
    public Runner()
    {
        super("Reveille Run", 1024, 768);
    }

    @Override
    public void init()
    {
        Mayflower.setFullScreen(false);
        World titleScreen = new TitleScreen();
        Mayflower.setWorld(titleScreen);
    }

    public static void main(String[] args)
    {
        new Runner();
    }
}
