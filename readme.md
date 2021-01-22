# QuillFRC Library
This is a library containing various FRC related gizmos and gadgets 
that might help you on your robot building adventures!
## How do I install it?
### QuillFRC Depends on the following libraries
Make sure these dependencies are installed to make sure QuillFRC can run!
* [WPILib](https://github.com/wpilibsuite/allwpilib)
* [RevRobotics (SparkMAX Libs)](https://docs.revrobotics.com/sparkmax/software-resources/spark-max-api-information#java-api)
* [CTRE Phoenix](https://docs.ctre-phoenix.com/en/latest/ch05a_CppJava.html)
### Maven: Add as a dependency
Maven will automatically install dependencies if they're not installed.
```xml
<dependency>
  <groupId>tech.quilldev</groupId>
  <artifactId>quillfrc</artifactId>
  <version>VERSION GOES HERE!</version>
</dependency> 
```
### Gradle: add as dependency
You MUST preinstall dependencies if using gradle!
```groovy
    repositories {
        maven {url = "https://jitpack.io"}
    }
    
    // master-snapshot uses the latest source, you can also use github
    // release tags
    dependencies {
        compile 'com.github.quilldev:QuillFRC:master-SNAPSHOT'
    }
```