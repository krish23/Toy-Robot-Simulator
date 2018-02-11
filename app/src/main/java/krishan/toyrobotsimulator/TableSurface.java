package krishan.toyrobotsimulator;

public class TableSurface
{
    int row;
    int column;

    public TableSurface(int row, int column){
        this.row = row;
        this.column = column;
    }

    public boolean checkPositionValidation(Square square){

        if((square.getCurentPosition().x <= this.row &&
                square.getCurentPosition().y <= this.row) && (square.getCurentPosition().x >= 0 && square.getCurentPosition().y >= 0)){

                return true;
        }

        return false;
    }

}
