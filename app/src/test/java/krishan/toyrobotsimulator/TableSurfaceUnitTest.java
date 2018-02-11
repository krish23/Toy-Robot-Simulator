package krishan.toyrobotsimulator;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableSurfaceUnitTest
{
    @Test
    public void testAssertions()
    {
        TableSurface tableSurface = new TableSurface(5, 5);

        Position positionTest1 = new Position(4,4);
        Direction directionTest1 = new Direction("NORTH");
        Square squareTest1 = new Square(positionTest1, directionTest1);
        assertTrue(tableSurface.checkPositionValidation(squareTest1));

        Position positionTest2 = new Position(1,5);
        Direction directionTest2 = new Direction("EAST");
        Square squareTest2 = new Square(positionTest2, directionTest2);
        assertTrue(tableSurface.checkPositionValidation(squareTest2));

        Position positionTest3 = new Position(6,4);
        Direction directionTest3 = new Direction("SOUTH");
        Square squareTest3 = new Square(positionTest3, directionTest3);
        assertTrue(tableSurface.checkPositionValidation(squareTest3));

        Position positionTest4 = new Position(-1,3);
        Direction directionTest4 = new Direction("WEST");
        Square squareTest4 = new Square(positionTest4, directionTest4);
        assertTrue(tableSurface.checkPositionValidation(squareTest4));

        Position positionTest5 = new Position(6,2);
        Direction directionTest5 = new Direction("EAST");
        Square squareTest5 = new Square(positionTest5, directionTest5);
        assertTrue(tableSurface.checkPositionValidation(squareTest5));

        Position positionTest6 = new Position(-1,6);
        Direction directionTest6 = new Direction("NORTH");
        Square squareTest6 = new Square(positionTest6, directionTest6);
        assertTrue(tableSurface.checkPositionValidation(squareTest6));

    }



}
