package tech.quilldev.QuillFRC.SKSwerve.Motors.Configurations.SparkMax;

public class SparkMaxConfig {
    public double kP;
    public double kI;
    public double kD;
    public double kIz;
    public double kFF;
    public double kMaxOutput;
    public double kMinOutput;

    public SparkMaxConfig(
            double kP,
            double kI,
            double kD,
            double kIz,
            double kFF,
            double kMaxOutput,
            double kMinOutput
    )
    {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kIz = kIz;
        this.kFF = kFF;
        this.kMaxOutput = kMaxOutput;
        this.kMinOutput = kMinOutput;
    }
}
