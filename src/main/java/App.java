import com.sasanga.businessLogic.PlateauProcessor;
import com.sasanga.businessLogic.RoverMovement;
import com.sasanga.models.PlateauMaxXandY;

public class App {
    public static void main(String[] args) {
        try {
            // process plateau maximum coordinates
            String plateauMaxCordinatesStr = "5 5";
            PlateauMaxXandY plateauMaxXandY = PlateauProcessor.getMaxXandY(plateauMaxCordinatesStr);

            RoverMovement movement = new RoverMovement();

            String roverIInitialPositionStr = "1 2 N";
            String rover1Instructions = "LMLMLMLMM";
            String rover1Output = movement.getPosition(roverIInitialPositionStr, rover1Instructions, plateauMaxXandY);
            System.out.println("Rover 1 output: " + rover1Output);

            String rover2InitialPosition = "3 3 E";
            String rover2Instructions = "MMRMMRMRRM";
            String rover2Output = movement.getPosition(rover2InitialPosition, rover2Instructions, plateauMaxXandY);
            System.out.println("Rover 2 output: " + rover2Output);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
