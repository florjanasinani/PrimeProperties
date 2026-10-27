# PrimeProperties
A desktop application for managing real estate listings, written in Java with a Swing graphical interface. I built it as a learning project to practise object-oriented programming. The interface and code comments are in Albanian.

What it does
Registers apartments, villas and business premises
Calculates the total price (price per m² × area)
Searches by city, zone or ID, and filters by price and area

OOP in this project
Inheritance: Apartament, Vile and AmbientBiznesi extend the base class Prona
Encapsulation: private fields with getters and setters
Polymorphism: one list holds all property types, each with its own toString()

Built with: Java, Swing

Run it
Open the project in NetBeans and run student.PrimeProperties, or from the command line:

bash

javac -d build/classes src/student/*.java

java -cp build/classes student.PrimeProperties


Data is stored in memory only, so it is lost when the app closes.
