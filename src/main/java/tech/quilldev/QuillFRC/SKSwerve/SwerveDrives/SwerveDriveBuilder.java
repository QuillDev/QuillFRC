package tech.quilldev.QuillFRC.SKSwerve.SwerveDrives;

import tech.quilldev.QuillFRC.SKSwerve.SwerveModules.SwerveModule;

import java.util.ArrayList;
import java.util.Arrays;

public class SwerveDriveBuilder {

    public ArrayList<SwerveModule> modules = new ArrayList<>();
    public double trackWidth = 0;
    public double wheelBase = 0;

    /**
     * Set the track width of the chassis
     * @param trackWidth of the chassis
     * @return an updated config
     */
    public SwerveDriveBuilder setTrackWidth(double trackWidth){
        this.trackWidth = trackWidth;
        return this;
    }

    /**
     * Set the length of the chassis
     * @param wheelBase of the module
     * @return an updated config
     */
    public SwerveDriveBuilder setWheelBase(double wheelBase){
        this.wheelBase = wheelBase;
        return this;
    }

    /**
     * Set the swerve drive dimensions
     * @param length of the chassis
     * @param width of the chassis
     * @return an updated config
     */
    public SwerveDriveBuilder setDimensions(double length, double width){
        this.wheelBase = length;
        this.trackWidth = width;
        return this;
    }

    /**
     * Add a list of modules to the drive
     * @param modules to add
     * @return an updated config
     */
    public SwerveDriveBuilder addModules(SwerveModule... modules){
        this.modules.addAll(Arrays.asList(modules));
        return this;
    }

    /**
     * Add an arraylist of modules to the drive
     * @param modules to add
     * @return an updated config
     */
    public SwerveDriveBuilder addModules(ArrayList<SwerveModule> modules){
        this.modules.addAll(modules);
        return this;
    }

    /**
     * Add a single module to the drive
     * @param module to add
     * @return an updated config
     */
    public SwerveDriveBuilder addModule(SwerveModule module){
        this.modules.add(module);
        return this;
    }

    /**
     * Build and return a new swerve drive
     * @return the swerve drive
     * @throws Exception errors with configuration
     */
    public SwerveDrive build() throws Exception{

        // We don't support module counts under 3
        if(modules.size() < 3){
            throw new Exception("A swerve drive must have at least 3 modules");
        }
        else if(trackWidth <= 0){
            throw new Exception("Invalid track width, make sure you set it!");
        }
        else if(wheelBase <= 0){
            throw new Exception("Invalid track width, make sure you set it!");
        }

        return new SwerveDrive(trackWidth, wheelBase, modules);
    }
}
