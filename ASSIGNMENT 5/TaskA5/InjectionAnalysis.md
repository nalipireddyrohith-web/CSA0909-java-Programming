# A5.2 – SQL Injection

The unsafe query concatenates user-controlled text into SQL. A crafted ID or password can change the SQL syntax, potentially turning a password check into a condition that is always true.

Example conceptual input:
`' OR '1'='1`

When inserted into a concatenated SQL statement, the quotes can terminate the intended string and add a true condition.

## Safe design

```java
String sql = "SELECT * FROM users WHERE id=? AND pwd=?";
try (PreparedStatement ps = connection.prepareStatement(sql)) {
    ps.setString(1, id);
    ps.setString(2, pwd);
    try (ResultSet rs = ps.executeQuery()) {
        return rs.next();
    }
}
```

The database receives the SQL structure separately from the parameter values, preventing the input from being interpreted as SQL syntax.
