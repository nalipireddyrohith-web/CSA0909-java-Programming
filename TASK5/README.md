# Task 5 – Apply Static Members and the Object Life Cycle

## Objective
Identify data and behaviour that belong to the class as a whole rather than to individual objects.

## Key Concepts
- `static` fields and methods
- Ticket counters and occupancy
- Object references and garbage collection
- Passing and returning objects

## Required Evidence
- Explain why a shared ticket counter may be static.
- Identify suitable static methods or static initialisation.
- Explain what happens to a ticket after vehicle exit and when it becomes eligible for garbage collection.
- Compare a static ticket counter with a counter stored in each `ParkingFacility`.

## Complexity Analysis
A single static counter requires `O(1)` counter storage for `k` facility objects. Per-facility counters require `O(k)` storage and may produce duplicate ticket IDs unless IDs include a facility identifier. The `n` ticket objects still use `O(n)` space.

## Result
Static state is used only when sharing is intended, and object lifecycle is explained in relation to active tickets.
