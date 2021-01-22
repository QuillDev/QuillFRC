package tech.quilldev.SKSwerve.SwerveModules;


import tech.quilldev.SKSwerve.Encoders.SKEncoder;
import tech.quilldev.SKSwerve.Motors.SKMotorController;

public abstract class SwerveModule {

    private static int modulesCreated = 0;

    protected final SKMotorController driveMotor;
    protected final SKMotorController steerMotor;

    protected final SKEncoder driveEncoder;
    protected final SKEncoder steerEncoder;

    protected String name;

    public SwerveModule(SwerveModuleConfig config)
    {
        modulesCreated++; //increment the amount of modules created

        // Set motors and encoders
        this.steerMotor = config.steerMotor;
        this.driveMotor = config.driveMotor;
        this.steerEncoder = config.steerEncoder;
        this.driveEncoder = config.driveEncoder;

        //set motors inversion state
        this.driveMotor.setInverted(config.driveInverted);
        this.steerMotor.setInverted(config.steerInverted);

        //set the name depending on whether we specified one
        this.name = config.name.length() == 0 ? "Module #" + modulesCreated : config.name;
    }

    public abstract void setPosition(double angle, double velocity);

    /**
     * Get the steer encoder angle in degrees
     * @return the steer encoder angle in degrees
     */
    public double getSteerAngleDegrees(){
        return this.steerEncoder.getAngleDegrees();
    }

    /**
     * Get the steer encoder angle in radians
     * @return the angle in radians
     */
    public double getSteerAngleRadians(){
        return this.steerEncoder.getAngleRadians();
    }

    /**
     * Get the velocity of the module in metres per second
     * @return the velocity in metres per second
     */
    public double getVelocity(){
        return this.driveEncoder.getVelocity();
    }
}
