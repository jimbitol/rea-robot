Toy Robot Simulator
===================

About the solution:

- The solution reads commands inputs from a file
- The commands file path should be passed as an argument
- Will print all report commands on sysout
- You can find command files examples in src/test/resources
- The solutions requires maven and java

Execution steps:

- Download the code (or git clone from https://github.com/jimbitol/rea-robot.git)
- Get in repository folder => cd rea-robot-solution (or if cloned => cd rea-robot)
   - Inside repository folder you will find a "testInputs" folder which contains commands txt files for testing
- Get in project => cd rea-challenge
- Once inside the project use  => mvn package
- It will generate a "rea-challenge.jar" inside target folder
- Execute jar passing the "inputs file path" argument:
    java -jar target/rea-challenge.jar "/path/to/file_with_commands.txt"
