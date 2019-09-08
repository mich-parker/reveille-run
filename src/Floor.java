import mayflower.*;

public class Floor extends Actor
{
    MayflowerImage[] frame;
    int counter = 0;
    int currentFrame = 0;
    public Floor(int img)
    {
        img--;
        frame = new MayflowerImage[2];
        frame[0] = new MayflowerImage("img/grass.png");
        frame[1] = new MayflowerImage("img/grass2.png");
        setImage(frame[img]);
    }
    @Override
    public void act()
    {
        setLocation(getX() - 10, getY());
        delete();
    }

    public void delete()
    {
        if(getX() < -2000)
        {
            getWorld().removeObject(this);
        }
    }
}
