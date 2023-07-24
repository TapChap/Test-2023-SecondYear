package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.*;

public class Arm extends SubsystemBase {

    public void toggleGamePieceSetting() {}

    public boolean hasGamePiece() {return false;}

    public boolean isClosed() {return false;}

    public Command collectGamePiece() {return new InstantCommand(()-> {});}

    public Command raiseGamePiece(int height){ return new InstantCommand(()-> {});}

    public Command placeGamePiece(){ return new InstantCommand(()-> {});}

    public Command ejectGamePiece(){ return new InstantCommand(()-> {});}
}