package com.sasanga.businessLogic;

import com.sasanga.models.PlateauMaxXandY;
import com.sasanga.models.RoverPosition;

public class RoverMovement {

    public String getPosition(String initialPositionStr, String instructionsStr, PlateauMaxXandY plateauMaxXandY) throws Exception {

        //Get the instructions array
        char[] instructions = instructionsStr.toUpperCase().toCharArray();

        //get initial position
        RoverPosition position = getInitialPosition(initialPositionStr);

        // process position
        for (char c : instructions) {
            if (c == 'R')
                position.setHeading(turnRight(position.getHeading()));
            else if (c == 'L')
                position.setHeading(turnLeft(position.getHeading()));
            else if (c == 'M')
                move(position);
            else
                throw new Exception("Invalid instruction");
        }

        // return output as a string
        return processOutput(position);
    }

    private char turnRight(char currentHeading) {
        char nextHeading = ' ';
        switch (currentHeading) {
            case 'N':
                nextHeading = 'E';
                break;
            case 'E':
                nextHeading = 'S';
                break;
            case 'S':
                nextHeading = 'W';
                break;
            case 'W':
                nextHeading = 'N';
                break;
            default:
                break;

        }
        return nextHeading;
    }

    private char turnLeft(char currentHeading) {
        char nextHeading = ' ';
        switch (currentHeading) {
            case 'N':
                nextHeading = 'W';
                break;
            case 'W':
                nextHeading = 'S';
                break;
            case 'S':
                nextHeading = 'E';
                break;
            case 'E':
                nextHeading = 'N';
                break;
            default:
                break;
        }
        return nextHeading;
    }

    private void move(RoverPosition position) throws Exception {
        int x = position.getX();
        int y = position.getY();

        switch (position.getHeading()) {
            case 'N':
                position.setY(++y);
                break;
            case 'S':
                position.setY(--y);
                break;
            case 'E':
                position.setX(++x);
                break;
            case 'W':
                position.setX(--x);
                break;
            default:
                break;
        }

        if (x > 5 || y > 5)
            throw new Exception("X or Y coordinates cannot exceed the maximum plateau max X or max Y");

        position.setX(x);
        position.setY(y);
    }

    private RoverPosition getInitialPosition(String initialPositionStr) {
        String[] initialPositionArr = initialPositionStr.split(" ");
        int x = Integer.parseInt(initialPositionArr[0]);
        int y = Integer.parseInt(initialPositionArr[1]);
        char heading = initialPositionArr[2].charAt(0);
        return new RoverPosition(x, y, heading);
    }

    private String processOutput(RoverPosition position) {
        return position.getX() + " " + position.getY() + " " + position.getHeading();
    }
}
