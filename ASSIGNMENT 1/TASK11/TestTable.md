# Task 11 Test Table

| Test | Expected | Actual |
|---|---|---|
| Two-wheeler 60 min | Rs 10 | Rs 10 |
| Car 120 min | Rs 60 | Rs 60 |
| Unknown type | Reject | Reject |
| Duplicate registration | Reject | Reject |
| Zero-minute parking | Rs 0 | Rs 0 |
| Last free slot | Allocated | Allocated |

## Alternative data structures
- Array: exit search is O(n) in the number of active tickets.
- ArrayList: search is O(n), with dynamic resizing and easy insertion/removal.
- HashMap keyed by registration: expected O(1) lookup and O(n) space for n active tickets.

The implementation uses a `HashMap`, so exit processing is expected O(1) for ticket lookup plus O(1) slot release.
