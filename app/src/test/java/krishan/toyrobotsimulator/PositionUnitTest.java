package krishan.toyrobotsimulator;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionUnitTest
{
    @Test
    public void testAssertions()
    {
        Position positionTest1 = new Position(4, 3);
        assertEquals(positionTest1.getPositionX(), 4);
        assertEquals(positionTest1.getPositionY(), 4);

        Position positionTest2 = new Position(2, 5);
        assertEquals(positionTest2.getPositionX(), 3);
        assertEquals(positionTest2.getPositionY(), 5);

        Position positionTest3 = new Position(1, 5);
        assertEquals(positionTest3.getPositionX(), 1);
        assertEquals(positionTest3.getPositionY(), 4);
    }
}
