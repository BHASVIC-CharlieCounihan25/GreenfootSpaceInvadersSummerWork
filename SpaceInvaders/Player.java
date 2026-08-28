import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int Reload = 0;
    public void act()
    {
        Moving(); 
        Shooting();
        Endgame();
    }
    public void Shooting(){
        Reload = Reload + 1; 
        if(Greenfoot.isKeyDown("Space")){
            if(Reload >= 15){
                Bullet newObject = new Bullet();
                getWorld().addObject(new Bullet(), getX(), getY());
                Reload = 0;
            }
        }
    }
    public void Moving(){
        if(Greenfoot.isKeyDown("a")){
            int X = getX();
            setLocation(X-5,getY());
            }
        if(Greenfoot.isKeyDown("d")){
            int X = getX();
            setLocation(X+5,getY());
        }
    }
    public void Endgame(){
        Actor enemybullet = getOneIntersectingObject(EnemyBullet.class);
        if(enemybullet != null){
            setLocation(300, 100);
            getWorld().removeObject(enemybullet); 
        }
    }
}
