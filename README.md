


Robocode - Template
====
This is a slightly modified version of Norbert Schneider's Robocode Template at: https://github.com/bertschneider/RobocodeTemplate

It contains the Robocode API (version 1.9.2.6) from: http://robocode.sourceforge.net/

This little project can be used as template for your first [Robocode](http://robocode.sourceforge.net/) robots and automated battles.

> Blockquote

For example it should be a good starting point for a tournament in your company...

Development preparations or how to build a new robot
----
1. Download and install the Robocode Jar file from this link: https://sourceforge.net/projects/robocode/files/latest/download?source=files 
2. Run the installation command "java -jar robocode-1.9.3.0-setup.jar" (Change the numbers to your version if needed)
3. Create a destination folder inside your Robocode (The installed folder from step 2)
4. Import the Maven project into an IDE of your choice into destination folder
5. Change the name of the `de.metro.TestRobot` Java and properties file to the name of your robot
6. Set the new classname of your robot in the properties file
7. Implement a superior robot and rule above them all!
8. Build the robot jar with the Maven command `mvn clean install`

You could also set your own artifact name in the POM file - just make sure it is a unique name.

Battle preparations or how to start a war
----

1. Make sure the robots' JAR files are copied into your Robocode robots folder
2. Copy `misc/battles.battle` into your Robocode battles folder
3. Add the classnames of the participating robots to the `selectedRobots` property in the battle file
4. Run the following command in your Robocode folder
   `java -Xmx1024M -cp libs/robocode.jar robocode.Robocode -battle battles/battles.battle -results results.txt`
5. To setup the RoboFight through the UI, you should run the bash file `robocode.sh` and that will fire up a friendly interactive UI 
6. Watch the fight!

Documentation and other links
----

* [Robocode Website](http://robocode.sourceforge.net/)
* [Robocode API](http://robocode.sourceforge.net/docs/robocode/)
* [Robocode Getting Started](http://robowiki.net/wiki/Robocode_Basics)
* [Robocode Wiki](http://robowiki.net/wiki/Main_Page)
* [robocode@github](https://github.com/robo-code/robocode)
* [Rock 'em, sock 'em Robocode!](http://www.ibm.com/developerworks/java/library/j-robocode/index.html)
* [Robocode Lessons](http://mark.random-article.com/weber/java/robocode/)

Dependencies
----
As far as I can tell there are no Maven dependencies available. So the Robocode API was installed in a local repository in the project with the following Maven command:

    mvn install:install-file -Dfile=robocode.jar \
        -Dsources=robocode-1.7.4.4-sources.jar \
        -Djavadoc=robocode-1.7.4.4-javadoc.jar \
        -DgroupId=net.sf.robocode
        -DartifactId=robocode.api \
        -Dversion=1.7.4.4 \
        -Dpackaging=jar \
        -DgeneratePom=true \
        -DcreateChecksum=true \
        -DlocalRepositoryPath=lib

The sources can also be found on Github at [github.com/robo-code/robocode](https://github.com/robo-code/robocode).
