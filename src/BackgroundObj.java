import mayflower.*;

public class BackgroundObj extends Actor
{
    MayflowerImage sprite;
    int counter = 0;
    int currentFrame = 0;
    MayflowerImage[] busFrames;
    int img;
    public BackgroundObj(int img)
    {
        this.img = img;
        switch (img)
        {
            case 3:

                sprite = new MayflowerImage("img/backgroundobj/kyle.png");
                sprite.scale(.5);
                break;
            case 2:
                sprite = new MayflowerImage("img/backgroundobj/century-tree.png");
                sprite.scale(.44);
                break;
            case 1:
                busFrames = new MayflowerImage[3];
                busFrames[0] = new MayflowerImage("img/backgroundobj/bas1.png");
                busFrames[1] = new MayflowerImage("img/backgroundobj/baas3.png");
                busFrames[2] = new MayflowerImage("img/backgroundobj/bas2.png");
                for(int i = 0; i < 3; i++)
                {
                    busFrames[i].scale(.92);
                }
                sprite = busFrames[0];
        }
        setImage(sprite);
    }

    @Override
    public void act()
    {
        move();
        delete();
        if(img == 1)
        {
            animate();
        }
    }

    public void move()
    {
        setLocation(getX() - 2, getY());
    }

    public void delete()
    {
        if(getX() < -1000)
        {
            getWorld().removeObject(this);
        }
    }

    public void animate()
    {
        if(counter > 10)
        {
            if(currentFrame >= busFrames.length)
            {
                currentFrame = 0;
            }
            MayflowerImage sprite = busFrames[currentFrame];
            setImage(sprite);
            currentFrame++;
            counter = 0;
        }
        counter++;
    }
}
