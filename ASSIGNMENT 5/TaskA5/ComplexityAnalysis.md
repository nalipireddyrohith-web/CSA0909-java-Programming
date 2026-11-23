# A5 – Complexity Analysis

Two independent auto-commit updates can leave the first update committed if the second update fails. This can create an incorrect intermediate financial state.

A single transaction adds transaction-management overhead, but it provides atomicity: either both updates commit or neither does.

For two updates, the number of SQL operations remains O(1). The practical time cost is affected by logging, locking, fsync and network/database overhead. Correctness is more important than the small overhead for money movement.
