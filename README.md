# Critter Chronologer Project Starter

Critter Chronologer a Software as a Service application that provides a scheduling interface for a small business that takes care of animals. This Spring Boot project will allow users to create pets, owners, and employees, and then schedule events for employees to provide services for pets.


## Getting Started

### Dependencies

* [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download) (or Ultimate) recommended 
* [Java SE Development Kit 21](https://openjdk.org/projects/jdk/21/)
* [Docker](https://www.docker.com/) (For running the database container)
* [Postman](https://www.getpostman.com/downloads/)

### Database Setup (Docker)

This branch is configured to use **PostgreSQL**. To set up and start the database using Docker, run:

```bash
docker run --name critter-db -e POSTGRES_DB=critter -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -p 5432:5432 -d postgres:16-alpine
```

This starts a PostgreSQL instance on port `5432` with database `critter` and user `postgres`/`password`, matching the primary settings in `src/main/resources/application.properties`.

### Installation and Execution

1. Clone or download this repository.
2. Navigate to the `starter/critter` directory:
   ```bash
   cd starter/critter
   ```
3. Run the Spring Boot application using the Maven wrapper:
   * **Linux/macOS**:
     ```bash
     ./mvnw spring-boot:run
     ```
   * **Windows**:
     ```cmd
     mvnw.cmd spring-boot:run
     ```
4. Open a browser and navigate to: [http://localhost:8082/test](http://localhost:8082/test)

You should see the message `"Critter Starter installed successfully"` in your browser.

## Testing

Once you have completed the database setup, you can run the unit tests to verify the functionality of the project.

### Running Tests via Command Line

1. Navigate to the `starter/critter` directory:
   ```bash
   cd starter/critter
   ```
2. Run the tests using the Maven wrapper:
   * **Linux/macOS**:
     ```bash
     ./mvnw clean test
     ```
   * **Windows**:
     ```cmd
     mvnw.cmd clean test
     ```


Alternatively, you can run the tests within your IDE by navigating to `src/test/java/com.udacity.jdnd.course3.critter/CritterFunctionalTest.java` and executing the test class. All 9 tests should now pass successfully.

### Tested Conditions
Tests will pass under the following conditions:

* `testCreateCustomer` - **UserController.saveCustomer** returns a saved customer matching the request
* `testCreateEmployee` - **UserController.saveEmployee** returns a saved employee matching the request
* `testAddPetsToCustomer` - **PetController.getPetsByOwner** returns a saved pet with the same id and name as the one saved with **UserController.savePet** for a given owner
* `testFindPetsByOwner` - **PetController.getPetsByOwner** returns all pets saved for that owner.
* `testFindOwnerByPet` - **UserController.getOwnerByPet** returns the saved owner used to create the pet.
* `testChangeEmployeeAvailability` - **UserController.getEmployee** returns an employee with the same availability as set for that employee by **UserControler.setAvailability**
* `testFindEmployeesByServiceAndTime` - **UserController.findEmployeesForService** returns all saved employees that have the requested availability and skills and none that do not
* `testSchedulePetsForServiceWithEmployee` - **ScheduleController.createSchedule** returns a saved schedule matching the requested activities, pets, employees, and date
* `testFindScheduleByEntities` - **ScheduleController.getScheduleForEmployee** returns all saved schedules containing that employee. **ScheduleController.getScheduleForPet** returns all saved schedules for that pet. **ScheduleController.getScheduleForCustomer** returns all saved schedules for any pets belonging to that owner.

### Postman
In addition to the included unit tests, a Postman collection has been provided. 

1. Open Postman.
2. Select the `Import` button.
3. Import the file found in this repository under `src/main/resource/Udacity.postman_collection.json`
4. Expand the Udacity folder in postman.

Each entry in this collection contains information in its `Body` tab if necessary and all requests should function for a completed project. Depending on your key generation strategy, you may need to edit the specific ids in these requests for your particular project.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework providing dependency injection, web framework, data binding, resource management, transaction management, and more.
* [Google Guava](https://github.com/google/guava) - A set of core libraries used in this project for their collections utilities.
* [H2 Database Engine](https://www.h2database.com/html/main.html) - An in-memory database used in this project to run unit tests.
* [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/) - JDBC Driver to allow Java to connect to PostgreSQL Server

## License

This project is licensed under the MIT License - see the [LICENSE.md]()
