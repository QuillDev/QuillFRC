package tech.quilldev.QuillFRC.SKSwerve.SwerveModules;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import tech.quilldev.QuillFRC.SKSwerve.Motors.Configurations.SparkMax.SparkMaxConfig;
import tech.quilldev.QuillFRC.SKSwerve.Motors.SKSparkMax;
import tech.quilldev.QuillFRC.SKSwerve.Motors.SKTalonSRX;

public class SKModuleMaxDriveTalonSteer extends SwerveModule {

    //store the talon srx here
    private final TalonSRX talon;
    private final CANSparkMax spark;

    //store the pid controllers here
    private final CANPIDController drivePidController;

    /**
     * Create a swerve module that's using a talon for steering
     * @param config of the module
     */
    public SKModuleMaxDriveTalonSteer(SwerveModuleConfig config) {
        super(config);

        //set this local talon to the given talon srx
        this.talon = ((SKTalonSRX) config.steerMotor).getTalonSRX();
        this.spark = ((SKSparkMax) config.driveMotor).getSparkMax();
        this.drivePidController = this.spark.getPIDController();

        //set the talons inversion setting
        talon.setSensorPhase(config.steerInverted);
    }

    /**
     * Set the configuration of the talon that's doing the steering
     * @param configuration of the steer config to set
     */
    public void setSteerConfig(TalonSRXConfiguration configuration){
        this.talon.configFactoryDefault();
        this.talon.configAllSettings(configuration);
    }

    /**
     * Set the drive motor configuration to the given configuration
     * @param config of the spark max to set
     */
    public void setDriveConfig(SparkMaxConfig config){
        this.spark.restoreFactoryDefaults();
        this.drivePidController.setP(config.kP);
        this.drivePidController.setI(config.kI);
        this.drivePidController.setP(config.kD);
        this.drivePidController.setIZone(config.kIz);
        this.drivePidController.setFF(config.kFF);
        this.drivePidController.setOutputRange(config.kMinOutput, config.kMaxOutput);
    }

    @Override
    public void setVelocity(double speed) {
        this.drivePidController.setReference(speed, ControlType.kVelocity);
    }

    @Override
    public void setSteerAngle(double angle) {
        this.talon.set(ControlMode.MotionMagic, angle / (2.0 * Math.PI) * 4096);
    }
}
