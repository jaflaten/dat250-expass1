# DAT250 Expass 1 hand in for Jørn-Are Flaten

I have set up an developer environment on my Windows 10 Desktop running a AMD Ryzen 64-bit processor. (intending to change to a Macbook Pro in early september and set up the environment there as well)

The environment contains the following

- Java 11
- Maven 3.6
- Intellij 2022.2.1
- WSL Ubuntu 22.04 for GIT(GIT also available in CMD)
- Heroku CLI 
- Docker Desktop - running Postgres in a container for this task. 

I have experience with Markdown so this was no problem. I installed a VScode extension called Markdownlint which allows the user to preview the compiled markdown. Recommended. 

# Technical non-problems
I did not encounter any technical problems while setting up my environment. I have done this many times before and had my share of troubles related to it. 
Typical problems that I have encountered before is often related to java home not being set correctly, IntelliJ or MVN not able to find the project SDK.


# Validation of setup 

I validated my setup through different means, i checked that a simple hello world app ran in IntelliJ.

```
"C:\Program Files\Eclipse Adoptium\jdk-11.0.16.101-hotspot\bin\java.exe" "-javaagent:E:\Programs\IntelliJ IDEA 2022.2.1\lib\idea_rt.jar=50439:E:\Programs\IntelliJ IDEA 2022.2.1\bin" -Dfile.encoding=UTF-8 -classpath E:\dev\dat250-expass1\target\classes org.example.Main
Hello world!

Process finished with exit code 0
```

I also verified that Java and Maven were installed and working as expected through the terminal in IntelliJ.

```
PS E:\dev\dat250-expass1> java -version
openjdk version "11.0.16.1" 2022-08-12
OpenJDK Runtime Environment Temurin-11.0.16.1+1 (build 11.0.16.1+1)
OpenJDK 64-Bit Server VM Temurin-11.0.16.1+1 (build 11.0.16.1+1, mixed mode)

PS E:\dev\dat250-expass1> mvn -version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\ProgramData\chocolatey\lib\maven\apache-maven-3.6.3\bin\..
Java version: 11.0.10, vendor: Oracle Corporation, runtime: C:\Program Files\OpenJDK\openjdk-11.0.10_9
Default locale: no_NO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

I also verified this through means such as the command ```mvn clean install``` which builds successfully. 

# Heroku 
I have experience with Heroku and its CLI from a previous project and did not experience any problems during installation or setting up the new app or following the guide to create and deploy the heroku application. This application is currently running at:

https://pacific-garden-31847.herokuapp.com/ 

If the application is not starting immediately it could be because the dyno is sleeping and the website need to be refreshed to wake it up. The dynos goes to sleep after 30 minutes of idle time due to this being a free version of Heroku. 

I have not uploaded the github repository we cloned from heroku as this is unchanged from what was cloned. Instead i created my own repository for this hand in. 

Website url: https://pacific-garden-31847.herokuapp.com/  
