import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
public class Text extends Actor
{
    public int Started = 0; 
    public int Score = 0; 
    public int HighScore = 0;
    public Text(String writ){
       GreenfootImage img = new GreenfootImage(writ.length()*30, 30);
       img.setColor(Color.WHITE);
       img.drawString(writ, 2, 20);
       setImage(img);   
    }
    public void act()
    {
        GameStart();
        Ending();
    }
    public void SetWriting(String writ){
        GreenfootImage img = getImage();
        img.clear(); 
        img.drawString(writ,2,20);
    }
    public void GameStart(){    
        if(Started == 0){
            if(Greenfoot.isKeyDown("Space")){                
                Player player = new Player();
                getWorld().addObject(player,296,565);
                Enemy1 enemy1 = new Enemy1();
                getWorld().addObject(enemy1, 400, 50); 
                Enemy2 enemy2 = new Enemy2();
                getWorld().addObject(enemy2, 300, 50);
                Enemy3 enemy3 = new Enemy3();
                getWorld().addObject(enemy3, 200, 50);
                setLocation(300, 100);
                Started = 1;
            }
        }
        if(Started == 1){
            Score = Score + 1; 
        }
        
    }
    public void Ending(){
        Actor player = getOneIntersectingObject(Player.class); 
        if(player != null){
            getWorld().removeObject(player); 
            getWorld().removeObjects(getWorld().getObjects(Enemy1.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy2.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy3.class));
            
            setLocation(700, 100);
            Started = 0; 
            if(HighScore < Score){
                HighScore = Score;
            }
            Score = 0; 
            SetWriting("Press space to begin. High score =" +HighScore);
        }
    }
}
