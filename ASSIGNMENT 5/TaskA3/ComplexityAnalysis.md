# A3 – Complexity Analysis

DAO and direct-SQL designs normally have the same database-operation asymptotic cost because the same SQL reaches the database.

- Indexed `findById`: typically O(log n) or database-engine dependent.
- Full table scan: O(n).
- Insert/update/delete: database-dependent; often approximately O(log n) with indexes plus row work.
- Space in the Java layer is normally O(1) for one-row operations.

The main difference is maintainability: DAO centralizes SQL and mapping, reducing the number of source locations affected by a schema change.
