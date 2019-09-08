import mayflower.*;
public class Obstacle extends Actor
{
    private boolean rolling;
    private MayflowerImage sprite;
    int img;
    MayflowerImage[] plantFrames;
    int currentFrame = 0;
    int counter = 0;
    public Obstacle(int img)
    {
        this.img = img;
        switch (img)
        {
            case 1:
                //ring
                sprite = new MayflowerImage("img/obstacles/ring.png");
                sprite.scale(65,65);
                rolling = true;
                break;
            case 2:
                //football
                sprite = new MayflowerImage("img/obstacles/football.png");
                sprite.scale(75,90);
                rolling = true;
                break;
            case 3:
                plantFrames = new MayflowerImage[4];
                plantFrames[0] = new MayflowerImage("img/obstacles/henry/plant1.png");
                plantFrames[1] = new MayflowerImage("img/obstacles/henry/plant2.png");
                plantFrames[2] = new MayflowerImage("img/obstacles/henry/plant3.png");
                plantFrames[3] = new MayflowerImage("img/obstacles/henry/plant4.png");
                sprite = new MayflowerImage("img/obstacles/henry/plant1.png");
                sprite.scale(.25);
                for(int i = 0; i < 4; i++)
                {
                    plantFrames[i].scale(.25);
                }
                break;
        }
        setImage(sprite);

    }

    @Override
    public void act()
    {
        move();
        delete();
        if(img == 3)
            animate();
    }

    public void move()
    {
        setLocation(getX() - 10, getY());
        if(rolling)
            setRotation(getRotation() - 5);
    }

    public void delete()
    {
        if(getX() < -100)
        {
            getWorld().removeObject(this);
        }
    }

    public void animate()
    {
        if(counter > 5)
        {
            if(currentFrame >= plantFrames.length)
            {
                currentFrame = 0;
            }
            MayflowerImage sprite = plantFrames[currentFrame];
            setImage(sprite);
            currentFrame++;
            counter = 0;
        }
        counter++;
    }
}
