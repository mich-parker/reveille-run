import mayflower.*;

public class TitleScreen extends World
{
    Reveille rev;
    boolean moveRight = true;
    MayflowerImage background;
    public TitleScreen()
    {
        background = new MayflowerImage("img/rev-run-title.png");
        background.scale(1024,768);
        setBackground(background);
        rev = new Reveille(550);
        addObject(rev, -200, 550);
    }

    @Override
    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            Mayflower.setWorld(new GameWorld());
        }
        revRun();
    }

    public void revRun()
    {
        if(rev.getX() < 1524 && moveRight)
        {
            rev.setLocation(rev.getX() + 10, rev.getY());
        }
        else
        {
            if (moveRight)
            {
                rev.setFacingRight(false);
                moveRight = false;
            }
            if(rev.getX() > -500 && !moveRight) {
                rev.setLocation(rev.getX() - 10, rev.getY());
            }
            else
            {
                moveRight = true;
                rev.setFacingRight(true);
            }
        }

    }

}
