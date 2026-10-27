# Task 3 – Design the Control Logic

## Objective
Design and implement slot allocation, slot release and parking-fee calculation.

## Key Concepts
- Loops and conditional statements
- `break`, `continue` and `return`
- Validation and pseudocode

## Pseudocode: Allocate
1. Validate the vehicle number.
2. Visit each floor and each slot.
3. If a slot is free, store the vehicle number and return its floor and slot.
4. If no slot is free, return `null` or a suitable failure result.

## Pseudocode: Release
1. Validate the floor index.
2. Validate the slot index for that floor.
3. If the slot is already free, return `false`.
4. Otherwise clear the slot and return `true`.

## Expected Output
For the assignment's supplied `ParkingFacility.main()`:

```text
[0, 0]
[0, 1]
[1, 0]
null
true false false
[0, 1]
```

## Complexity Analysis
Scanning to allocate takes `O(N)` worst-case time for `N` total slots. Releasing a known slot takes `O(1)` time. A stack of free slot locations can make allocation and release `O(1)` on average, with additional `O(N)` storage.

## Result
Allocation returns the first free slot, reports a full facility and safely rejects invalid or repeated releases.
