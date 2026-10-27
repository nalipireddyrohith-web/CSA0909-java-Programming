# Task 2 – Choose the Data Representation

## Objective
Select Java data types and data structures for the parking system.

## Key Concepts
- Primitive and reference data types
- One-dimensional, two-dimensional and jagged arrays
- Type conversion and integer division
- `Scanner` input

## Required Evidence
- Explain types for slot index, registration number, ticket ID, entry time, duration, fee and charging energy.
- Justify a jagged array when each floor has a different number of slots.
- Explain the risk of losing precision when converting minutes to hours.
- Compare a jagged array with a flat array and `ArrayList`.

## Example
For a rule that charges every started hour, 61 minutes must be billed as 2 hours. Integer division `61 / 60` produces `1`, so use ceiling division for non-negative minutes: `(minutes + 59) / 60`.

## Complexity Analysis
A scan of all `N` slots takes `O(N)` time. A jagged array uses `O(N)` storage for the slots and supports unequal floor capacities.

## Result
The chosen data representation supports different floor sizes and avoids incorrect billing caused by integer truncation.
