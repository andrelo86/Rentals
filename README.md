# BIKE RENTALS

## Stack
  - Java 8+
  - Maven

## Setup
  - Download the source code
  - Set java jdk accordingly
  - Run mvn clean install in project root

 ## Execution
   - Application: Run Main java class to execute some configured rents
   - Tests: Run mvn clean test and see reports. You can run one by one from test classes.
   - Go to target -> site -> jacoco and open index.html in web browser to see coverage metrics


 ## Design
  **Rents:** Polymorphism
    - Rent: Abstract.
    - SingleRent: Rent. To Rent a bike. We can Rent by hor, day or week.
    - ComplexRent: Rent. To create a compound Rent with one or more SingleRent. We can apply promotions.

  **RentFactory:** To avoid new() when build Rents.


 **Promotions:** (Criteria)
    Kind of Criteria (Java Interface).Family promotion created.
    Can be added further promos.
    All promotions must implement complies to verify if applicable or not.

 **SysAdmin:** (Singleton)
    Basically it is the entry point. This will take the stock count and publish when you must return
    the rent.

 **Bike:** (Concrete)
    Just created to store date of rent and to control if its available or not.



 Miscellaneous:
   Google Style formatter
   Logger = Log4j
   TestNG
   Jacoco
   Sonar
   IO File = Properties
