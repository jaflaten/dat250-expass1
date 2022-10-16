# DAT250 Expass7 for Jørn-Are Flaten - 240425

## Experiment 1

I chose to use Docker instead of installing rabbit locally. Ran the application in detached mode using this command 

``` docker run -d -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management```


No issues occured. See screenshot. 

## Experiment 2
I chose Java as programming language. 

I found the dependencies on maven central and added to the pom instead of using the jars they suggested to download. This also gives me the latest version. 

as i'm using a docker container i executed a shell in the container and ran the rabbitmqctl command line tool from within the /opt/rabbitmq/sbin directory and listed the current queues. Results shown as screenshot. I could get into the container and get a shell with the following command ```docker exec -it rabbitmq sh```.

had some issues with compilation as suggested by the guide, so i didnt get to compile them as the guide said. Worked fine using intellij though.

## Experiment 3
Completing the steps of the tutorial and testing the features was not a problem. However following the guide when they do not explicitly say which file you should change is a bit more challenging. Not optimally written guide in my opnion. 

See screenshots for provided output. 

## Experiment 4
This was kind of interesting as we got to use the pub /sub pattern. I feel this can be useful for future applications and projects. 

No particular issues on this part. 

Screenshots provided to show output from the tutorial 



---

Code from all experiments is found in the sub directory *mqdemo* which is found in the same directory as this file. 

