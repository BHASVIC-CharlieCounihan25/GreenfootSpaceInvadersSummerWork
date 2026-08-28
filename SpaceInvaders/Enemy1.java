import greenfoot.*;  

public class Enemy1 extends Actor
{
    int counter = 25;
    int reverse = -25;
    int swap = 0;
    public void act()
    {
        if(swap == 0){
            move(counter/5);
            counter = counter + 1;
            reverse = reverse - 1;
        }
        if(swap == 1){
            move(reverse/5); 
            counter = counter + 1;
            reverse = reverse - 1;
        }
        if(getX() >= 580){
            swap = 1; 
            setLocation(getX(), getY()+20);
        }
        if(getX() <= 20){
            swap =0; 
            setLocation(getX(), getY()+20);
        }
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            getWorld().removeObject(bullet); 
            setLocation(400, 50);
            counter = counter - 10;
            reverse = reverse + 10;
        }
        if(counter == 100){
            EnemyBullet newObject = new EnemyBullet();
                getWorld().addObject(new EnemyBullet(), getX(), getY());
            counter = counter - 50;
        }
        if(reverse == -100){
            EnemyBullet newObject = new EnemyBullet();
                getWorld().addObject(new EnemyBullet(), getX(), getY());
            reverse = reverse + 50;
        }
    }
}
