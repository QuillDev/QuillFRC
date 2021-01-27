package tech.quilldev.QuillFRC.SKSwerve.SwerveModules;


import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import tech.quilldev.QuillFRC.SKSwerve.Encoders.SKEncoder;
import tech.quilldev.QuillFRC.SKSwerve.Motors.SKMotorController;

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

    // Module data setters

    /**
     * Velocity of the module to set in metres per second
     * @param velocity velocity in metres per second
     */
    public abstract void setVelocity(double velocity); //set the velocity of the module

    /**
     * Angle of the module to set in radians
     * @param angle of the module to set to
     */
    public abstract void setSteerAngle(double angle); //set the angle of the module

    // Module data getters
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
    /**
     * Get the current state of the swerve module
     * @return the current state of the module
     */
    public SwerveModuleState getState(){
        return new SwerveModuleState(getVelocity(), new Rotation2d(getSteerAngleRadians()));
    }
}
