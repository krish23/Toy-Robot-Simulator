package krishan.toyrobotsimulator;
import org.junit.Test;

import static org.junit.Assert.*;
public class RobotUnitTest
{
    @Test
    public void testAssertions()
    {
        Position positionTest1 = new Position(4,4);
        Direction directionTest1 = new Direction("NORTH");
        Square squareTest1 = new Square(positionTest1, directionTest1);
        Robot robotTest1 = new Robot(squareTest1);
        assertEquals(robotTest1.getCurrentSquare(), robotTest1);

        Position positionTest2 = new Position(1,5);
        Direction directionTest2 = new Direction("EAST");
        Square squareTest2 = new Square(positionTest2, directionTest2);
        Robot robotTest2 = new Robot(squareTest1);
        assertEquals(robotTest2.getCurrentSquare(), robotTest2);

        Position positionTest3 = new Position(6,4);
        Direction directionTest3 = new Direction("SOUTH");
        Square squareTest3 = new Square(positionTest3, directionTest3);
        Robot robotTest3 = new Robot(squareTest1);
        assertEquals(robotTest3.getCurrentSquare(), robotTest1);

        Position positionTest4 = new Position(-1,3);
        Direction directionTest4 = new Direction("WEST");
        Square squareTest4 = new Square(positionTest4, directionTest4);
        Robot robotTest4 = new Robot(squareTest1);
        assertEquals(robotTest4.getCurrentSquare(), robotTest2);

        Position positionTest5 = new Position(6,2);
        Direction directionTest5 = new Direction("EAST");
        Square squareTest5 = new Square(positionTest5, directionTest5);
        Robot robotTest5 = new Robot(squareTest1);
        assertEquals(robotTest5.getCurrentSquare(), robotTest3);

        Position positionTest6 = new Position(-1,6);
        Direction directionTest6 = new Direction("NORTH");
        Square squareTest6 = new Square(positionTest6, directionTest6);
        Robot robotTest6 = new Robot(squareTest1);
        assertEquals(robotTest6.getCurrentSquare(), robotTest6);
    }
}
