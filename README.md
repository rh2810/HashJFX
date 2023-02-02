# HashJFX
Welcome to HashJFX, a JavaFX application which translates MD5 hash into its respective string 
through the utilization of dictionary files.

## How to Run
**ATTENTION: If running a JAR, please ensure that you are using Java version 19 or greater.
Files can be found in the *JARs* folder under the main repository. Otherwise, for earlier versions of Java and JavaFX, 
you will need to recompile the contents of *src/main* using an earlier JVM.**

**More resources on compiling and running the raw project in IDE:**
  1. [Only Cloning Subdirectories with Git](https://stackoverflow.com/questions/600079/how-do-i-clone-a-subdirectory-only-of-a-git-repository)
  2. [Create a new JavaFX project](https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_welcome_screen)
    <br />a.[Cloning Repositories in IntelliJ](https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_welcome_screen)
  3. [JavaFX with Eclipse](https://www.javatpoint.com/javafx-with-eclipse)
  4. [Working with GUI Applications in VS Code](https://code.visualstudio.com/docs/java/java-gui#:~:text=Create%20a%20new%20JavaFX%20project,command%20Java%3A%20Create%20Java%20Project.)

<br />

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
