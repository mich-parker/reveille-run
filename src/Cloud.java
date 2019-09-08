import mayflower.*;
public class Cloud extends Actor
{
    MayflowerImage sprite;

    public Cloud(int img)
    {
        double rotate = Math.random()*50-25;
        switch (img)
        {
            case 1:
                sprite = new MayflowerImage("img/clouds/cloud1.png");
                break;
            case 2:
                sprite = new MayflowerImage("img/clouds/cloud2.png");
                break;
            case 3:
                sprite = new MayflowerImage("img/clouds/cloud3.png");
                break;
            case 4:
                sprite = new MayflowerImage("img/clouds/cloud4.png");
                break;
            case 5:
                sprite = new MayflowerImage("img/clouds/cloud5.png");
                break;
            case 6:
                sprite = new MayflowerImage("img/clouds/cloud6.png");
                break;
            case 7:
                sprite = new MayflowerImage("img/clouds/cloud7.png");
                break;
        }
        sprite.scale(.25);
        setImage(sprite);
        if(img == 6 || img == 7)
        {
            setRotation(getRotation()+(int)rotate);
        }
    }

    @Override
    public void act()
    {
        setLocation(getX() - 1, getY());
    }

    public void delete()
    {
        if(getX() < -500)
        {
            getWorld().removeObject(this);
        }
    }
}
