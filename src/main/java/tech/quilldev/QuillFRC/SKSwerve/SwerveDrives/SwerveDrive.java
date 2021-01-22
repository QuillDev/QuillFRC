package tech.quilldev.QuillFRC.SKSwerve.SwerveDrives;

import tech.quilldev.QuillFRC.SKSwerve.SwerveModules.SwerveModule;

import java.util.ArrayList;

public class SwerveDrive {

    private final ArrayList<SwerveModule> modules;
    private final double width;
    private final double length;

    public SwerveDrive(double width, double length, ArrayList<SwerveModule> modules){
        this.width = width;
        this.length = length;
        this.modules = modules;
    }
}
