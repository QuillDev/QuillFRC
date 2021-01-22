package tech.quilldev.QuillFRC.SKSim;

import tech.quilldev.QuillFRC.SKSwerve.Encoders.SKEncoder;
import tech.quilldev.QuillFRC.SKSwerve.Motors.SKMotorController;

public class SKSimMotor extends SKMotorController {

    public double speed = 0;
    public boolean inverted = false;
    public int port;

    public SKSimMotor(int port){
        this.port = port;
    }
    @Override
    public void set(double speed) {
        this.speed = speed;
    }

    @Override
    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    @Override
    public SKEncoder getInternalEncoder() {
        return null;
    }
}
