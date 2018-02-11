package krishan.toyrobotsimulator;


public class Direction
{
    private String direction;

    public Direction(String direction){
        this.direction = direction;
    }

    public String getCurrentDirection(){
        return this.direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }
}
