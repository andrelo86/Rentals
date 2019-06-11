# BIKE RENTALS

## Stack
  - Java 8+
  - Maven

## Steps to execute
  - Download the source code
  - Set java jdk accordingly
  - Run mvn clean install in project root
  - Run Main class to execute some configured rents


## Design
**Rents:**  polymorphism
    - Rent: Abstract.
    - SingleRent: Rent. To Rent a bike. We can Rent by hor, day or week.
    - ComplexRent: Rent. To create a compound Rent with one or more SingleRent. We can apply promotions.
    - **RentFactory:** To avoid new() when build Rents.

  **Promotions:** Critero
    Kind of Criteria (Java Interface).Family promotion created.We can add further promos.
    All promotions must implement complies to verify if applicable or not.

  **SysAdmin:** Singleton
    Basically it is the entry point. This will take the stock count and publish when you must return
    the rent.

  **Bike:**
    Just created to store date of rent and to control if its available or not.



  Miscellaneous:
    Code style = Google formatter
    Logger = Log4j
    Test runner context = TestNG
    IO File = Propertie
