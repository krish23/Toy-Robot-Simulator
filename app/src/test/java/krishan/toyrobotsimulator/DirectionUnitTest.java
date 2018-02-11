package krishan.toyrobotsimulator;

import org.junit.Test;

import static org.junit.Assert.*;


public class DirectionUnitTest
{
    @Test
    public void testAssertions()
    {
         //Rotation
        // -1 : left
        // +1 : right

        Direction directionTest1 = new Direction("NORTH");
        assertEquals(directionTest1.getCurrentDirection(), determineDirection("EAST", -1));

        Direction directionTest2 = new Direction("EAST");
        assertEquals(directionTest2.getCurrentDirection(), determineDirection("WEST", -1));

        Direction directionTest3 = new Direction("SOUTH");
        assertEquals(directionTest3.getCurrentDirection(), determineDirection("WEST", +1));

        Direction directionTest4 = new Direction("WEST");
        assertEquals(directionTest4.getCurrentDirection(), determineDirection("NORTH", +1));

        Direction directionTest5 = new Direction("WEST");
        assertEquals(directionTest5.getCurrentDirection(), determineDirection("NORTH", -1));

        Direction directionTest6 = new Direction("EAST");
        assertEquals(directionTest6.getCurrentDirection(), determineDirection("NORTH", -1));

        Direction directionTest7 = new Direction("EAST");
        assertEquals(directionTest7.getCurrentDirection(), determineDirection("NORTH", +1));

    }

    public String determineDirection(String direction, int rotation)
    {
        MainActivity.DIRECTIONS DirectionValue = MainActivity.DIRECTIONS.valueOf(direction);
        int currentDirectionValue = DirectionValue.showValues();
        int finalValue = currentDirectionValue + rotation;
        String getDirection = "";

        if(finalValue < 1){
            finalValue = 4;
        }else if(finalValue > 4){
            finalValue = 1;
        }

        for(MainActivity.DIRECTIONS d: MainActivity.DIRECTIONS.values()){
            if(d.value == finalValue){
                getDirection = d.toString();
            }
        }

        return getDirection;
    }
}
