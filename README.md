# HashJFX
Welcome to HashJFX, a JavaFX application which translates MD5 hash into its respective string 
through the utilization of dictionary files.

## How to Run
**If running a JAR, please ensure that you are using Java version 19 or greater.
Files can be found in the *JARs* folder under the main repository. Otherwise, for earlier versions of Java and JavaFX, 
you will need to recompile the contents of *src/main* using an earlier JVM.**

![HashJFX_JARs](https://user-images.githubusercontent.com/25485988/216125684-ac285a2a-54d2-4ef5-8e9e-87e36253a096.PNG)

### Windows
To run HashJFX on Windows, download the .zip file from the project's main repository. Next,
navigate to the **JARs** folder and double-click the **HashJFX_Win.jar** or run it from terminal:
```sh
java -jar .\HashJFX_Win.jar
```

### Linux
Similarly for Linux, download the .zip file from the project's main repository and run the **HashJFX_Linux.jar** from the **JARs** folder.
```sh
java -jar HashJFX_Linux.jar
```

## How to Use

![HashJFX_Application](https://user-images.githubusercontent.com/25485988/216125710-5cbff461-7a07-4985-846a-fc6b317ce479.PNG)

Upload a file by selecting **File > Upload text file...** from the top left corner. Once a file has been uploaded,
enter an MD5 hash into the input field and then click the submit button. If your hash is a valid entry, the output field
should display the given string!
