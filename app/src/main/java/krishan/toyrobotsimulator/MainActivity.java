package krishan.toyrobotsimulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button btnPlace;
    Button btnMove;
    Button btnLeft;
    Button btnRight;
    Button btnReport;
    TextView txtViewConsole;
    EditText txtPositionX;
    EditText txtPositionY;
    Spinner spnPositionPlace;
    ArrayList<Square> robotMovements = new ArrayList<>();
    ArrayList<String> commands = new ArrayList<>();
    Square initialPosition;
    Robot toyRobot;
    TableSurface tableSurface;
    String commandResult;

    enum DIRECTIONS {
        NORTH(1), EAST(2), SOUTH(3), WEST(4);
        int value;
        DIRECTIONS(int i) {
            value = i;
        }

        int showValues(){
            return value;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        btnPlace = (Button) findViewById(R.id.btnPlace);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnReport = (Button) findViewById(R.id.btnReport);
        txtViewConsole = (TextView) findViewById(R.id.txtViewConsole);
        txtPositionX = (EditText) findViewById(R.id.txtPlaceX);
        txtPositionY = (EditText) findViewById(R.id.txtPlaceY);
        spnPositionPlace = (Spinner) findViewById(R.id.spnPlacesSelect);
        txtViewConsole.setMovementMethod(new ScrollingMovementMethod());

        btnPlace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //When Place Button pressed we need to make sure whether the input is given
                if(txtPositionX.getText().toString().matches("") || txtPositionY.getText().toString().matches("")){
                    //Either of a text is empty so warn to user
                    Context context = getApplicationContext();
                    CharSequence text = "You need to fill both X and Y inputs";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    int inputX = Integer.parseInt(txtPositionX.getText().toString());
                    int inputY = Integer.parseInt(txtPositionY.getText().toString());
                    String inputDirection = spnPositionPlace.getSelectedItem().toString();
                    String outputString = "PLACE "+inputX+","+inputY+","+inputDirection;
                    commandResult = setCommands(outputString);
                    //Set the output to the app console
                    txtViewConsole.append(commandResult+"\n");
                }
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //When Move Button pressed we need to make sure output MOVE
                if(robotMovements.isEmpty()){
                    showErrorToast();
                }
                else {
                    String outputString = "MOVE";
                    commandResult = setCommands(outputString);
                    //Set the output to the app console
                    txtViewConsole.append(commandResult + "\n");
                }
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(robotMovements.isEmpty()){
                    showErrorToast();
                }
                else {
                    //When Move Button pressed we need to make sure output MOVE
                    String outputString = "LEFT";
                    commandResult = setCommands(outputString);
                    //Set the output to the app console
                    txtViewConsole.append(commandResult + "\n");
                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(robotMovements.isEmpty()){
                    showErrorToast();
                }
                else {
                    //When Move Button pressed we need to make sure output MOVE
                    String outputString = "RIGHT";
                    commandResult = setCommands(outputString);
                    //Set the output to the app console
                    txtViewConsole.append(commandResult + "\n");
                }
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(robotMovements.isEmpty()){
                    showErrorToast();
                }
                else {
                    //When Move Button pressed we need to make sure output MOVE
                    String outputString = "REPORT";
                    commandResult = setCommands(outputString);
                    //Set the output to the app console
                    txtViewConsole.append(outputString + "\n");
                    txtViewConsole.append("Output: " + commandResult + "\n");
                }
            }
        });

        /*
        String returnFromCommand = setCommands("PLACE 1,2,EAST");
        returnFromCommand = setCommands("MOVE");
        returnFromCommand = setCommands("MOVE");
        returnFromCommand = setCommands("LEFT");
        returnFromCommand = setCommands("MOVE");
        returnFromCommand = setCommands("REPORT");
        */
    }

    public void showErrorToast(){
        Context context = getApplicationContext();
        CharSequence text = "First, you need to place the robot for this action";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public String setCommands(String command)
    {
        String[] commandSquence = command.split("\\s+");
        String firstCommand = commandSquence[0];
        if(firstCommand.equals("PLACE"))
        {
            //Placing the robot and read second commands
            tableSurface = new TableSurface(5, 5);
            String secondCommands = commandSquence[1];
            String[] placementCommands = secondCommands.split(",");
            int x = Integer.parseInt(placementCommands[0]);
            int y = Integer.parseInt(placementCommands[1]);
            String direction = placementCommands[2];
            Position newPosition = new Position(x, y);
            Direction newDirection = new Direction(direction);
            initialPosition = new Square(newPosition, newDirection);

            boolean validation = tableSurface.checkPositionValidation(initialPosition);
            if(validation) {
                robotMovements.add(initialPosition);
                toyRobot = new Robot(initialPosition);
            }
            else{
                command = "Invalid position";
            }
            return command;
        }
        else if(firstCommand.equals("MOVE"))
        {
            //Move command

            //Get the last square and make the movement of the robot
            Square lastSquare = robotMovements.get(robotMovements.size() - 1);
            int _x = lastSquare.getCurentPosition().x;
            int _y = lastSquare.getCurentPosition().y;
            String _direction = lastSquare.getCurrentDirection().getCurrentDirection();

            //According to the direction make the movement of the robot
            switch(_direction){
                case "NORTH":
                    _y = _y + 1;
                    break;
                case "SOUTH":
                    _y = _y - 1;
                    break;
                case "EAST":
                    _x = _x + 1;
                    break;
                case "WEST":
                    _x = _x - 1;
                    break;
            }
            Position newRobotPosition = new Position(_x, _y);
            Direction newRobotDirection = new Direction(_direction);
            Square newRobotSquare = new Square(newRobotPosition, newRobotDirection);

            //Check the validation before make the movement
            boolean validation = tableSurface.checkPositionValidation(newRobotSquare);

            if(validation){
                //Valid, so set the command to make robot move
                toyRobot.setNewRobotSquare(newRobotSquare);
                robotMovements.add(newRobotSquare);
            }
            else {
                firstCommand = "Invalid Move";
            }
            return firstCommand;
        }
        else if(firstCommand.equals("LEFT"))
        {
            //Rotate 90 degree Left from current direction

            String getDirection = determineDirection(getLastDirection(), -1);
            updateRobotDirection(getDirection);
            return firstCommand;
        }
        else if(firstCommand.equals("RIGHT"))
        {
            //Rotate 90 degree Right from current direction
            String getDirection = determineDirection(getLastDirection(), 1);
            updateRobotDirection(getDirection);
            return firstCommand;
        }
        else if(firstCommand.equals("REPORT"))
        {
            //Report command
            //Show the output to user
            Square getCurrentSquare = toyRobot.getCurrentSquare();
            int current_x = getCurrentSquare.getCurentPosition().x;
            int current_y = getCurrentSquare.getCurentPosition().y;
            String getCurrentDirection = getCurrentSquare.getCurrentDirection().getCurrentDirection();

            String outputString = Integer.toString(current_x)+","+Integer.toString(current_y)+","+getCurrentDirection;
            return outputString;
        }
        return "Invalid Command";
    }

    public String determineDirection(String direction, int rotation)
    {
        DIRECTIONS DirectionValue = DIRECTIONS.valueOf(direction);
        int currentDirectionValue = DirectionValue.showValues();
        int finalValue = currentDirectionValue + rotation;
        String getDirection = "";

        if(finalValue < 1){
            finalValue = 4;
        }else if(finalValue > 4){
            finalValue = 1;
        }

        for(DIRECTIONS d: DIRECTIONS.values()){
            if(d.value == finalValue){
                getDirection = d.toString();
            }
        }

        return getDirection;
    }

    public void updateRobotDirection(String direction)
    {
        Position newRobotPosition = new Position(getLastPositionX(), getLastPositionY());
        Direction newRobotDirection = new Direction(direction);
        Square newRobotSquare = new Square(newRobotPosition, newRobotDirection);
        toyRobot.setNewRobotSquare(newRobotSquare);
        robotMovements.add(newRobotSquare);
    }

    public String getLastDirection(){
        Square lastSquare = robotMovements.get(robotMovements.size() - 1);
        String _direction = lastSquare.getCurrentDirection().getCurrentDirection();
        return _direction;
    }

    public int getLastPositionX(){
        Square lastSquare = robotMovements.get(robotMovements.size() - 1);
        int _x = lastSquare.getCurentPosition().x;
        return _x;
    }

    public int getLastPositionY(){
        Square lastSquare = robotMovements.get(robotMovements.size() - 1);
        int _y = lastSquare.getCurentPosition().y;
        return _y;
    }

}
