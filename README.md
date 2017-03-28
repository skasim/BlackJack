# Blackjack

## Synopsis
A Java console game to demonstrate use of objects, interfaces, unit tests, and javadoc.

## Installation
Since this project is a demo, we can also learn to install Vagrant as use the Java program:

1. Create a JAR in the target directory by running: mvn clean package. This will create BlackJack-1.0-SNAPSHOT.jar
2. Run the program in a Vagrant box, so:
    1. Download and install [VirtualBox](https://www.virtualbox.org/wiki/Downloads)
    2. Download and install [Vagrant](https://www.vagrantup.com/docs/installation/)
    3. Find a Vagrant box to [install](http://www.vagrantbox.es/). I prefer CentOS7 minimal
    4. Create a directory for this Vagrant box to store the Vagrantfile
    5. cd to the directory and:
        1. vagrant box add {nameOfBox} {urlForBox}
        2. vagrant init {nameOfBox}
        3. vagrant up
    6. Find the conifgs for your Vagrant box with the command: vagrant ssh-config. Now you know the IP address,
    port, and where your vagrant secret key is located
    7. From your localbox, scp over the JAR to the Vagrant box:
        1. scp -2222 -i /path/to/secretKey /path/to/JAR vagrant@127.0.0.1:/home/vagrant
        2. The default password is vagrant
    8. In the vagrant box, find the JAR and run java -jar BlackJack-1.0-SNAPSHOT.jar to run the program
    9. To view the files in the JAR, run the command java -tf BlackJack-1.0-SNAPSHOT.jar
 

