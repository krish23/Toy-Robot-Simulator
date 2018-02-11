package krishan.toyrobotsimulator;

public class Robot
{
    private Square square;

    public Robot(Square square){
        this.square = square;
    }

    public void setNewRobotSquare(Square square){
        this.square = square;
    }

    public Square getCurrentSquare(){
        return this.square;
    }


}
