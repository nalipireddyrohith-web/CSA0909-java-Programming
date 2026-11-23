# A3 – DAO Pattern

## Repeated steps
StudentDB, CourseDB and MarksDB repeat:
1. Obtain a JDBC connection.
2. Build SQL.
3. Create a statement/prepared statement.
4. Bind parameters.
5. Execute SQL.
6. Read ResultSet.
7. Convert rows to objects.
8. Close resources.
9. Handle SQL exceptions.

The changing parts are the entity type, table, columns, primary key and SQL-specific mapping.

## Generic interface

```java
public interface Dao<T, K> {
    void insert(T value) throws Exception;
    T findById(K id) throws Exception;
    java.util.List<T> findAll() throws Exception;
    void update(T value) throws Exception;
    void delete(K id) throws Exception;
}
```

`StudentDao` implements this interface and owns Student-specific SQL and row mapping.

## Why DAO helps

Database-specific code is isolated from the service and GUI layers. A column rename normally affects the DAO mapping and SQL instead of every GUI/service class that uses the entity.
