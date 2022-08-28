# DAT250 Expass 2 hand in for Jørn-Are Flaten

# Install and technical issues

The installation of the required software went fine without any problems. Derby was the new thing to install, this was my first time using it, but 
installing it was fairly straight forward by following docs online. 

## Experiment 1

This was pretty straight forward to set up the project and follow the installation article. Had to modify some derby config to decide where to install it. 
No issues here. see further down under [Databases](#Databases) to see how i could verify the database content. 



## Experiment 2

This task required a bit more self studying and getting more familiar with the use of JPA bidirectional association annotations such as @ManyToMany and @OneToMany to be able to  work with it. I was unsure how to recreate a database table given the example in the assignment since i usually have Spring Boot to provide  CrudRepository which i can use to persist and read entities. However using the EntityManager to persist with was simple when i saw an example of how. 

I had an issue the first time I ran the program that said there was an incompatible mapping between Person and CreditCard, this was fairly obvious since i had used mappedBy on the wrong field name, quick fix. 

- In the Address.java class ```getNumber()``` i changed the return type to Integer as the test was expecting a Integer, not a String as a number. 
- In the same class i also changed the return type of getOwners to be a Set<Person> as the test was expecting a set of Person, not a String. 
- In the CreditCard.java class i also changed ```getBalance()``` and ```getLimit()``` to be integers because the test expected integers. 

After changing these values and small issues i was able to run the test and see it pass. The code is provided in a subfolder within the same folder as this file

# Code 

The code is provided in a subfolder of this folder. [/code/experiment1](/code/experiment1) and [/code/experiment2](/code/experiment2)

The required test for exp 2 is running green as expected. 

# Databases 

Figured out i could view the database tables through opening a shell with the  ```/derby/bin/ij``` file, connecting to my database and issuing queries i 
was able to view the content of the database. The screenshot provided called *exp 1 DB using shell.PNG*  shows how this is done. 

Another way i found the content of a DB was through IntelliJ with a plguin called "Database Navigator". I used the database tab it provided and connected to the database. From here i could either write queries or simply click on the different tables and query the content from them. 

Screenshots will be provided in the same directory as this file.


