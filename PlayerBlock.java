import javafx.scene.paint.Color;
/**
 * Write a description of class PlayerBlock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerBlock
{
    private int x,y;
    private int max;
    private Color color;
    /**
     * Constructor for objects of class PlayerBlock
     */
    public PlayerBlock(int x, int y, int m, Color c)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        max = m;
        color = c;
    }

    public boolean move(int direction, int distance){
        switch(direction%4){
            case 0://left
            if(-distance + x < 0){return false;}
            else{x -= distance;}
            break;
            case 1://up
            if(-distance + y < 0){return false;}
            else{y -= distance;}
            break;
            case 2://right
            if(distance + x >= max){return false;}
            else{x += distance;}
            break;
            case 3://down
            if(distance + y >= max){return false;}
            else{y += distance;}
            break;
        }
        return true;
    }
    
    int getX(){return x;}
    int getY(){return y;}
    Color getColor(){return color;}
    
}
