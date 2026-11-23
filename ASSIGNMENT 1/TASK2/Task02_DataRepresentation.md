# Task 2 – Data Representation

| Field | Java type | Reason |
|---|---|---|
| Slot number | `int` | Whole-number index |
| Registration number | `String` | Contains letters and digits |
| Entry time | `LocalDateTime` | Represents date and time safely |
| Duration | `long` minutes | Whole minutes are sufficient for billing |
| Fee | `double` | Represents monetary calculation for this academic model |

A jagged `String[][]` is used because different floors may contain different numbers of slots.

### Integer division risk
If 90 minutes is written as `90 / 60`, the result is `1`, but billing by started hour requires 2 hours. The design uses `(minutes + 59) / 60`, which gives 2 using integer arithmetic.

### Alternative representations
A one-dimensional array can use `index = floor * slotsPerFloor + slot` only when each floor has the same number of slots. For unequal floors, a jagged array directly represents the facility and avoids complicated index conversion. `ArrayList<String[]>` is flexible but adds collection overhead.
