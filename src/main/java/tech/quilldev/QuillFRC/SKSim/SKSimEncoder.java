package tech.quilldev.QuillFRC.SKSim;


import tech.quilldev.QuillFRC.SKSwerve.Encoders.SKEncoder;

public class SKSimEncoder extends SKEncoder {

    public double position = 0;
    public double encoderUnits = 4096;
    public double velocity = 0;

    /**
     * Create a new simulated encoder
     */
    public SKSimEncoder(){
        super();
    }

    @Override
    public double getAngleDegrees() {
        return getPositionEncoderUnits() / encoderUnits % 360;
    }

    @Override
    public double getAngleRadians() {
        return getPositionEncoderUnits() / encoderUnits % (2.0 * Math.PI);
    }

    @Override
    public double getVelocity() {
        return 0;
    }

    @Override
    public double getPositionEncoderUnits() {
        return position;
    }

    /**
     * Set the position of the encoder
     * @param angle of the encoder
     */
    public void setAngle(double angle) {
        this.position = angle / (2.0 * Math.PI) * encoderUnits;
    }

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }
}
