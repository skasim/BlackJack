# BlackJack

## Synopsis
A Java console game to demonstrate use of objects, interfaces, unit tests, and javadoc.

## Installation
Since this project is a demo. Here is a somewhat convoluted, but fun (really!), way to run 
this program:

1. Create a JAR in the target directory by running: mvn clean package
2. Run the program in a Vagrant box, so:
    1. Download and install [VirtualBox](https://www.virtualbox.org/wiki/Downloads)
    2. Download and install [Vagrant](https://www.vagrantup.com/docs/installation/)
    3. Find a Vagrant box to [install](http://www.vagrantbox.es/), I prefer Centos7 minimal
    4. Create a directory for this Vagrant box to store Vagrantfile
    5. cd to the directory and:
        1. vagrant box add {nameOfBox} {urlForBox}
        2. vagrant init {nameOfBox}
        3. vagrant up
    6. Now, find out the conifgs for your vagrant box with the command: vagrant ssh-config. Now you know the IP address,
    port, and where your vagrant secrety key is located
    7. From your localbox, scp over the JAR to the Vagrant box:
        1. scp -2222 -i /path/to/secretKey /path/to/JAR vagrant@127.0.0.1:/home/vagrant
        2. The default password is vagrant
 

