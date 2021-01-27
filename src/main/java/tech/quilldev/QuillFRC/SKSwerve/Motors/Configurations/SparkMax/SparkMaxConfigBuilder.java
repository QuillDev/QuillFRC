package tech.quilldev.QuillFRC.SKSwerve.Motors.Configurations.SparkMax;

public class SparkMaxConfigBuilder {

    public double kP = 0;
    public double kI = 0;
    public double kD = 0;
    public double kIz = 0;
    public double kFF = 0;
    double kMaxOutput = 1;
    double kMinOutput = -1;

    /**
     * Set the proportion value of the PID settings
     * @param kP proportion value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkP(double kP) {
        this.kP = kP;
        return this;
    }

    /**
     * Set the integral value of the pid settings
     * @param kI integral value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkI(double kI) {
        this.kI = kI;
        return this;
    }

    /**
     * set the derivative  value of the pid settings
     * @param kD derivative value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkD(double kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Set the forward feeding value of the max
     * @param kFF the ff value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkFF(double kFF) {
        this.kFF = kFF;
        return this;
    }

    /**
     * Set the i zone of the spark max
     * @param kIz i zone value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkIz(double kIz) {
        this.kIz = kIz;
        return this;
    }

    /**
     * Set the max output value of the spark max
     * @param kMaxOutput max output value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkMaxOutput(double kMaxOutput) {
        this.kMaxOutput = kMaxOutput;
        return this;
    }

    /**
     * Set the minOutput of the spark max
     * @param kMinOutput min output value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setkMinOutput(double kMinOutput) {
        this.kMinOutput = kMinOutput;
        return this;
    }

    /**
     * Set the output range of the spark max
     * @param kMinOutput min output value
     * @param kMaxOutput max output value
     * @return the updated config
     */
    public SparkMaxConfigBuilder setOutputRange(double kMinOutput, double kMaxOutput){
        this.kMinOutput = kMinOutput;
        this.kMaxOutput = kMaxOutput;
        return this;
    }

    /**
     * Build the spark max config and return it
     * @return the spark max config
     */
    public SparkMaxConfig build(){
        return new SparkMaxConfig(
                kP,
                kI,
                kD,
                kIz,
                kFF,
                kMaxOutput,
                kMinOutput
        );
    }
}
