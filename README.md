# tap-gds-ace-2023

Technical assessment for Govtech GDS-ACE division

It’s the time of the year again when Govtech holds its annual football championship where 12 teams will
compete for the grand prize of honour and glory. The teams will be split into 2 groups of 6 where each
team will play a match against every other team within the same group. The top 4 teams of each group
will then qualify for the next round. The ranking of the teams for each group will be evaluated using
these metrics in the following order:

1. Highest total match points. A win is worth 3 points, a draw is worth 1 point, and a loss is worth 0
   points.
2. If teams are tied, highest total goals scored.
3. If teams are still tied, highest alternate total match points. A win is worth 5 points, a draw is
   worth 3 points, and a loss is worth 1 point.
4. If teams are still tied, earliest registration date.

## Prerequisites

- npm 8.1.2
- Java 11+
- Maven 3.8.1
- MySQL 8.0
- MySQL Workbench 8.0 CE (Optional but recommended)
- IntelliJ IDEA 2021.3.2 (Optional but recommended)

## Set up

### General

- Clone the project into a local directory

### Database

- Connect to your MySQL instance, and create a new database called `football_championship`
  - Execute the following SQL statement: `CREATE DATABASE football_championship;`

### Backend

- Navigate to `backend` folder
- Reload the Maven dependencies in `pom.xml` if the project does not auto configure
- Update the `application.properties` file located in `src/main/resources/application.properties` to match your MySQL
  username and password
- Run `Tapgdsace2023Application.java` located in `src/main/java/com/btjl/tapgdsace2023`

Upon successful start, your `football_championship` database should be populated with the following tables:

- `footballmatches`
- `teams`
- `teams_footballmatches`

### Frontend

- Navigate to `frontend` folder
- Run `npm install` to download all the dependenices
- Run `npm start` to launch the frontend application

Upon successful start, your browser should open up a web page with the url: `http://localhost:3000`

## Usage

- The application flow is as such:
  - Team registration
  - Score input
  - Viewing of results
- Refer to `diagrams` for a visual look at the application's design
- Refer to `TAP 2023 GDS ACE Tech Assessment.pdf` for the testcases

## Note

- The application currently assumes a perfect input format by the user and does not report errors on the frontend
- In the event that the application fails due to some server-side errors, you may either:
  - Navigate to `http://localhost:3000/results/` in your browser and click on the red button. Ensure that both the backend and frontend servers are up.
  - Delete all tables from `football_championship` database and relaunch the backend
- By default, this application uses 3 ports. Please ensure that these ports are open and unused.
  - `8080` for the embedded Tomcat server
  - `3306` for MySQL
  - `3000` for webpack development server.

## License

[MIT](https://choosealicense.com/licenses/mit/)
