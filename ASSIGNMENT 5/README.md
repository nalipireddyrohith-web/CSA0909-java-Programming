# CSA09-192425115-Assignment5

## Programming in Java – Assignment 5 – CO5
### Data Persistence Engineering – Files and Databases

**Student:** NALIPI REDDY ROHITH  
**Register Number:** 192425115  
**Academic Year:** 2026–2027  
**Course:** Programming in Java (CSA09)

## Java version
Recommended: Java 17 or later.

Check:
```bash
java -version
javac -version
```

## Repository structure
- TaskA1–TaskA5: Part A design, pseudocode, reasoning and complexity analysis.
- TaskB1: File store, buffering, growth measurements and completed PassStore.
- TaskB2: SQL injection and damaged-input experiments.
- TaskB3: Statement, PreparedStatement, batch and transaction experiments.
- TaskB4: Migration, DatabaseMetaData and production decision.

## Important
The assignment requires individually executed code, actual output screenshots, and measurement data. The `screenshots/` folders are provided for the student's real execution evidence. Do not submit fabricated screenshots as execution evidence.

## Compile examples
```bash
javac TaskB1/src/*.java
java -cp TaskB1/src PassStore

javac TaskB2/src/*.java
java -cp TaskB2/src AdversarialTest
```

For JDBC tasks, install the MySQL Connector/J JAR and use the classpath containing that JAR.

macOS example:
```bash
javac -cp ".:mysql-connector-j-<version>.jar" TaskB3/src/*.java
java -cp "TaskB3/src:mysql-connector-j-<version>.jar" BatchTest
```

## SQL
Run:
`TaskB2/sql/database.sql` for the local security test database and
`TaskB3/sql/database.sql` for the bus-pass benchmark database.

## Evidence
After execution, place screenshots in the matching `screenshots/` folder and update `measurements.csv` with the measured values from the local machine.

## GitHub
Repository name:
`CSA09-192425115-Assignment5`
