import mayflower.*;

import java.awt.*;
import java.awt.Shape.*;
public class Reveille extends Actor
{
    boolean isJumping;
    boolean isFalling;
    boolean facingRight;
    int jumpHeight;
    MayflowerImage[] runFrames;
    MayflowerImage[] rightFrames;
    MayflowerImage[] leftFrames;
    int counter;
    int currentFrame;
    int floorHeight;

    public Reveille(int floorLvl)
    {
        MayflowerImage sprite = new MayflowerImage("img/rev/rev-improved.png");
        sprite.scale(.25);
        setImage(sprite);
        setBounds(new Rectangle(10,0,145,100));
        floorHeight = floorLvl;
        isJumping = false;
        isFalling = true;
        facingRight = true;
        rightFrames = new MayflowerImage[4];
        rightFrames[0] = new MayflowerImage("img/rev/rev-run1.png");
        rightFrames[1] = new MayflowerImage("img/rev/rev-run4.png");
        rightFrames[2] = new MayflowerImage("img/rev/rev-run5.png");
        rightFrames[3] = new MayflowerImage("img/rev/rev-run6.png");
        for (int i = 0; i < 4; i++)
        {
            rightFrames[i].scale(.25);
        }
        leftFrames = new MayflowerImage[4];
        leftFrames[0] = new MayflowerImage("img/rev/rev-run1.png");
        leftFrames[1] = new MayflowerImage("img/rev/rev-run4.png");
        leftFrames[2] = new MayflowerImage("img/rev/rev-run5.png");
        leftFrames[3] = new MayflowerImage("img/rev/rev-run6.png");
        for(int i = 0; i < 4; i++)
        {
            leftFrames[i].scale(.25);
            leftFrames[i].mirrorHorizontally();
        }
        currentFrame = 0;

    }

    @Override
    public void act()
    {
        checkDir();
        animate();
        gravity();
        checkFloor();
        ifJump();
        checkObstacle();
        if(isJumping)
            jump();
    }

    public void gravity()
    {
        if(isFalling && !isJumping)
        {
            setLocation(getX(), getY() + 10);
        }
        if(getY() < floorHeight)
        {
            isFalling = true;
        }
    }

    public void checkFloor()
    {
        if(getY() > floorHeight)
        {
            isFalling = false;
            setLocation(getX(), getY() - 10);
        }
    }

    public void ifJump()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE) && !isJumping && !isFalling)
        {
            isJumping = true;
            jumpHeight = getY() - 200;
        }
    }

    public void jump()
    {
        int x = getX();
        int y = getY();

        if (y >= jumpHeight)
        {
            if (collide())
            {
                isFalling = true;
            }
            setLocation(x, y - 10);
            isFalling = false;
        }
        else
        {
            isJumping = false;
            isFalling = true;
        }
    }

    public boolean collide()
    {
        if(isJumping && getY() < floorHeight)
        {
            setLocation(getX(), getY() + 10);
            return true;
        }
        return false;
    }

    public void checkObstacle()
    {
        if (isTouching(Obstacle.class))
        {
            Mayflower.setWorld(new TitleScreen());
        }
    }

    public void animate()
    {
        if(counter > 5)
        {
            if(currentFrame >= runFrames.length)
            {
                currentFrame = 0;
            }
            MayflowerImage sprite = runFrames[currentFrame];
            setImage(sprite);
            setBounds(new Rectangle(10,0,145,100));
            currentFrame++;
            counter = 0;
        }
        counter++;
    }

    public void setFacingRight(boolean facing)
    {
        facingRight = facing;
    }

    public void checkDir()
    {
        if(facingRight)
        {
            runFrames = rightFrames;
        }
        else
        {
            runFrames = leftFrames;
        }
    }
}
