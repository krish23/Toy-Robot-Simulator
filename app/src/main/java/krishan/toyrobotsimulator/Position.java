package krishan.toyrobotsimulator;


public class Position
{
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getPositionX(){
        return this.x;
    }

    public int getPositionY(){
        return this.y;
    }
}
