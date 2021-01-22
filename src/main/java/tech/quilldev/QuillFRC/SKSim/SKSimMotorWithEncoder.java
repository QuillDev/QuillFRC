package tech.quilldev.SKSim;


import tech.quilldev.SKSwerve.Encoders.SKEncoder;

public class SKSimMotorWithEncoder extends SKSimMotor{

    private final SKEncoder encoder = new SKSimEncoder();

    public SKSimMotorWithEncoder(int port) {
        super(port);
    }

    @Override
    public SKEncoder getInternalEncoder(){
        return this.encoder;
    }
}
