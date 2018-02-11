package krishan.toyrobotsimulator;

public class Square
{
    private Position position;
    private Direction direction;

    public Square(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public Position getCurentPosition()
    {
        return this.position;
    }

    public Direction getCurrentDirection(){
        return this.direction;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

}
