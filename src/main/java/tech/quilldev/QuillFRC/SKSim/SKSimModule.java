package tech.quilldev.QuillFRC.SKSim;

import tech.quilldev.QuillFRC.SKSwerve.SwerveModules.SwerveModule;
import tech.quilldev.QuillFRC.SKSwerve.SwerveModules.SwerveModuleConfig;

public class SKSimModule extends SwerveModule {

    public SwerveModuleConfig config;
    /**
     * Create a new simulated swerve module
     * @param config of the module we're simulating
     */
    public SKSimModule(SwerveModuleConfig config) {
        super(config);
        this.config = config;
    }

    @Override
    public void setVelocity(double velocity) {
        ( ( SKSimEncoder) this.config.driveEncoder).setVelocity(velocity);
    }

    @Override
    public void setSteerAngle(double angle) {
        ( ( SKSimEncoder) this.config.steerEncoder).setAngle(angle);
    }
}
