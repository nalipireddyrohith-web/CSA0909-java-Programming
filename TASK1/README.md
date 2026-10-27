# Task 1 – Understand the Problem and Identify the Objects

## Objective
Analyse the Campus Smart-Parking System and identify the objects that a Java program must model.

## Key Concepts
- Inputs and outputs
- Candidate classes and responsibilities
- Business rules and assumptions
- Object model versus parallel arrays

## Required Evidence
- Explain inputs and outputs.
- Identify candidate classes such as `ParkingFacility`, `Vehicle`, `ParkingSlot`, `ParkingTicket`, and `ParkingService`, and justify why each is needed.
- State rules such as one vehicle per slot, unique ticket numbers, valid releases, and duplicate-registration prevention.
- Record assumptions about time, rates, passes and slot compatibility.
- Compare object-based storage with parallel arrays for search time, memory and adding attributes.

## Complexity Analysis
Searching a registration number with a linear scan is `O(n)` in either design. Object-based design groups data and behaviour together; parallel arrays require aligned indexes and extra arrays when attributes are added.

## Result
The parking scenario is analysed and mapped to candidate classes, responsibilities, inputs, outputs and business rules.

## Evidence Files
Save your analysis and any diagrams in this folder. Add genuine screenshots if required by the faculty.
