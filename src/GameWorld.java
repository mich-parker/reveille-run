import mayflower.*;
public class GameWorld extends World
{
    Floor floor;
    Reveille player;
    Obstacle object;
    BackgroundObj background;
    Cloud cloud;
    MayflowerMusic music;
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    int count = 1;
    int countFloor = 1;
    public GameWorld()
    {
        setPaintOrder(Floor.class, Cloud.class, BackgroundObj.class, Obstacle.class, Reveille.class, Label.class);
        setBackground("img/sky.png");

        music = new MayflowerMusic("sounds/warhymn.wav");
        music.playLoop();

        floor = new Floor(1);
        addObject(floor, 0, 566);
        player = new Reveille(475);
        addObject(player, -200, 300);
        //Mayflower.showBounds(true);

        spawnFloor();
    }
    @Override
    public void act()
    {
        initAct();
        int num = getSeparation();
        if(counter1 > num)
        {
            spawnObstacles();
            counter1 = 0;
        }
        counter1++;

        if(counter2 > 1000)
        {
            spawnBackGroundObj();
            counter2 = 0;
        }
        counter2++;

        if(counter3 > 200)
        {
            spawnClouds();
            counter3 = 0;
        }
        counter3++;

        if(counter4 > 166)
        {
            spawnFloor();
            counter4 = 0;
        }
        counter4++;
    }

    public void spawnObstacles()
    {
        double img = Math.random()*3+1;
        object = new Obstacle((int)img);
        addObject(object, 1024, 525);
    }

    public int getSeparation()
    {
        int num = (int)(Math.random()*200)+1;
        return num + 50;
    }

    public void spawnBackGroundObj()
    {
        background = new BackgroundObj((count));
        addObject(background, 1024, 252);
        count++;
        if(count > 3)
            count = 1;
    }

    public void spawnClouds()
    {
        double img = Math.random()*7+1;
        cloud = new Cloud((int)img);
        double offset = Math.random()*500+1;
        addObject(cloud, 1024, (int)offset-100);
    }

    public void spawnFloor()
    {
        floor = new Floor((countFloor));
        addObject(floor, 1670, 566);
        countFloor++;
        if(countFloor > 2)
            countFloor = 1;
    }

    public void initAct()
    {
        if(player.getX() <= 200)
        {
            player.setLocation(player.getX() + 10, player.getY());
        }
    }

}
